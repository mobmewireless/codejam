#include<conio.h>
#include<stdio.h>
#include<graphics.h>
#include<dos.h>
#include<bios.h>


void main()
{

  struct time TIME;
  //int gdriver = DETECT, gmode, errorcode;
  int hh,mm,ss,i;

  clrscr();

  //initgraph(&gdriver, &gmode,"C:\TC\BGI");
  //errorcode = graphresult();
  //if (errorcode != grOk) printf("Graphics Driver Error");

 //setbkcolor(7);



  //printf("The hour is : %d\n",hh);
  //printf("The minute is : %d\n",mm);
  //printf("The second is : %d\n",ss);
  do
  {
  gettime(&TIME);
  printf("The hour is : %d\n",TIME.ti_hour);
  printf("The minute is : %d\n",TIME.ti_min);
  printf("The second is : %d\n",TIME.ti_sec);
  printf("the time in our clock is %d Hours...",TIME.ti_hour);

  if(TIME.ti_sec>45||TIME.ti_sec>=15)
  printf("EXACTLY %d Minutes...",TIME.ti_min);
  else if(TIME.ti_sec>15||TIME.ti_sec<=45)
  printf("PAST %d Minutes...",TIME.ti_min);
    delay(100);
  clrscr();
 }while(1);
 getch();
 }