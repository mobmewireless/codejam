#include   <stdio.h>
#include   <dos.h>
#include<conio.h>
void second(int);
int main(void)
{  double j;
   struct  time t;
   while(1)
   {
   gettime(&t);
   printf("\n\n\n\n\n\t");
	   if(t.ti_hour>12)
	  t.ti_hour=t.ti_hour-12;

	  if((t.ti_min>42 && t.ti_min<48) || (t.ti_min>57 && t.ti_min<60))
	  {
	   if(t.ti_hour==12)
	   t.ti_hour=t.ti_hour-12;
	  t.ti_hour=t.ti_hour+1;
	  }


	  switch(t.ti_hour)
	  {
	  case 1: second(t.ti_min);
		 printf("ONE");

		 break;
	  case 2:  second(t.ti_min);
		 printf("TWO");

		 break;
	  case 3: second(t.ti_min);
		 printf("THREE");

		 break;
	  case 4:  second(t.ti_min);
		 printf("FOUR");

		 break;
	  case 5: second(t.ti_min);
		 printf("FIVE");

		 break;
	  case 6: second(t.ti_min);
		 printf("SIX");

		 break;
	  case 7: second(t.ti_min);
		 printf("SEVEN");

		 break;
	  case 8:  second(t.ti_min);
		 printf("EIGHT");

		 break;
	  case 9: second(t.ti_min);
		 printf("NINE");

		 break;
	  case 10:second(t.ti_min);
		  printf("TEN");
		  break;
	  case 11: second(t.ti_min);
		  printf("ELEVEN");

		  break;
	  case 12:second(t.ti_min);
		  printf("TWELVE");

		  break;
	  }
	  for(j=0;j<100000;j+=1);
	  clrscr();
	  }
	  getch();
   return 0;
}
   void second(int a)
{
int k;
int flag=0;
k=a%10;
if(k>2 && k<5)
{
flag=1;
a=a+5-k;
printf("IT'S  ALMOST   ");
}
if(k<=2 && k>0)
{
flag=1;
a=a-k;
printf("IT'S  ABOUT    ");
}
if(k>7 && k<10)
{
flag=1;
a=a+10-k;
printf("IT'S  ALMOST   ");
}
if(k<=7 && k>5)
{
flag=1;
a=a-(k-5);
printf("IT'S  ABOUT   ");
}
switch(a)
{
case 5:if(flag==0)
       printf("IT'S EXACTLY ");
       printf("FIVE PAST ");
	break;
case 10:if(flag==0)
       printf("IT'S EXACTLY ");
	printf("TEN PAST ");
       break;
case 15:if(flag==0)
       printf("IT'S EXACTLY ");
	printf("QUARTER  PAST ");
	break;

case 20: if(flag==0)
       printf("IT'S EXACTLY ");
	 printf("TWENTY  PAST ");
	break;

case 25: if(flag==0)
       printf("IT'S EXACTLY ");
	printf("TWENTY FIVE  PAST ");
	break;

case 30:if(flag==0)
       printf("IT'S EXACTLY ");
	printf("HALF  PAST ");
	break;

case 35:if(flag==0)
       printf("IT'S EXACTLY ");
	printf("THIRTY FIVE  PAST ");
	break;

case 40:if(flag==0)
       printf("IT'S EXACTLY ");
	printf("FOURTY  PAST ");
	break;

case 45: if(flag==0)
       printf("IT'S EXACTLY ");
	printf("FIFTEEN TO ");
	break;

case 50:if(flag==0)
       printf("IT'S EXACTLY ");
	printf("FIFTY  PAST ");
	break;

case 55:if(flag==0)
       printf("IT'S EXACTLY ");
	printf("FIFTY FIVE  PAST ");
	break;

case 60: if(flag==0)
       printf("IT'S EXACTLY ");
break;
}

}