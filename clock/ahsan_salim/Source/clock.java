import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class clock extends JFrame implements WindowListener
{
	Image img;
	String result;
	clock()
	{
		setSize(640,480);
		setVisible(true);
	}
	public static String hourCheck( int h)
	{
		if(h==1)
			return "One";
		if(h==2)
			return "Two";
		if(h==3)
			return "Three";
		if(h==4)
			return "Four";
		if(h==5)
			return "Five";
		if(h==6)
			return "Six";
		if(h==7)
			return "Seven";
		if(h==8)
			return "Eight";
		if(h==9)
			return "Nine";
		if(h==10)
			return "Ten";
		if(h==11)
			return "Eleven";
		if(h==12)
			return "Twelve";
		else
			return "One";
	}
	public static void main(String args[])
	{
		clock cl = new clock();
		cl.minuteCheck();
		
	}
	public void minuteCheck()
	{
		while(1<2)
		{
		Date D = new Date();
		if(D.getMinutes()==0)
			result = hourCheck(D.getHours()) +" O' Clock";
		else if(D.getMinutes()==10)
			result = "Its Exactly Ten Past "+hourCheck(D.getHours());
		else if(D.getMinutes()==15)
			result = "Its Exactly Quarter Past "+hourCheck(D.getHours());
		else if(D.getMinutes()==20)
			result = "Its Exactly Twenty Past "+hourCheck(D.getHours());
		else if(D.getMinutes()==30)
			result = "Its Exactly Half Past "+hourCheck(D.getHours());
		else if(D.getMinutes()==40)
			result = "Its Exactly Fourty Past "+hourCheck(D.getHours());
		else if(D.getMinutes()==45)
			result = "Its Exactly Quarter To "+hourCheck(D.getHours()+1);
		else if(D.getMinutes()==30)
			result = "Its Exactly Ten Before "+hourCheck(D.getHours()+1);
		else if(D.getMinutes()>3&& D.getMinutes()<=5)
			result = "Its Almost Ten Past "+hourCheck(D.getHours());
		else if(D.getMinutes()>5&& D.getMinutes()<=9)
			result = "Its Almost Ten Past "+hourCheck(D.getHours());
		else if(D.getMinutes()>10&& D.getMinutes()<=11)
			result = "Its Almost Ten Past "+hourCheck(D.getHours());
		else if(D.getMinutes()>11&& D.getMinutes()<=17)
			result = "Its Almost Quarter Past "+hourCheck(D.getHours());
		else if(D.getMinutes()>17&& D.getMinutes()<=24)
			result = "Its Almost Twenty Past "+hourCheck(D.getHours());
		else if(D.getMinutes()>24&& D.getMinutes()<=34)
			result = "Its Almost Half Past "+hourCheck(D.getHours());
		else if(D.getMinutes()>34&& D.getMinutes()<=41)
			result = "Its Almost Fourty Past "+hourCheck(D.getHours());
		else if(D.getMinutes()>41&& D.getMinutes()<=47)
			result = "Its Almost Quarter To "+hourCheck(D.getHours()+1);
		else if(D.getMinutes()>47&& D.getMinutes()<=57)
			result = "Its Almost Ten To "+hourCheck(D.getHours()+1);
		else if(D.getMinutes()>57&& D.getMinutes()<=59)
			result = "Its Almost "+hourCheck(D.getHours()+1);
	    if(D.getMinutes()>0&& D.getMinutes()<=3)
			result = "Its Almost Quarter to "+hourCheck(D.getHours()+1);
		
		try{
		Thread.sleep(1000);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Thread wont sleep");
		}
		repaint();
		}
	}
	public void paint(Graphics g)
	{
		img = Toolkit.getDefaultToolkit().createImage("background.png");
		g.drawImage(img, 0, 0, null);
		Font font = new Font("ComicSans", Font.BOLD, 40);
		g.setFont(font);
		g.drawString(result, 100,100);
		
	}
	public void windowClosing(WindowEvent we)
	{
		dispose();
	}
	public void windowDeactivated(WindowEvent we)
	{
		
	}
	public void windowActivated(WindowEvent we)
	{
		
	}
	public void windowDeiconified(WindowEvent we)
	{
		
	}
	public void windowIconified(WindowEvent we)
	{
		
	}
	public void windowClosed(WindowEvent we)
	{
		dispose();
	}
	public void windowOpened(WindowEvent we)
	{
		
	}
}