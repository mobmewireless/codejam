#include<conio.h>
#include <time.h>
#include<stdio.h>
#include<iostream.h>
void tellb(int);
void tellb(int);
void tellb(int h)
{     
switch(h)
{
         case 1:cout<<"one 'o' clock ";break;
         case 2:cout<<"two 'o' clock ";break;
         case 3:cout<<"Three  'o' clock ";break;
         case 4:cout<<"Four 'o' clock ";break;
         case 5:cout<<"Five 'o' clock  ";break;
         case 6:cout<<"Six 'o' clock  ";break;
         case 7:cout<<"Seven 'o' clock  ";break;
         case 8:cout<<"Eight 'o' clock  ";break;
         case 9:cout<<"Nine 'o' clock  ";break;
         case 10:cout<<"Ten 'o' clock  ";break;
         case 11:cout<<"Eleven 'o' clock  ";break;
         case 12:cout<<"Twelve 'o' clock  ";break;
         }
}
void tella(int h)
{     
switch(h)
{
//         case 1:cout<<"one 'o' clock ";break;
         case 1:cout<<"Two 'o' clock ";break;
         case 2:cout<<"Three  'o' clock ";break;
         case 3:cout<<"Four 'o' clock ";break;
         case 4:cout<<"Five 'o' clock  ";break;
         case 5:cout<<"Six 'o' clock  ";break;
         case 6:cout<<"Seven 'o' clock  ";break;
         case 7:cout<<"Eight 'o' clock  ";break;
         case 8:cout<<"Nine 'o' clock  ";break;
         case 9:cout<<"Ten 'o' clock  ";break;
         case 10:cout<<"Eleven 'o' clock  ";break;
         case 11:cout<<"Twelve 'o' clock  ";break;
         }
}

int main(void)
{
int h,m,temp,h24;
time_t now=time(NULL);
struct tm *tm=localtime(&now);
cout<<"Current time is :";
printf("Hour=%d  ",tm->tm_hour);
printf("Min=%d\n",tm->tm_min);
h24=tm->tm_hour;
if(h24>12)
h=h24-12;
else h=h24;
m=tm->tm_min;
char a[4];

         temp=m;
         if(0<=temp && temp<=10)
         {cout<<"its About ten minute past ";
         tellb(h);}
         if(10<temp && temp<=25)
         {cout<<"its Almost Fifteen minute past ";
         tellb(h);}
         if(25<temp && temp<=40)
         {cout<<"its About  Half past ";
         tellb(h);}
         if(40<temp && temp<=50)
         {cout<<"its Almost Fifteen  minute to ";
         tella(h);}
         if(50<temp && temp<=60)
         {
                    cout<<"its Almost to  ";
         tella(h);}

         

getch();
return 0;
}
