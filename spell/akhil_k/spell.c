#include<stdio.h>
#include<string.h>
void check(char string[50])
{
	FILE *fp1;
	int i=0,length,flag=0,k;
	char p[50],s;
	length=strlen(string);
	fp1=fopen("/usr/share/dict/words","r");
	while(!feof(fp1))			
	{
		s=fgetc(fp1);
		if(isspace(s))
		{
		}
		else if(isalnum(s))				
		{
			p[i]=s;
			i++;
			while( (isalnum(s=fgetc(fp1))) || ispunct(s))
			{
				if(ispunct(s))
				{
					if(s==39 || s==45)
					{
						p[i]=s;
						i++;
					}
					else 
						break;
				}
				else
				{
					p[i]=s;
					i++;
				}
			}
			p[i]='\0';
			if(i==length)
			{
				if(strcasecmp(string,p)==0)
				{
					flag=1;
					return;
				}
				else
					flag=0;
			}
			i=0;
		}
	}
	if(flag==0)
	{	
		k=0;
		while(k<length)
		{
			printf("%c",string[k]);
			k++;
		}
		printf("\n");
	}
	fclose(fp1);
	return;
}
int main()
{
	char p[50],s;
	int i=0,line_number=1;
	FILE *fp2;
	fp2=fopen("text","r");
	while(!feof(fp2))			
	{
		s=fgetc(fp2);
		if(ispunct(s))
		{
			if(s==46)
			{
				line_number++;			
			}
		}
		else if(isalnum(s))				
		{
			p[i]=s;
			i++;
			while( (isalnum(s=fgetc(fp2))) || ispunct(s))
			{
				if(ispunct(s))
				{
					if(s==39 || s==45)
					{
						p[i]=s;
						i++;
					}
					else if(s==46)
						line_number++;
					else
						break;
				}
				else
				{
					p[i]=s;
					i++;
				}
			}
			p[i]='\0';
			check(p);
			i=0;
		}
	}
	fclose(fp2);
}
