#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
#define N 4


void Convert(int nNumber, char String[]) //converts number to its english equivalents
{

	
	
	if(nNumber > 9 && 20 > nNumber)
	{
		switch(nNumber)
		{
			case 10: strcpy(String,"ten"); break;
			case 11: strcpy(String,"eleven"); break;
			case 12: strcpy(String,"twelve"); break;
			case 13: strcpy(String,"thirteen"); break;
			case 14: strcpy(String,"fourteen"); break;
			case 15: strcpy(String,"fifteen"); break;
			case 16: strcpy(String,"sixteen"); break;
			case 17: strcpy(String,"seventeen"); break;
			case 18: strcpy(String,"eighteen"); break;
			case 19: strcpy(String,"nineteen"); break;
		}
	
	}
	else
	{
		strcpy(String,"");
		switch((nNumber/10)%10)
		{
			case 2: strcpy(String,"twenty"); break;
			case 3: strcpy(String,"thirty"); break;
			case 4: strcpy(String,"forty"); break;
			case 5: strcpy(String,"fifty"); break;
			case 6: strcpy(String,"sixty"); break;
			case 7: strcpy(String,"seventy"); break;
			case 8: strcpy(String,"eighty"); break;
			case 9: strcpy(String,"ninety"); break;
		}
		
		switch(nNumber%10)
		{
			case 1: strcat(String,"one"); break;
			case 2: strcat(String,"two"); break;
			case 3: strcat(String,"three"); break;
			case 4: strcat(String,"four"); break;
			case 5: strcat(String,"five"); break;
			case 6: strcat(String,"six"); break;
			case 7: strcat(String,"seven"); break;
			case 8: strcat(String,"eight"); break;
			case 9: strcat(String,"nine"); break;
		}
		
	
	}
	

}

int RoundOut(int nVal) // rounds off minutes to nearest 10th or 5th minute
{
	int foo = nVal % 10;
	nVal /= 10;
	if(foo > 5)
	{
		if(foo < 7)
		{
			nVal = ((nVal*10) + 5)%60;
		}
		else
		{
			nVal = ((nVal*10) + 10)%60;
		}
		
	
	} 
	else if(foo < 5)
	{
		if(foo < 3)
		{
			nVal = (nVal*10)%60;
		}
		else
		{
			nVal = ((nVal*10) + 5)%60;
		}
		
		
		
	
	}
	else
		nVal = ((nVal*10) + 5)%60;
	
	if(!nVal)
			nVal = 1;
	return nVal;

}

void Announce(int nHour, int nMinute) // prints the time in fuzzy format
{
	static int nCtr = 0;
	static int nIndex = 0;
	char FuzzySet[N][10] = {"almost", "nearly", "about","hardly"}, ExactSet[2][10] = {"exactly","now"}, String[20],HourString[20];
	char ToOrPast[5];
	if(nMinute > 32)
	{	
		nHour = (nHour + 1)%12;
		if(!nHour)
			nHour = 12;
		strcpy(ToOrPast,"to");
		nMinute = 60 - nMinute;
		if(!nMinute)
			nMinute = 1;
		
	}
	else
	{
		strcpy(ToOrPast,"past");
	}
	nCtr++;
	if(!(nCtr % 60))
		nIndex = rand()%N;
	
	Convert(RoundOut(nMinute),String);
	Convert(nHour,HourString);
	
	if(!strcmp("thirty",String))
		strcpy(String,"half");
	if(!strcmp("fifteen",String))
		strcpy(String,"quarter");
	
	if(nMinute%5)
			printf("\n\t\t It's %s %s %s %s", FuzzySet[nIndex],String,ToOrPast, HourString);
	
	else if(nMinute)
		printf("\n\t\t It's %s %s %s %s",ExactSet[nIndex%2], String,ToOrPast, HourString);
		
	else
		printf("\n\t\t It's %s %s",ExactSet[nIndex%2], HourString);

		
		
printf("\n\n");

}

int main()
{
time_t t;
struct tm timeval;
int nHour, nMin;
while(1)
{
	system("clear");
	time(&t);			// for getting the system time
	gmtime_r(&t,&timeval);


	timeval.tm_hour += 5;
	timeval.tm_min += 30;
	timeval.tm_hour %= 12;
	
	if(!timeval.tm_hour)
		timeval.tm_hour = 12;

	if(timeval.tm_min > 59)
	{
		timeval.tm_min %= 60;
		timeval.tm_hour = (timeval.tm_hour + 1)%12;
		if(!timeval.tm_hour)
			timeval.tm_hour = 12;
	}

	Announce(timeval.tm_hour , timeval.tm_min );
	sleep(1);

}


return 0;
}
