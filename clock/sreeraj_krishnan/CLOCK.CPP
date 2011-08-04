#include<iostream.h>
#include <stdio.h>
#include <time.h>
#include<string.h>
#include<conio.h>
char s1[15],s2[30],s3[5],s4[30];

void min(int min)
{
switch(min)
{
case 1:
case 2:
case 6:
case 7:
case 51:
case 52: strcpy(s1,"AROUND");
	 break;

case 3:
case 4:
case 13:
case 14:
case 18:
case 19:
case 33:
case 34:
case 38:
case 39:
case 43:
case 44:
case 48:
case 49: strcpy(s1,"NEARLY");
	  break;
case 5: strcpy(s1,"NOW");
	break;
case 8:
case 9:
case 23:
case 24:
case 28:
case 29:
case 53:
case 54:
case 58:
case 59: strcpy(s1,"ALMOST");
	break;
case 10:
case 20: strcpy(s1,"PRECISELY");
	break;
case 11:
case 12: 
case 16:
case 17:
case 21:
case 22:
case 26:
case 27:
case 31:
case 32: strcpy(s1,"AFTER");
	break;
case 36:
case 37:
case 41:
case 42:
case 46:
case 47:
case 56:
case 57: strcpy(s1,"ABOUT");
	break;
default: strcpy(s1," ");
	break;
}

if(min>30)
{
strcpy(s3,"TO");
min=60-min;
}
else
strcpy(s3,"PAST");

switch(min)
{
case 3:
case 4:
case 5:
case 6:
case 7:strcpy(s2,"FIVE");
	break;
case 8:
case 9:
case 10:
case 11:
case 12:strcpy(s2,"TEN");
	break;
case 13:
case 14:
case 15:
case 16:
case 17:strcpy(s2,"QUATER");
	break;
case 18:
case 19:
case 20:
case 21:
case 22:strcpy(s2,"TWENTY");
	break;
case 23:
case 24:
case 25:
case 26:
case 27:strcpy(s2,"TWENTY FIVE");
	break;
default: strcpy(s2," ");
	break;
}
}
void hour(int hour)
{
switch(hour)
{
case 1:strcpy(s4,"ONE");
	break;
case 2:strcpy(s4,"TWO");
	break;
case 3:strcpy(s4,"THREE");
	break;
case 4:strcpy(s4,"FOUR");
	break;
case 5:strcpy(s4,"FIVE");
	break;
case 6:strcpy(s4,"SIX");
	break;
case 7:strcpy(s4,"SEVEN");
	break;
case 8:strcpy(s4,"EIGHT");
	break;
case 9:strcpy(s4,"NINE");
	break;
case 10:strcpy(s4,"TEN");
	break;
case 11:strcpy(s4,"ELEVEN");
	break;
case 12:strcpy(s4,"TWELVE");
	break;
case 13:strcpy(s4,"THIRTEEN");
	break;
case 14:strcpy(s4,"FOURTEEN");
	break;
case 15:strcpy(s4,"FIFTEEN");
	break;
case 16:strcpy(s4,"SIXTEEN");
	break;
case 17:strcpy(s4,"SEVENTEEN");
	break;
case 18:strcpy(s4,"EIGHTEEN");
	break;
case 19:strcpy(s4,"NINETEEN");
	break;
case 20:strcpy(s4,"TWENTY");
	break;
case 21:strcpy(s4,"TWENTY ONE");
	break;
case 22:strcpy(s4,"TWENTY TWO");
	break;
case 23:strcpy(s4,"TWENTY THREE");
	break;
case 0:strcpy(s4,"ZERO");
	break;
}
}
void main ()
{
  time_t rawtime;
  struct tm  *t;
  clrscr();
  time ( &rawtime );
  t= localtime ( &rawtime );
  cout<<"Time in 24 hrs : "<<t->tm_hour<<" : "<<t->tm_min<<" : "<<t->tm_sec;
  min(t->tm_min);
  hour(t->tm_hour);
  cout<<"\n IT'S "<<s1<<" "<<s2<<" "<<s3<<" "<<s4;
     
  
}