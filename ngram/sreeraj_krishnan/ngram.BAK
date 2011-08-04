#include<fstream.h>
#include<string.h>
#include<conio.h>



void check()
{
char a[20],g[25][10]={"for","and","nor","but","or","yet","so","the","of","to","a","in","that","is","was","I","for","on","by","with","at","from","as"};
int c,i;
ifstream f4("book.txt");
ofstream f5("story.txt");
while(!f4.eof())
{
f4>>a;
c=0;        cout<<a<<"   ";
for(i=0;i<24;i++)
{
if(strcmpi(a,g[i])==0)
{ c=1; break;}

}
if(c==0)
f5<<a<<" ";
}

}


void main()
{
clrscr();
char s[70];
int c;
ifstream f1("book.txt");
ofstream f2("trigram.txt");
cout<<"\n Paste your story in \"book.txt\" and the trigrams are stored in \"trigram.txt\"and click to see them ";
while(!f1.eof())
{
f1>>s;
f2<<s<<" ";
c=f1.tellg();
f1>>s;
f2<<s<<" ";
f1>>s;
f2<<s<<"\n";
switch(s[strlen(s)-1])
{
case '.':
case '!':
case '?':continue;
}
f1.seekg(c);
}
f1.close();
f2.close();
f1.open("trigram.txt");
f2.open("story.txt");
while(!f1.eof())
{

f1.getline(s,70);
cout<<"\n"<<s;
}
f1.close();
check();
cout<<"\n Summarised Story : \n";
f1.open("story.txt");
while(!f1.eof())
{
f1>>s;
cout<<s<<" ";
}

}