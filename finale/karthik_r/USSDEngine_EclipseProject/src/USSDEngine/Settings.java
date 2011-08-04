
package USSDEngine;

/**
 *
 * @author Karthik
 */


import java.io.IOException;
import java.util.Properties;
//import java.util.logging.Logger;

/**
 * @author k4rthikR
 *
 */
public class Settings {

        //Logger log = Logger.getAnonymousLogger();
        public Properties USSDSettings;
        

        public Settings() {
                USSDSettings = new Properties();
                

                try {
                        String file1="/settings";
                        //log.info("Loading Properties file : "+file1);
                        USSDSettings.load(this.getClass().getResourceAsStream(file1));
                        
                } catch (IOException e) {

                        //e.printStackTrace();
                        //log.severe(e.getMessage());
                }

        }

}
