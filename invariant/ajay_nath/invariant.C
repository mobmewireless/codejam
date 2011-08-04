#include<graphics.h>
#include<stdio.h>
#include<conio.h>
int asc(int[4],int);
void table();
float barfinder(int);
void main()
	{
	int gdriver = DETECT, gmode, errorcode;
	int var=1002,tvar;
	int n[4],i,m,v,c,count;
	char a[20];
	int ff[10];
	int xx=0,yy=0,ghh=0;
	float he;
	initgraph(&gdriver, &gmode, "c:\\tc\\bgi");
	settextstyle(1,0,1);
	outtextxy(200,10,"The number of iterations are");
	settextstyle(0,0,0);
	setcolor(7);
	outtextxy(220,10,"");
	for(i=0;i<10;i++)
	 ff[i]=0;

	for(var=1000;var<=9998;var++)
	 { setcolor(15);


	   tvar=var;
	   count=0;
	   do
	   {

	   for(i=0;i<4;i++)
	    {
	    n[i]=tvar%10;
	    tvar=tvar/10;
	    }
	  if(!(n[3]==n[2]&&n[3]==n[1]&&n[3]==n[0]))
	    {
	    count++;
	    v=asc(n,0);
	    c=asc(n,1);
	    }
	  else
	    break;
	  tvar=v-c;

	  }while(tvar!=6174);
	  ff[count]+=1;

	  if(xx==600)
	   {xx=0;
	   yy+=10;
	   }
	    if(yy==400)
	   {
	   outtextxy(260,440,"PRESS A KEY TO CONTINUE");
	   getch();
	   cleardevice();

	   yy=0;
	   xx=0;
	  }

	  if(count!=0)
	  {setcolor(9);
	  sprintf (a,"%d",var);
	  outtextxy(0+xx,38+yy,a);
	  setcolor(8);
	  sprintf (a,"-%d",count);
	  outtextxy(30+xx,38+yy,a);
	  xx+=50;
	  }
	  }
	settextstyle(3,0,1);
	getch();
	cleardevice();
	table();

	for(i=1;i<8;i++)
	{
	  sprintf (a,"%d",ff[i]);
	  outtextxy(400,138+i*30,a);
	  sprintf (a,"%d",i);
	  outtextxy(400-150,138+i*30,a);
	}
	setcolor(10);
	outtextxy(400-10,135,"COUNT");
	outtextxy(400-200,135,"ITERATIONS");
	getch();
	cleardevice();
	setcolor(15);
	line(50,460,595,460);
	line(50,460,50,10);
	setfillstyle(5, 10);
	settextstyle(2,1,5);
	for(i=1;i<9;i++)
	{
	setcolor(15);
	line(50,460-i*50,35,460-i*50);
	setcolor(8);
	sprintf (a,"%d",(250*i));
	outtextxy(20,445-i*50,a);

	}
	settextstyle(2,0,5);

	for(i=0;i<=6;i++)
	{
	setcolor(15);
	line(50+(i+1)*75,460,50+(i+1)*75,470);
	setcolor(8);
	if(i!=0)
	{sprintf (a,"%d",i);
	outtextxy(10+i*75,467,a);
	}
	}
	setcolor(15);
	for(i=1;i<8;i++)
	{
	he=barfinder(ff[i])*50;
	bar3d(50+(i-1)*75, 460-he, 125+(i-1)*75,459, 10, 1);
	setfillstyle(i+3, i+1);
	}
	getch();
	cleardevice();
	setfillstyle(1,1);
	setcolor(1);
	settextstyle(2,0,4);
	he=(ff[3]/8991.0)*360;
	pieslice(320,240,0+ghh,he+ghh,200);
	setcolor(15);
	sprintf (a,"THREE - %f%",(int)ff[3]/8991.0*100);
	outtextxy(380,160,a);

	ghh+=he;
	setfillstyle(1,2);
	setcolor(2);
	he=(ff[7]/8991.0)*360;
	pieslice(310,240,0+ghh,he+ghh,200);
	setcolor(15);
	sprintf (a,"SEVEN - %f%",(int)ff[7]/8991.0*100);
	outtextxy(180,160,a);

	ghh+=he;
	setfillstyle(1,3);
	setcolor(3);
	he=(ff[6]/8991.0)*100.0*3.6;
	pieslice(305,245,0+ghh,he+ghh,200);
	setcolor(15);
	sprintf (a,"SIX - %f%",(int)ff[6]/8991.0*100);
	outtextxy(120,240,a);

	ghh+=he;
	setfillstyle(1,4);
	setcolor(4);
	he=(ff[5]/8991.0)*100.0*3.6;
	pieslice(315,245,0+ghh,he+ghh,200);
	setcolor(15);
	sprintf (a,"FIVE - %f%",(int)ff[5]/8991.0*100);
	outtextxy(220,380,a);

	ghh+=he;
	setfillstyle(1,5);
	setcolor(5);
	he=(ff[4]/8991.0)*100.0*3.6;
	pieslice(320,250,0+ghh,he+ghh,200);
	setcolor(15);
	sprintf (a,"FOUR - %f%",(int)ff[4]/8991.0*100);
	outtextxy(350,380,a);

	ghh+=he;
	setfillstyle(1,6);
	setcolor(6);
	he=(ff[2]/8991.0)*100.0*3.6;
	pieslice(325,245,ghh,ghh+he,200);
	setcolor(15);
	sprintf (a,"TWO - %f%",(int)ff[2]/8991.0*100);
	outtextxy(420,300,a);

	ghh+=he;
	setfillstyle(1,11);
	setcolor(11);
	he=(ff[1]/8991.0)*100.0*3.6;
	pieslice(325,242,0+ghh,he+ghh,200);
	setcolor(15);
	sprintf (a,"ONE - %f%",(int)ff[1]/8991.0*100);
	outtextxy(420,260,a);

	getch();
	}
float barfinder(int val)
	{
	float f;
	f=(val/250.0);
	return f;

	}
int asc(int a[4],int f)
	{
	int i,j,temp,no=0;
	for(i=0;i<4;i++)
	 for(j=i+1;j<4;j++)
	   if((a[i]>a[j]&&f==1)||(a[i]<a[j]&&f==0))
	     {
	     temp=a[i];
	     a[i]=a[j];
	     a[j]=temp;
	     }
	 no+=(a[0]*10)+a[1];
	 no=(no*10)+a[2];
	 no=(no*10)+a[3];
	 //printf("\n%d",no);
	 return no;
       }


void table()
	{ int i=0,j=0;
	  setcolor(8);
	  rectangle(150,130,325,170);
	 rectangle(325,130,500,170);
	 // rectangle(150,100,500,140);
	  for( i=1;i<=7;i+=1)
	  {
	  rectangle(150,140+i*30,325,170+i*30);
	  rectangle(325,140+i*30,500,170+i*30);



	  }
	}