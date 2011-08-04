#include<stdio.h>
#include<time.h>
#include<conio.h>
#include<process.h>

time_t raw_time;
int min,hour;
struct tm * time_info;


void print_minutes();
void print_hour();

void main()
{
 int i,limit_in_minutes,start_time;
 double j;
 printf("Enter the amount of time the clock should run before exiting in minutes.\n");
 scanf("%d",&limit_in_minutes);
 time(&raw_time);
 time_info=localtime(&raw_time);
 start_time=time_info->tm_min;


 for(i=0;;i++)                        //infinite loop for clock.
 {
  time(&raw_time);
  time_info=localtime(&raw_time);
  min=time_info->tm_min;
  if((min-(start_time+limit_in_minutes))==0)
	exit(1);
  hour=time_info->tm_hour;
  print_minutes();
  print_hour();
  for(j=0;j<3200000;j++)             //idle state so that output remains dispalyed.
  {}
  clrscr();                          //clear screen to display new value of time.
 }
}

void print_minutes()                 //display a phrase corresponding to current minute.
{
 if(min>=0&&min<=10)
  printf("It's just past ");
 else if(min>=11&&min<=14)
  printf("The time is almost a quarter past ");
 else if(min>=15&&min<=23)
  printf("It's a quarter past ");
 else if(min>=24&&min<=29)
  printf("It's almost half an hour past ");
 else if(min>=30&&min<=37)
  printf("The time's half an hour past ");

 /*The value of hour is incremented in the follwing "else if" cases since time is being
	spelled out relative to the next hour rather than the current one.*/

 else if(min>=38&&min<=42)
 {
  hour=hour+1;
  printf("Almost twenty minutes to ");
 }
 else if(min>=43&&min<=50)
 {
  hour=hour+1;
  printf("It's a quarter to ");
 }
 else if(min>=51&&min<=55)
 {
  hour=hour+1;
  printf("It's almost five minutes to ");
 }
 else
 {
  hour=hour+1;
  printf("Almost ");
 }
}

void print_hour()                    //display a phrase corresponding to the current hour.
{
 switch(hour)
 {
  case 0:printf("midnight");
			break;
  case 1:printf("one after midnight");
			break;
  case 2:printf("two after midnight");
			break;
  case 3:printf("three early in the morning");
			break;
  case 4:printf("four early in the morning");
			break;
  case 5:printf("five early in the morning");
			break;
  case 6:printf("sunrise");
			break;
  case 7:printf("seven in the morning");
			break;
  case 8:printf("eight in the morning");
			break;
  case 9:printf("nine");
			break;
  case 10:printf("ten");
			break;
  case 11:printf("eleven");
			break;
  case 12:printf("noon");
			break;
  case 13:printf("one after noon");
			break;
  case 14:printf("two after noon");
			break;
  case 15:printf("three");
			break;
  case 16:printf("four in the evening");
			break;
  case 17:printf("five in the evening");
			break;
  case 18:printf("sunset");
			break;
  case 19:printf("seven");
			break;
  case 20:printf("eight");
			break;
  case 21:printf("nine");
			break;
  case 22:printf("ten. time to go to bed.");
			break;
  case 23:printf("eleven late in the night");
			break;
 }
}
