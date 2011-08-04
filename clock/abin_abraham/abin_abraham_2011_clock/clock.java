import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/*<applet code="clock.class" height=100 width=400>
</applet>*/


public class clock extends Applet implements ActionListener
{
Label lblHrs=new Label("Hrs");
Label lblMins=new Label("Mins");
TextField txtHrs=new TextField("",200);
TextField txtMins=new TextField("",200);
TextField txtTime=new TextField("",400);
Button btnGetTime=new Button("Get Time");



int hrs,mins;
String h="",m="";
String hrstring[]={"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve"};
String minstring[]={"five","ten","quarter","twenty","twenty-five","half-past"};



String near[]={"after ","about ","around "};
String correct[]={"exactly ","precisely ","now ",""};
String far[]={"almost ","nearly "};



String disp="";


Random rand=new Random();
int r=rand.nextInt(3);




public void init()
{
setLayout(new BorderLayout());
Panel p=new Panel();
p.setLayout(new GridLayout(4,2));
add(p,BorderLayout.CENTER);
p.add(lblHrs);
p.add(txtHrs);
p.add(lblMins);
p.add(txtMins);
p.add(btnGetTime);
p.add(txtTime);
}
public void start()
{
btnGetTime.addActionListener(this);
}
public void stop()
{
btnGetTime.addActionListener(null);
}





//time display logic

public void actionPerformed(ActionEvent e)
{
disp="its ";

hrs=Integer.valueOf(txtHrs.getText());
mins=Integer.valueOf(txtMins.getText());



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

//done

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







txtTime.setText(disp);


}




}