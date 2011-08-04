#include<iostream>
#include<stdlib.h>

using namespace std;

int count;

void sort(int asc[])
{
  int i,j,temp;
  for(i=0;i<3;i++)
  {
   for(j=1;j<4-i;j++)
   {
    if(asc[j-1]>asc[j])
    {
     temp = asc[j];
     asc[j]= asc[j-1];
     asc[j-1] = temp;
    }
   }
  }
}

void FindIteration(int num)
{
 int asc[4]={0}, des[4]={0};
 int i,tempNum,ascnum,desnum,flag=1;
 if(num==6174) return;
 tempNum=num;
 asc[0]=tempNum%10;
 tempNum/=10;
 for(i=1;i<4;i++)
 {
  asc[i]=tempNum%10;
  if(asc[0]!=asc[i]) flag =0;
  tempNum/=10;
 }
 if(flag)
 {
  count=-1;
  return;
 }
 count++;
 sort(asc);
 desnum = asc[3]*1000 + asc[2]*100 + asc[1]*10 + asc[0];
 ascnum = asc[0]*1000 + asc[1]*100 + asc[2]*10 + asc[3];
 num=abs(desnum-ascnum);
 FindIteration(num);
}


int main()
{
  int i,num, iteration, frequency[8]={0};
  char asc[4]={0}, des[4]={0};
  for(num=1000;num<9999;num++)
  {
    count=0;
    FindIteration(num);
    if(count!=-1)
     frequency[count]++;
  }
 for(i=0;i<8;i++)
 {
  cout<<i<<" : "<<frequency[i]<<"\n";
 }
}


