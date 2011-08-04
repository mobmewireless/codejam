/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sandboxclient;

/**
 *
 * @author Sanoob
 */

import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class sandbox_client extends JFrame implements ActionListener,Runnable ,WindowListener{

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
       recieve_message();
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == go){

            //output.append(" click");
           send_command(command.getText(),0);
            //write_repeat();


        }


    }

    private JLabel title;
    private JLabel cmdrec;
    private JLabel out;
    private JTextField command;
    private JTextArea output;
    private JScrollPane scrl;
    private JFrame main;
    private JLabel null_lab = new JLabel("");
    private JButton go;
    private String help;
    public sandbox_client() {

    main = new JFrame("Sandbox client");
        main.setVisible(true);
        main.setSize(640 , 480);
        main.setLayout(new BorderLayout(5 , 5));
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
            catch(Exception e){
           Toolkit.getDefaultToolkit().beep();
           //option.showMessageDialog(this, "Error :\n"+e,"UI error",JOptionPane.ERROR_MESSAGE);
        }


        help = "\t\t\tHELP\nCommand List\nlist - Lists all the files in the directory the server is running on.\npwd - Print the path of the directory the server is running on.\n" +
                "cat <filename> - Print the contents of the filename given as argument.\nrm <filename> - Delete the filename given as argument.\ntouch <filename> <content> - Create a file with name and content given as argument." +
                "\ntime - Returns the current time on the server.";

        String s2 = "<html> <font color=black><h2>&nbsp;Sandbox Client</h2></font>";
        title = new JLabel(s2);
        cmdrec = new JLabel("Command : ");
        out = new JLabel("Output :");

        command = new JTextField();
        output = new JTextArea();
        output.setEditable(false);
        scrl = new JScrollPane(output);
        go = new JButton("    go    ");
        go.addActionListener(this);
        JLabel not = new JLabel("");
        JPanel go_p = new JPanel(new BorderLayout(5,5));
        go_p.add(go , BorderLayout.EAST);
        go_p.add(not , BorderLayout.CENTER);

        JPanel cmd_pan = new JPanel(new BorderLayout(5 , 5));
        cmd_pan.add(cmdrec , BorderLayout.NORTH);
        cmd_pan.add(command , BorderLayout.CENTER);
        JLabel null_lab1 = new JLabel("");
        cmd_pan.add(go_p , BorderLayout.SOUTH);
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

      public void send_command(String cmd ,int opt){

          try{
               // Socket s=new Socket("192.168.122.222",3000);
                Socket s=new Socket("localhost",3000);
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);

               if(opt == 0){
                if((cmd.equalsIgnoreCase("LIST")) || (cmd.equalsIgnoreCase("PWD")) || (cmd.toLowerCase().contains("cat")) || (cmd.toLowerCase().contains("rm")) || (cmd.toLowerCase().contains("touch")) ||(cmd.equalsIgnoreCase("TIME"))){

                if(cmd.toLowerCase().contains("cat")){
                        String fd = cmd.substring(3, cmd.length());
                        //System.out.println("no split :"+fd.trim());
                        String fname = fd.trim();
                        if(fname.matches("")){
                            JOptionPane.showMessageDialog(main, "File name missing !! \n please specify filename along with command 'cat'\n eg: cat abc.txt " ,"error",JOptionPane.ERROR_MESSAGE);
                            pw.println("");
                        }
                        else{
                           pw.println(cmd.toLowerCase());
                        }
                }
                if(cmd.toLowerCase().contains("rm")){
                        String fd = cmd.substring(2, cmd.length());
                        //System.out.println("no split :"+fd.trim());
                        String fname = fd.trim();
                        if(fname.matches("")){
                            JOptionPane.showMessageDialog(main, "File name missing !! \n please specify filename along with command 'rm'\n eg: rm abc.txt " ,"error",JOptionPane.ERROR_MESSAGE);
                            pw.println("");
                        }
                        else{
                           pw.println(cmd.toLowerCase());
                        }
                }

                if(cmd.toLowerCase().contains("touch")){

                         pw.println(cmd.toLowerCase());
                    //String fd = cmd.substring(2, cmd.length());
                        //System.out.println("no split :"+fd.trim());
                  /*  try{
                        String split [] = {"","","",""};
                        split = cmd.split(" ");
                        String second = "";
                        String third = "";
                        second = split[1];
                        third = split[2];
                        System.out.println("command :"+split[0]+" fname :"+second+" content :"+third);
                        String fname = "";
                        if((second.matches("")) || (third.matches(""))){
                            JOptionPane.showMessageDialog(main, "Syntax error !! \n please specify filename and content along with command 'touch'\n eg: touch abc.txt hello " ,"error",JOptionPane.ERROR_MESSAGE);
                            pw.println("");
                        }

                        else{
                           pw.println(cmd.toLowerCase());
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }*/
                }


                else {
                    pw.println(cmd.toLowerCase());
                }

                }
                else if(cmd.equalsIgnoreCase("Help")){
                    output.append(help);
                }
                else{
                    JOptionPane.showMessageDialog(main, "invalid command !! \n please type 'help' for command list " ,"error",JOptionPane.ERROR_MESSAGE);
                }
               }
               else if(opt==1){
                   String message = "no "+cmd;
                   pw.println(message);
               }
                s.close();
          }
          catch(Exception e){
              e.printStackTrace();
          }

      }


     public void recieve_message(){
         try{

                ServerSocket ss=new ServerSocket(3001);
                StringBuffer strb = new StringBuffer();
                String cont;
                while(true){
                    Socket s=ss.accept();
                    BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

                        String s1=br.readLine();
                   // System.out.println(s1);

                    output.append("\n"+s1);


                     }


         }
             catch(Exception e){
                 e.printStackTrace();
                 System.out.print("error:"+e);
             }
     }

     public void write_repeat(){
         //System.out.println("generated: "+ genarate_random());
         String fname = genarate_random()+".txt";
         send_command(fname, 1);

     }
     public String genarate_random(){
     SecureRandom random = new SecureRandom();


     return new BigInteger(130, random).toString(32).substring(0, 9);


     }

      public static void main(String[] args) {

          final sandbox_client client = new sandbox_client();
          Thread t = new Thread(client);
          t.start();
          ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
               client.write_repeat();
           }
        };
        Timer timer = new Timer(60000, actionListener);
        timer.start();
   }

}
