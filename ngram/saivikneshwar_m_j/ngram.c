#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>

int main()
{
	char str[10000000],str1[1000][100];
	
	int a[10000];
	
	scanf("%[^\n]",str);
	
	int k=0,cnt=0,l=0,i,j;


	for(i=0;i<strlen(str);i++)
		if(str[i]==' ')
				a[cnt++]=i;
						
	for(i=0;i<cnt-1;i++)
	{
		
		if(k==0)
		{
		for(j=0;j<a[i+2];j++)
			str1[k][l++]=str[j];
	
			k+=1,l=0;
	
		}
		else if(i+2<cnt)
		{
		for(j=a[i-1]+1;j<a[i+2];j++)
			str1[k][l++]=str[j];
			
			k+=1,l=0;
		}
		else
		{
			for(j=a[i-1]+1;j<strlen(str);j++)
			str1[k][l++]=str[j];
			
			k+=1,l=0;
		}			
	}

	srand(0);
	int c=rand()%10;
		
	for(i=c;i<k;i++)printf("%s ",str1[i]);

	printf("\n");
	return 0;
}
