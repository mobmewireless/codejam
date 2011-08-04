
package USSDEngine;

import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author karthik
 * This is the main class that handles all the USSD requests
 */
public class USSD {

	/**
	 * This is a custom class. This is load the settings file(config/settings) into the memory
	 * and return a Properties object. The 'settings' file has the name of the service to be hosted(explained in the design)
	 */
    static Settings settings;
    
    /**
     * This object loads a Service into memory from the FSM text file saved in the folder 'USSDModules'
     * Any service can be expressed as a FSM using key value pairs.
     * This key-value information is sufficient to generate responses
     */
    Properties moduleObj;
    
    /**
     * This acts as a hashmap that saves the state of any client
     * Hashmap is  STRING -> STRING
     * The kep for each entry is a string obtained by concatenating the 
     * Number and the session.
     * If num=12123 and session is QWE, and if he just submitted his first request, then
     * the entry saved in the hashmap is (123123_QWE, level0)
     * We use both phone number and session because, the same number can send multiple
     * requests, there by multiple session ID's. This hashmap saves a separate entry for both of them.
     */
    Properties States;
    
    Logger log = Logger.getAnonymousLogger();

    public USSD() {
        
        settings = new Settings();
        States = new Properties();
    }



    /**
     * For the first input by a user, his number and phone number is taken 
     * and an entry is added in the hashmap as (num_session, level0)
     * Level0 indicates that he just received the first main menu.
     * 
     * @param session
     * @param num
     * @return
     */
    public String startModule(String session,String num) {

            log.info("startModule()");
            String module = settings.USSDSettings.getProperty("module","none");
            if(module.equals("none"))
                return "No Servies for today!";

            moduleObj = loadModule(module);
            if(moduleObj == null)
                return "No Servies for today!";

            String text = moduleObj.getProperty("level0");
            String state = num+ "_"+ session;
            log.info("Saving State (" + state+ ") as level0");
            States.setProperty(num+ "_"+ session,"level0");
            return text;
    }

    
    /**
     * Given a module name, this loads its FSM into the memory
     * @param module
     * @return
     */
    Properties loadModule(String module) {
        log.info("lasses/ussdengineoadModule()");
        Properties todaysModule = new Properties();


                try {
                        String file1="/"+module;
                        log.info("Loading module : "+module);
                        todaysModule.load(this.getClass().getResourceAsStream(file1));

                } catch (Exception e) {

                        //e.printStackTrace();
                        log.severe(e.getMessage());
                        return null;
                }
        return todaysModule;
    }

    /**
     * This function fetches the users current state, then processes his input
     * If the input is valid, the user moves to the next state. This change is 
     * updated in the hashmap 'States'.
     * 
     * @param input
     * @param session
     * @param num
     * @return
     */
    public String getResponse(String input,String session,String num) {
        log.info("getResponse");
        String state = States.getProperty(num+ "_"+ session);
        String response = moduleObj.getProperty(state+ "_" + input,moduleObj.getProperty("error"));
        
        
        if(response.equals("invalid"))
        	return response;
        
        state = state+input;
        log.info("Saving State (" + num+ "_"+ session+ ") as "+ state );
        States.setProperty(num+ "_"+ session, state);
        return response;
    }

}
