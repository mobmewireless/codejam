/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Client implements Runnable{
  
    public static void main(String arg[]){
        new Thread(new Client()).start();
    }

    @Override
    public void run() {
        try {
            Scanner console=new Scanner(System.in);
            Socket socket=null;
            System.out.println("enter host/ip adress");
            String host=console.nextLine();
            for(int port=3000;port<3005;port++){
               try{ 
                    socket=new Socket(host,port);
                    break;
               }
               catch(Exception e){
               }
            }
            if(socket==null){
                System.out.println("Can't connect to server");
                System.exit(0);
            }
            
           OutputStreamWriter pw=new OutputStreamWriter(socket.getOutputStream());
           ObjectInputStream ois=new ObjectInputStream(socket.getInputStream()); 
           String command="";
            do{
                System.out.println("\n please enter command");
                command=console.nextLine();
                pw.write(command+"\n");
                pw.flush();
                String response=(String)ois.readObject();
                System.out.print(response);
              
            }while(!command.equals("exit"));
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
