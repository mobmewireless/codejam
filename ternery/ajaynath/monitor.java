import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Frame;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.util.Date;
import java.awt.Font;
import java.io.*;
import java.util.Scanner;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent {

  public void paint(Graphics g) {
    g.setFont(new Font("Timew New Roman",3,20));
    g.setColor(new Color(210,0,0));
    g.drawString("1.txt",160,140);
    g.drawString("2.txt",360,140);
    g.drawString("3.txt",560,140);
    g.drawString("4.txt",160,340);
    g.drawString("5.txt",360,340);
    g.drawString("6.txt",560,340);
    g.drawString("7.txt",160,540);
    g.drawString("8.txt",360,540);
    g.drawString("9.txt",560,540);
    g.setColor(new Color(210,210,0));
    g.drawString("Count",160,200);
    g.drawString("Count",360,200);
    g.drawString("Count",560,200);
    g.drawString("Count",160,400);
    g.drawString("Count",360,400);
    g.drawString("Count",560,400);
    g.drawString("Count",160,600);
    g.drawString("Count",360,600);
    g.drawString("Count",560,600);
    g.setColor(new Color(0,0,0));
   int [] ss=new int[9];
       
for(int i=0;i<9;i++) 
{ss[i]=0;
	 try

             {

                 FileReader fileRead = new FileReader(String.valueOf(i+1)+".txt");
                 Scanner fileInput = new Scanner(fileRead);

while (fileInput.hasNextLine())
{
ss[i]++;
fileInput.nextLine();
 }  fileRead.close();           
 // counter.read(fileInput);
             }
             catch (FileNotFoundException fnfe)
             {
               }  
catch(IOException dd) {
}

}
 g.drawString(String.valueOf(ss[0]),150,240);
 g.drawString(String.valueOf(ss[1]),350,240);
 g.drawString(String.valueOf(ss[2]),550,240);
 g.drawString(String.valueOf(ss[3]),150,440);
 g.drawString(String.valueOf(ss[4]),350,440);
 g.drawString(String.valueOf(ss[5]),550,440);
 g.drawString(String.valueOf(ss[6]),150,640);
 g.drawString(String.valueOf(ss[7]),350,640);
 g.drawString(String.valueOf(ss[8]),550,640);

   // g.drawString(String.valueOf(ss),550,640);
    g.setColor(new Color(150,150,150));
    

    g.drawRect(100,100,200,200);
    g.drawRect(500,100,200,200);
    g.drawRect(300,100,200,200);
    g.drawRect(100,300,200,200);
    g.drawRect(500,300,200,200);
    g.drawRect(300,300,200,200);
    g.drawRect(100,500,200,200);
    g.drawRect(500,500,200,200);
    g.drawRect(300,500,200,200);
try{    Thread.sleep(900);
repaint(0);
}
catch(InterruptedException dd)
{}
  }
}

public class monitor {
  public static void main(String[] a) {
    JFrame window = new JFrame("MONITER");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 900, 800);
    window.getContentPane().add(new MyCanvas());
    window.setVisible(true);
  }
}
