#include<stdio.h>
#include<conio.h>
#include<math.h>
int diff(int);
void main()
{
FILE *ptr;
int num=1000,itr=0,data[8][2],i,keep,rev;
clrscr();
ptr=fopen("data.txt","w");
for(i=0;i<8;i++)
{
data[i][0]=i;
data[i][1]=0;
}
while(num<9999)
{
keep=num;
while(num!=6174)
{
num=diff(num);
if(num==0)
break;
else
itr++;
}


 for(i=0;i<8;i++)
{
if(itr==data[i][0])
data[i][1]=data[i][1]+1;
}
num=keep;
itr=0;
num++;
}
fprintf(ptr,"iteration  total count of numbers\n");
for(i=0;i<8;i++)
{
fprintf(ptr,"\n%d\t\t\t",data[i][0]);
fprintf(ptr,"%d",data[i][1]);
}
fclose(ptr);

getch();
}
int diff(int num)
{
int store[4]={0,0,0,0};
int r,i=0,temp,j,newnum=0;
while(num>0)
{
r=num%10;
store[i]=r;
num=num/10;
i++;
}
for(i=0;i<4;i++)
{
for(j=i+1;j<4;j++)
{
if(store[i]<store[j])
{
temp=store[i];
store[i]=store[j];
store[j]=temp;
}
}
}
for(i=0;i<4;i++)
newnum=newnum*10+store[i];
for(i=3;i>=0;i--)
num=num*10+store[i];
//printf("%d\t%d\n",num,newnum);
newnum=abs(newnum-num);
return newnum;
}