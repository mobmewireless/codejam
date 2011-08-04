import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Frame;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.util.Date;
import java.awt.Font;

class clock extends Frame implements WindowListener
	{
  public void windowOpened(WindowEvent e){}

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     */
    public void windowClosing(WindowEvent e){System.exit(0);}

    /**
     * Invoked when a window has been closed as the result
     * of calling dispose on the window.
     */
    public void windowClosed(WindowEvent e){}

    /**
     * Invoked when a window is changed from a normal to a
     * minimized state. For many platforms, a minimized window 
     * is displayed as the icon specified in the window's 
     * iconImage property.
     * @see java.awt.Frame#setIconImage
     */
    public void windowIconified(WindowEvent e){}

    /**
     * Invoked when a window is changed from a minimized
     * to a normal state.
     */
    public void windowDeiconified(WindowEvent e){}

    /**
     * Invoked when the Window is set to be the active Window. Only a Frame or
     * a Dialog can be the active Window. The native windowing system may
     * denote the active Window or its children with special decorations, such
     * as a highlighted title bar. The active Window is always either the
     * focused Window, or the first Frame or Dialog that is an owner of the
     * focused Window.
     */
    public void windowActivated(WindowEvent e){}

    /**
     * Invoked when a Window is no longer the active Window. Only a Frame or a
     * Dialog can be the active Window. The native windowing system may denote
     * the active Window or its children with special decorations, such as a
     * highlighted title bar. The active Window is always either the focused
     * Window, or the first Frame or Dialog that is an owner of the focused
     * Window.
     */
    public void windowDeactivated(WindowEvent e){}


///
private static final String[] ONES = {
		"Zero", "One", "Two", "Three", "Four", "Five",
		"Six", "Seven", "Eight", "Nine" };
	private static final String[] TEENS = {
		"Ten", "Eleven", "Twelve", "Thirteen", null, "Fifteen",
		null, null, "Eighteen", null };
	private static final String[] TENS = {
		null, null, "Twenty", "Thirty", "Forty", "Fifty",
		"Sixty", "Seventy", "Eighty", "Ninety" };

	public static String numberToWords(int number) {
		

if(number==15||number==45)
return ("a quarter");
else if(number==30)
return("a half");
if (number<10) {
			return ONES[number];
		} else if (number<20) {
			int n = number - 10;
			String words = TEENS[n];
			return words==null ? ONES[n]+"teen" : TEENS[n];
		} else {
			int n = number % 10;
			return TENS[number/10] +
				(n==0 ? "" : (" " + numberToWords(n)));
		}
	}
///
public static void main(String s[])
		{
		//Date nd=new Date();
		Frame f=new Frame("skjhsdfu");
		f.resize(1200,600);
		f.show();
		clock n=new clock();
		f.addWindowListener(n);		
f.setIgnoreRepaint(true);		
int hours,min,sec;
String hr,mm,ss;	
Graphics g=f.getGraphics();
g.setFont(new Font("Times New Roman",1,30));
String disp=" ";
String wish=" ";
String swish=" ";

g=f.getGraphics();
g.setFont(new Font("Times New Roman",1,30));
clock b=new clock();
while(true)
{
String sdisp=disp;

Date nd=new Date();
hours=nd.getHours();
min=nd.getMinutes();
sec=nd.getSeconds();
swish=wish;
if(hours>=5&&hours<=10)
	wish="GOOD MORNING HAVE A NICE DAY";
else if(hours>=11&&hours<=13)
	wish="ITS NOON!!";
else if(hours>=14&&hours<=15)
	wish="GOOD AFTER NOON!!";
else if(hours>=16&&hours<=19)
	wish="GOOD EVENING";
else if(hours>=20&&hours<=23)
	wish="GOOD NIGHT SWEET DREAMS!!";
else 
	wish="Ohh ITS EARLY MORNING HAVE SOME SLEEP";

if(hours>12)
hours-=12;
if(hours==0)
hours=12;
if(min==0&&min<=36)
	disp="Its exactly "+b.numberToWords(hours)+" O clock";
else if(min%5==0&&min!=0 &&min<=36)
	disp="Its exactly "+b.numberToWords(min)+" past "+b.numberToWords(hours)+" O clock";

else if(min<=35)
	{
if ((min%5==1||min%5==2)&&min<=5)
	disp="Its shortly after "+b.numberToWords(hours)+" O clock";
else if(min%5==1&&min>5)
	disp="Its shortly after "+b.numberToWords(min-1)+" past "+b.numberToWords(hours)+" O clock";

else if(min%5==2&&min>5)
	disp="Its shortly after "+b.numberToWords(min-2)+" past "+b.numberToWords(hours)+" O clock";

else if(min%5==3)
	{
if(min%5==3)
disp="Its around "+b.numberToWords(min+2)+" past "+b.numberToWords(hours)+" O clock";


	}//else if((min%5==3)||(min%5==2&&sec>=30)&&min>5)
	//disp="Its around "+b.numberToWords(min+2)+" past //"+b.numberToWords(hours)+" O clock";
else if(min%5==4)
	disp="Its almost "+b.numberToWords(min+1)+" past "+b.numberToWords(hours)+" O clock";



	}
else
	{if(hours==12)hours=0;

if(min>=56)
	{
if(min==56)
disp="Its around "+b.numberToWords(5)+" to "+b.numberToWords(hours+1)+" O clock";
else if(min==57||min==58)
disp="Its almost "+b.numberToWords(hours+1)+" O clock";
else
disp="Its nearly "+b.numberToWords(hours+1)+" O clock";



	}
else
{if(min%5==0)
	{
	disp="Its exactly "+b.numberToWords(60-min)+" to "+b.numberToWords(hours+1)+" O clock";

	}
else if(min%5==1)
	disp="Its after "+b.numberToWords(61-min)+" to "+b.numberToWords(hours+1)+" O clock";
else if((min%5==3)||(min%5==2&&sec>=30))
	{
int nn;
if(min%5==3)
	nn=58-min;
else
	nn=57-min;
	disp="Its almost "+b.numberToWords(nn)+" to "+b.numberToWords(hours+1)+" O clock";
	}


else if(min%5==4)
	disp="Its nearly "+b.numberToWords(59-min)+" to "+b.numberToWords(hours+1)+" O clock";

	

	}
}
if(!(sdisp.equals(disp)))
{
g.setColor(new Color(255,255,255));
g.drawString(disp.toUpperCase(),300,300);
//g.setColor(new Color(100,100,100));
g.drawString(sdisp.toUpperCase(),300,300);
//f.repaint();
}
if(!(swish.equals(wish)))
{
g.setColor(new Color(255,255,255));
g.drawString(wish,300,100);
//g.setColor(new Color(100,100,100));
g.drawString(swish,300,100);
//f.repaint();
}

g.setColor(new Color(100,100,100));
g.drawString(disp.toUpperCase(),300,300);
g.setColor(new Color(0,255,0));
g.drawString(wish,300,100);


}




		}
}
