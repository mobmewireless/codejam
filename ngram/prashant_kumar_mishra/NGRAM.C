#include<stdio.h>
#include<conio.h>
void main()
{
FILE *fptr,*trig;
char ch,temp[50],temp1[50];
int i=0,j=0,id=0,k=0,n=9,m=0;
clrscr();
fptr=fopen("story.txt","r");
trig=fopen("trigram.txt","w");
while(1)
{
 ch=fgetc(fptr);
  if(ch==',' || ch=='.' || ch==';'||ch==39||ch==')'||ch=='(')
  {
  fputc(ch,trig);
  ch=fgetc(fptr);
  }
  if(ch>='a' && ch<='z' || ch>='A' && ch<='Z')
  {
   while(ch>='a' && ch<='z' || ch>='A' && ch<='Z')
   {
    temp[i]=ch;
    fputc(ch,trig);
    i++;
    ch=fgetc(fptr);
     if(ch==',' || ch=='.' || ch==';'||ch==39||ch==')'||ch=='(')
     {
      fputc(ch,trig);
      temp[i]=ch;
      ch=fgetc(fptr);
      i++;
     }

    }

    j++;
      if(id==2)
      j=3;
       if(j==3)
      {
       ch='\n';
       fputc(ch,trig);
       temp[i]='\0';
       id=1;
       n=1;
       j=0;
      }
      else
     {
       ch=' ';
      fputc(ch,trig);
      temp[i]=ch;
      i++;
     }
 }
  m=0;
 while(id==1)
 {
  while(n==1)
  {
   if(temp[k]==' ')
   {
    k++;
    n=0;
    break;
   }
   k++;
  }
 ch=temp[k];
 fputc(ch,trig);
 k++;
 temp[m]=ch;
 m++;

   if(temp[k]=='\0')
   {
    ch=' ';
    fputc(ch,trig);
    id=2;
    temp[m]=ch;
    m++;

    i=m;
    k=0;
    break;
   }
  }
   if(ch==EOF)
   break;
 }
   fclose(trig);
   fclose(fptr);
   i=0;
   printf("enter the words trigram to start a story.....\n");
   gets(temp);
   trig=fopen("trigram.txt","r");

  while(1)
  {
  i=0;
  ch=getc(trig);
  while(1)
  {
   if(ch=='\n'||ch==EOF)
   {
   temp1[i]='\0';
   break;
  }
   temp1[i]=ch;
   i++;
   ch=getc(trig);
 }
 m=0;
    if(strcmp(temp1,temp)==0)
   {
     printf("enter the number of words u want to print");
     scanf("%d",&i);
      for(m=0;m<i;m++)
      {
	while(j<2)
	{
	 ch=getc(trig);
	 if(ch==' ')
	 j++;

	}
       ch=getc(trig);
	if(ch=='\n')
	{
	 j=0;
	 printf("   ");
	}
       else
       {
	if(ch=='.')
	printf("%c\n",ch);
	else
	printf("%c",ch);
    }
   }
	break;
 }
      if(ch==EOF)
      {
       printf("not found................");
       break;
      }

      }
     getch();
 }


