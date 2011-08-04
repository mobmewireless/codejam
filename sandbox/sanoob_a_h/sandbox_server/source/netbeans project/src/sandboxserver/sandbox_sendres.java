/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sandboxserver;

import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Sanoob
 */
public class sandbox_sendres {

    public void send_result(String message){
        try{
               // Socket s=new Socket("192.168.122.222",3000);
                Socket s=new Socket("localhost",3001);
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
               // String cmd = command.getText();
                System.out.println(message);
                pw.println(message);

                s.close();
            }
          catch(Exception e){
              e.printStackTrace();
          }


    }



}
