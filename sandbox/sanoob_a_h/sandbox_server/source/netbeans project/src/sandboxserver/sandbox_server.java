/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sandboxserver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Sanoob
 */
public class sandbox_server extends JFrame implements Runnable , WindowListener{

    public void windowActivated(WindowEvent e) {

    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowDeactivated(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowOpened(WindowEvent e) {

    }



    public void run() {
             recieve_command();
    }

    private JLabel title;
    private JLabel cmdrec;
    private JLabel out;
    private JTextField command;
    private JTextArea output;
    private JScrollPane scrl;
    private JFrame main;
    private JLabel null_lab = new JLabel("");
    private sandbox_sendres newk = new sandbox_sendres();

    public sandbox_server() {

        main = new JFrame("Sandbox server");
        main.setVisible(true);
        main.setSize(640 , 480);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();                        
        int w = main.getSize().width;
        int h = main.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        main.setLocation(x, y);
        main.setLayout(new BorderLayout(5 , 5));
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
            catch(Exception e){
           Toolkit.getDefaultToolkit().beep();
           //option.showMessageDialog(this, "Error :\n"+e,"UI error",JOptionPane.ERROR_MESSAGE);
        }
        String s2 = "<html> <font color=black><h2>&nbsp;Sandbox Server</h2></font>";
        title = new JLabel(s2);
        cmdrec = new JLabel("Command recieved :");
        out = new JLabel("Output :");

        command = new JTextField();
        command.setEditable(false);
        output = new JTextArea();
        output.setEditable(false);
        scrl = new JScrollPane(output);

        JPanel cmd_pan = new JPanel(new BorderLayout(5 , 5));
        cmd_pan.add(cmdrec , BorderLayout.NORTH);
        cmd_pan.add(command , BorderLayout.CENTER);
        JLabel null_lab1 = new JLabel("");
        cmd_pan.add(null_lab1 , BorderLayout.SOUTH);
        //cmd_pan.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.lightGray, Color.gray));

        JPanel out_pan = new JPanel(new BorderLayout(5 , 5));
        out_pan.add(out , BorderLayout.NORTH);
        out_pan.add(scrl , BorderLayout.CENTER);
        out_pan.add(null_lab , BorderLayout.SOUTH);
        out_pan.setBorder(BorderFactory.createLineBorder(Color.GRAY , 1));

        JPanel north_pan = new JPanel(new BorderLayout(5 , 5));
        north_pan.add(title , BorderLayout.NORTH);
        north_pan.add(cmd_pan , BorderLayout.SOUTH);
        north_pan.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.lightGray, Color.gray));

        main.add(north_pan , BorderLayout.NORTH);
        main.add(out_pan , BorderLayout.CENTER);

        //main.pack();
        main.validate();

        main.addWindowListener(this);


    }


    public void recieve_command(){

        try{

                ServerSocket ss=new ServerSocket(3000);

                while(true){
                    Socket s=ss.accept();
                    BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

                    String s1=br.readLine();
                   // String s2=br.readLine();

                    System.out.println("Message : "+s1);
                    if(s1.equals("list")){
                        command.setText(s1);
                        output.append("Files in the server directory : \n");
                        newk.send_result("Files in server directory : \n");
                        getFilelist(1);


                    }
                    else if(s1.equals("pwd")){
                        command.setText(s1);
                        getFilelist(0);
                    }
                    else if(s1.contains("cat")){
                        command.setText(s1);

                       // String [] fname = s1.split(" ");
                        //System.out.println("message :"+fname[0]+" filename :"+fname[1]);
                        String fd = s1.substring(3, s1.length());
                        System.out.println("no split :"+fd.trim());
                        String fname = fd.trim();
                        String cont = read_file(fname);
                        output.append("\n Content of file "+fname+" :\n");
                        output.append(cont);
                        newk.send_result("Content of file "+fname+" :\n");
                        newk.send_result(read_file(fname));
                    }
                    else if(s1.contains("rm")){
                        command.setText(s1);
                        String fd = s1.substring(2, s1.length());
                        String fname = fd.trim();
                        sandbox_file rem = new sandbox_file();
                        if(rem.remove_file(fname)){
                            output.append("File "+fname+" deleted...\n");
                            newk.send_result("File "+fname+" deleted...\n");
                        }
                        else
                        {
                             output.append("File deletion failed..\n");
                             newk.send_result("File deletion failed..\n");
                        }
                    }
                    else if(s1.contains("touch")){
                        command.setText(s1);
                        String spl[] = {"" , "" , ""};
                        try{
                            spl = s1.split(" ");
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        sandbox_file newf = new sandbox_file();
                        if(newf.create_file(spl[1] , spl[2])){
                            output.append("file "+spl[1]+" created");
                            newk.send_result("file "+spl[1]+" created");
                        }
                        else{
                            output.append("file not created");
                            newk.send_result("file not created");
                        }
                    }
                    else if(s1.contains("time")){
                        command.setText(s1);

                        sandbox_time time = new sandbox_time();
                        output.append("current time :\n"+time.ret_time()+"\n");

                        newk.send_result("Current Server Time : "+time.ret_time());
                    }
                     else if(s1.contains("no")){
                         String ran[] = s1.split(" ");
                         System.out.println("file name :"+ran[1]);
                         sandbox_file newf = new sandbox_file();
                         sandbox_time time = new sandbox_time();
                         newf.create_file(ran[1], time.ret_time() );

                     }


                 }
             }
             catch(Exception e){
                 e.printStackTrace();
                 System.out.print("error:"+e);
             }


    }

    public void getFilelist(int opt){

        //URL url = getClass().getResource("");

        String currentDir = new File(".").getAbsolutePath();
        System.out.println(currentDir);
      if(opt==1){
        File f = new File(currentDir);
        String [] s = f.list();
        for(int i=0 ; i<s.length ; i++){
            File f2 = new File(s[i]);
            if(!f2.isDirectory()){
               System.out.println(""+s[i]);
               output.append(s[i]+"\n");
               newk.send_result(s[i]+"\n");
            }
        }
    }
      else if(opt == 0){
          output.append("Current Server directory : \n"+currentDir);
      }

    }

    public String read_file(String fname){
        String content = null;
        StringBuffer strbuf = new StringBuffer();
        try{

            FileInputStream fstream = new FileInputStream(fname);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String read;

            while ((read = br.readLine()) != null)   {

                  strbuf.append(read);
            }

            in.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            content = strbuf.toString();
        return(content);
    }



    public static void main(String[] args) {

        sandbox_server ser = new sandbox_server();
        Thread t1 =new Thread(ser);
        t1.start();

    }
}
