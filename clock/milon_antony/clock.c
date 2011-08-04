#include<stdio.h>
#include<string.h>
#include<time.h>
#include<stdlib.h>


struct tm *ct;

void gtime()
{
	time_t t;	
	t=time(NULL);
	ct=localtime(&t);
}


void disp(int h,int m)
{
	int f=0,g,fl=0,flg=0;
	char sh[10],sm[20],d[5],a[10];
	
	if(h==11)
		flg=1;
	
	
		
	
		if(m<=32)
		{
			f=m%10;
			g=m/5;
			
			if(f>=3&&f<8)
			{
				if(f<5)
				{
					g=(g+1)*5;
					strcpy(a,"ALMOST");
				}
				else
				{
					g*=5;
					strcpy(a,"AROUND");
				}
			}
			else if(f==5)
			{
				g*=5;
				strcpy(a,"PRECISELY");
			}
			else if(f==0)
			{
				g*=5;
				strcpy(a,"");
			}
			else
			{
				if(f>0&&f<3)
				{
					g*=5;
					strcpy(a,"AFTER");
				}
				else
				{
					g=(g+1)*5;
					strcpy(a,"ALMOST");
				}
			}
					
			strcpy(d," PAST");
			if(g==0&&f<3)
				strcpy(d,"");
			switch(g)
			{
				case 0:strcpy(sm,"");break;
				case 5:strcpy(sm,"FIVE");break;
				case 10:strcpy(sm,"TEN");break;
				case 15:strcpy(sm,"QUARTER");break;
				case 20:strcpy(sm,"TWENTY");break;
				case 25:strcpy(sm,"TWENTY-FIVE");break;
				case 30:strcpy(sm,"HALF");break;
			}
			if (h>=12)
				f=1;
			else f=0;
			h=h%12;
		}
		else if(m>32)
		{
			f=m%10;
			g=m/5;
			
			if(f>=3&&f<8)
			{
				if(f<5)
				{
					g=(g+1)*5;g=60-g;
					strcpy(a,"NEARLY");
				}
				else
				{
					g*=5;g=60-g;
					strcpy(a,"ABOUT");
				}
			}
			else if(f==5)
			{
				g*=5;g=60-g;
				strcpy(a,"");
			}
			else if(f==0)
			{
				g*=5;g=60-g;
				strcpy(a,"PRECISELY");
			}
			else
			{
				if(f>0&&f<3)
				{
					g*=5;g=60-g;
					strcpy(a,"AROUND");
				}
				else
				{
					g=(g+1)*5;g=60-g;
					strcpy(a,"NEARLY");
				}
			}
					
			strcpy(d," TO");
			if(g==0&&f>=8)
				strcpy(d,"");
			if (h>=12)
				f=1;
			else f=0;
			h=(h+1)%12;
			if(h==0)
				fl=1;
			
		
		switch(g)
		{
			case 0:strcpy(sm,"");break;
			case 5:strcpy(sm,"FIVE");break;
			case 10:strcpy(sm,"TEN");break;
			case 15:strcpy(sm,"QUARTER");break;
			case 20:strcpy(sm,"TWENTY");break;
			case 25:strcpy(sm,"TWENTY-FIVE");break;
			case 30:strcpy(sm,"HALF");break;
		}
		
	
	}
	switch (h)
	{
		case 0:strcpy(sh,"TWELVE");break;
		case 1:strcpy(sh,"ONE");break;
		case 2:strcpy(sh,"TWO");break;
		
		case 3:strcpy(sh,"THREE");break;
		case 4:strcpy(sh,"FOUR");break;
		case 5:strcpy(sh,"FIVE");break;
		
		case 6:strcpy(sh,"SIX");break;
		case 7:strcpy(sh,"SEVEN");break;
		case 8:strcpy(sh,"EIGHT");break;
		
		case 9:strcpy(sh,"NINE");break;
		case 10:strcpy(sh,"TEN");break;
		case 11:strcpy(sh,"ELEVEN");break;
	}
	if (((f==0&&h==0)||fl==1)&&flg==0)
		strcpy(sh,"MIDNIGHT");
		
	if (system("cls")) system("clear");
	
	printf("IT'S %s\n",a);
	printf("%s%s\n",sm,d);
	printf("%s\n",sh);
}
	

int main()
{
	int h,m,s,a=1;
	
	do
	{
		m=s;
		gtime();
		h=ct->tm_hour;
		m=ct->tm_min;
		s=ct->tm_sec;		
		if(s==0||a==1)
			disp(h,m);
		a=0;
	}while(1);


	return 0;
}
