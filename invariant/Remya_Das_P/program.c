#include<stdio.h>
#include<conio.h>
void main()
   {
	int number,i;
	for(i=1000;i<9998:i++)
	   {
	    number=i;
	    int f=0;
		for(j=1;j<9;j++)
		{
		  if(i==j*1111)
		    f=1;
		}
	    if(f==1)
	      continue;
	    else
		{
		 int count=0,flag=0;
		 while(flag==0)
		  {
			int n[4],k=0;
			while(number>0)
			{
				num[k]=number%10;
				number=number/10;
				k++;
			}
		int temp=0;
		 for(int z=0;z<3;z++)
		  {
			for(int y=0;y<3-i;y++)
			   {
				if(n[y]>n[y+1])
				{
				   temp=n[y];
				   n[y]=n[y+1];
				   n[y+1]=temp;
		   		}
			    }
		  }
		int asc,dsc;
		asc=n[0]*1000+n[1]*100+n[2]*10+n[3];
		dsc=n[3]*1000+n[2]*100+n[1]*10+n[0];
		count++;
		number=dsc-asc;
		if(number==6174)
		{
		 flag=1;
		 printf("%d",count);
		 break;
		}
	     }
         }
      getch();
  }