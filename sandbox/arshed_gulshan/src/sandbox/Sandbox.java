/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Sandbox implements Runnable{

    static ServerSocket server=null;
    Socket socket=null;
    public Sandbox(){

        
    }
   static void connect(){
        int port;
        for(port=3000;port<3005;port++){ //trying 5 ports to establish connection
            try{
                server=new ServerSocket(port);
                System.out.println("Server started at port "+port);
                break;
            }
            catch(Exception e){
                
            }
        }
        if(server==null){System.out.println("Can't establish connection"); System.exit(0);}        
        
        while(true){
            try {
                
                Socket sock=server.accept();
                System.out.println("new client connected");
                Sandbox box=new Sandbox();
               box.socket=sock;
                Thread thread=new Thread(box);
                thread.start();
            } catch (IOException ex) {
                Logger.getLogger(Sandbox.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    String list(){
       File dir = new File("");
       dir=new File(dir.getAbsolutePath());
       String fileName[]=dir.list();
       String line="";
       for(String i:fileName)
           line=line+"\n"+i;
        return line;
    }
    String pwd(){
        File dir=new File("");
        return dir.getAbsolutePath();
    }
    String cat(String name){
        FileInputStream file = null;
        String line="";
        try {
            file = new FileInputStream(name);
            Scanner scan=new Scanner(file);
            while(scan.hasNextLine()){
                line=line+"\n"+scan.nextLine();
            }
            return line;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sandbox.class.getName()).log(Level.SEVERE, null, ex);
            return line;
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(Sandbox.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    String rm(String name){
        File file=new File(name);
        if(file.delete())
            return "deleted succesfully";
        else
            return "failed to delete";
    }
    String touch(String name,String content){
        try {
            FileWriter writer=new FileWriter(name);
            writer.write(content);
            writer.flush();
            return "File created and contents added succesfully";
        } catch (IOException ex) {
            Logger.getLogger(Sandbox.class.getName()).log(Level.SEVERE, null, ex);
            return "failed";
        }
    }
    String time(){
          Calendar calendar = new GregorianCalendar();
          String am_pm;
          int hour = calendar.get(Calendar.HOUR);
          if(hour==0)
              hour=12;
          int minute = calendar.get(Calendar.MINUTE);
          int second = calendar.get(Calendar.SECOND);
          if(calendar.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
          else
            am_pm = "PM";
          return  ""+hour + ":"  + minute + ":" + second + " " + am_pm; 
    }
    public static void main(String[] args) {
         Sandbox.connect();
         //System.out.println("Directory " + new Sandbox().time());
    }

    @Override
    public void run() {
        
        ObjectOutputStream oos=null;
        try {
            Scanner scan=new Scanner(socket.getInputStream());
            oos=new ObjectOutputStream(socket.getOutputStream());
            String command;
          
           do{
                command=scan.nextLine();
                System.out.println("command:"+command);
                try{
                if(command.indexOf("rm")==0){
                    String response=rm(command.split(" ")[1]);
                    oos.writeObject(response);
                    oos.flush();
                    continue;
                }
                if(command.indexOf("cat")==0){
                    String response=cat(command.split(" ")[1]);
                    oos.writeObject(response);
                    oos.flush();
                    continue;
                }
                if(command.equals("list")){
                    String response=list();
                    oos.writeObject(response);
                    oos.flush();
                    continue;
                }
                if(command.equals("pwd")){
                    String response=pwd();
                    oos.writeObject(response);
                    oos.flush();
                    continue;
                }
                if(command.equals("exit")){
                    socket.close();
                    return;
                }
                if(command.equals("time")){
                     String response=time();
                    oos.writeObject(response);
                    oos.flush();
                    continue;
                }
                if(command.indexOf("touch")==0){
                    String token[]=command.split(" ");
                   String response=touch(token[1],command.substring(token[0].length()+token[1].length()+2));
                    oos.writeObject(response);
                    oos.flush();
                    continue;
                }
                }
                catch(IOException e){
                    oos.writeObject("File Not found");
                    oos.flush();
                    continue;
                }
                catch(Exception e){
                    oos.writeObject("Usage Error");
                    oos.flush();
                    continue;
                }
                oos.writeObject("Invalid Command\n");
                oos.flush();
           }while(true);
        } catch (Exception ex) {
          
         
        }
       
    }
}
