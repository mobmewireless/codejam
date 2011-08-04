import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.lang.*;

/*<applet code="clock.class" height=100 width=400>
</applet>*/


public class clock extends Applet implements Runnable
{


int hrs,mins,flag=0;
String h="",m="";
String hrstring[]={"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve"};
String minstring[]={"five","ten","quarter","twenty","twenty-five","half-past"};

String near[]={"after ","about ","around "};
String correct[]={"exactly ","precisely ","now ",""};
String far[]={"almost ","nearly "};

String disp="";


String time="";
Date date=new Date();
DateFormat format= DateFormat.getTimeInstance();


Random rand=new Random();
int r=rand.nextInt(3);

Thread timerthread=null;






public void getDisp()
{
disp="its ";

hrs=date.getHours();
mins=date.getMinutes();


if(hrs>12)
hrs-=12;
else if(hrs==0)
hrs=12;



if((mins==0)||(mins==15)||(mins==30)||(mins==45))
{
disp+=correct[rand.nextInt(4)];
}



if(mins==15)
{
disp+="quarter past ";
disp+=hrstring[hrs-1];
}
else if(mins==30)
{
disp+="half-past ";
disp+=hrstring[hrs-1];
}
else if(mins==45)
{
disp+="quarter to ";
disp+=hrstring[hrs];
}
else if(mins==0)
{
disp+=hrstring[hrs-1];
disp+=" o'clock";
}


else if((mins%5==0)&&(mins<30))
{
disp+=correct[rand.nextInt(4)];
disp+=minstring[mins/5-1];
disp+=" past ";
disp+=hrstring[hrs-1];
}
else if((mins%5==0)&&(mins>30))
{
disp+=correct[rand.nextInt(4)];
disp+=minstring[12-mins/5-1];
disp+=" to ";
disp+=hrstring[hrs];
}



//upto 30 minutes

else if(mins<3)
{
disp+="just past ";
disp+=hrstring[hrs-1];
}



else if(((mins%10<3)||((mins%10>5)&&(mins%10<8)))&&(mins<30))
{
disp+=near[rand.nextInt(3)];
disp+=minstring[mins/5-1];
disp+=" past ";
disp+=hrstring[hrs-1];
}
else if((((mins%10>=3)&&(mins%10<5))||(mins%10>=8))&&(mins<30))
{
disp+=far[rand.nextInt(2)];
disp+=minstring[mins/5];
disp+=" past ";
disp+=hrstring[hrs-1];
}




//above 30 minutes

else if(mins>=58)
{
disp+="almost ";
disp+=hrstring[hrs];
}
else if((mins>30)&&(mins<33))
{
disp+="just after ";
disp+=minstring[12-mins/5-1];
disp+=" past ";
disp+=hrstring[hrs-1];
}



else if(((mins%10<3)||((mins%10>5)&&(mins%10<8)))&&(mins>30))
{
disp+=near[rand.nextInt(3)];
disp+=minstring[12-(mins/5)-1];
disp+=" to ";
disp+=hrstring[hrs];
}
else if((((mins%10>=3)&&(mins%10<5))||(mins%10>=8))&&(mins>30))
{
disp+=far[rand.nextInt(2)];
disp+=minstring[12-(mins/5)-2];
disp+=" to ";
disp+=hrstring[hrs];
}




}











public void start()
{
timerthread=new Thread(this,"clock");
timerthread.start();
}


public void stop()
{
if(timerthread==null)
return;
timerthread=null;
}


public void run()
{
while(timerthread!=null)
{


repaint();


try
{
timerthread.sleep(501);
}
catch(InterruptedException e)
{
System.out.println("Exception: "+e);
}
}
}


public void paint(Graphics g)
{

date.setTime(System.currentTimeMillis());
String time=format.format(date);
if((date.getSeconds()==0)||flag==0)
{
getDisp();
flag=1;
}
g.drawString(time,50,20);
g.drawString(disp,50,40);


}


}