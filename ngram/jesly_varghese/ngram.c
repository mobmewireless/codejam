#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>

struct trigram //this is to store each trigram. Some use of those DS classes XD 
{
       char first[50],second[50],third[50];
       struct trigram *next,*prev;
       int vowel,single_quote,double_quote,period,caps,an,used;
       };
int tcount=1;
      int not_my_neighbour(struct trigram *n1,struct trigram *n2);
      void my_story(struct trigram *start,struct trigram *head);
      char fname[10];
void read_story(char *filename,struct trigram *story)
{
     FILE *f = fopen(filename,"r+");
     strcpy(fname,filename);
     char word[50];
          story->prev = NULL;
          story->next = NULL;
     struct trigram *temp,*now=story;
     printf("Reading story and generating Trigrams!!");
     //Initiating the trigram sequence
     fscanf(f,"%s",word); 
     strcpy(now->first,word);
      fscanf(f,"%s",word);
     strcpy(now->second,word);
     fscanf(f,"%s",word);
     strcpy(now->third,word);
     //Generating rest of trigrams
     while(!feof(f))
     {
                         tcount++;
                         temp = (struct trigram *)malloc(sizeof(struct trigram));
                         strcpy(temp->first,now->second);
                         strcpy(temp->second,now->third);
                         fscanf(f,"%s",word);
                         strcpy(temp->third,word);
                         temp->prev = now;
                         now->next = temp;
                         temp->next = NULL;
                         now = temp;
                         
      }
 fclose(f);
 }


void print_story(struct trigram *start)
{
     char filename[50];
     strcpy(filename,fname);
     strcat(filename,"_ngram.txt");
FILE *f=fopen(filename,"w");
int count=0;
do
{
     printf("%s ",start->first);
     printf("%s ",start->second);
     printf("%s\n",start->third);
     fprintf(f,"%s ",start->first);
     fprintf(f,"%s ",start->second);
     fprintf(f,"%s\n",start->third);
     start = start->next;
     count++;
     }while(start); 
printf("\nThe Trigrams have be written to %s\n",filename);
fclose(f);
}

int single_quotes(char *word)
{int x=0,quote=0;
    while(word[x]!='\0')
    if(word[x++]== '\'')
    quote++;
    return quote;
}

int double_quotes(char *word)
{int x=0,quote=0;
    while(word[x]!='\0')
    if(word[x++]== '"')
    quote++;
    return quote;
}
int voweled(char *word)
{
    switch(word[0])
    {
                   case 'a':
                   case 'A':
                   case 'e':
                   case 'E':
                   case 'i':
                   case 'I':
                   case 'o':
                   case 'O':
                   case 'u':
                   case 'U':
                   return 1;
                   default:
                   return 0;
    }
}
void process(struct trigram *start)
{
     char word[50];
     while(start)
     {
                
                
                 strcpy(word,start->first);
                
                 start->double_quote=double_quotes(word);
                 start->single_quote=single_quotes(word);
                 start->vowel = voweled(word);
                 if(isupper(word[0])) 
                 start->caps = 1;
                 
                 strcpy(word,start->second);
                 start->double_quote+=double_quotes(word);
                 start->single_quote+=single_quotes(word);
                 
                 strcpy(word,start->third);
                 start->double_quote+=double_quotes(word);
                 start->single_quote+=single_quotes(word);
                 if(word[strlen(word)-1]=='.'||word[strlen(word)-1]=='!')
                 start->period = 1;
                 if(strcmp(word,"an")==0)
                 start->an = 1;
                
                 start = start->next;
     }
}

main()
{
      struct trigram *story = (struct trigram *) malloc(sizeof(struct trigram));
      char filename[50];
      printf("Enter the file name (eg: story.txt) : ");
      scanf("%s",filename);
printf("\nFile:%s",filename);
      read_story(filename,story);
      print_story(story);
      printf("A total of %d Trigrams got generated!\n",tcount);
      int word_count = tcount*3;
      printf("A total of %d words exist!\n",word_count);
      process(story);
      getchar(); 
      
       srand ( time(NULL) );
      int init = rand()%tcount,start_count=0;
      struct trigram *start = story;
      while(start_count++<init)start = start->next;
      while(isupper(start->first[0])==0)start = start->next;
      my_story(start,story);

getchar();
puts("\nAnd that was the Trigram Story!! :)");
getchar();
      exit(0);
     
}

int not_my_neighbour(struct trigram *n1,struct trigram *n2)
{
if(n1->next&&n2->next&&n1->prev&&n2->prev)
{
if(n1->next==n2||(n1->next)->next==n2)
return 0;
if(n1->prev==n2||(n1->prev)->prev==n2)
return 0;     
}
return 1;
}

void my_story(struct trigram *start,struct trigram *head)
{
    char filename[50];
     strcpy(filename,fname);
     strcat(filename,"_ngram_story.txt");
     FILE *f = fopen(filename,"w");
     struct trigram *news,*temp=start,*next,*previous,*nexted;
     int flag=1,word_count=0,init=0,start_count=0;
     news = temp;
     while(flag){
     temp->used=1;
     srand ( time(NULL) );
     init = rand()%tcount;
     next = temp->next;
     while(start_count++<init){if(next->next)next = next->next;else next=head;}
                     
     
     while(next&&(next->used==1||(not_my_neighbour(temp,next)==0)))if(next->next)next=next->next;else next=head;
       
     
     
     if(temp->period==1)
     {
                        while(next&&next->caps==1)next=next->next;
                        goto next_step;
     }
     if(temp->an==1)
     {
                    while(next&&next->vowel==1)next=next->next;
                    goto next_step;
     }
     
     if(temp->double_quote%2!=0)
     while(next&&next->double_quote==1)next=next->next;
     
     next_step:       
     if(next==NULL) next=head;
     
     printf("%s %s %s ",temp->first,temp->second,temp->third);
     fprintf(f,"%s %s %s ",temp->first,temp->second,temp->third);
       if((word_count>=200&&temp->third[strlen(temp->third)-1]=='.')||word_count>=297)
         flag=0;
     temp= next;
     
     word_count+=3;
   
     }printf("\nThe Trigrams have be written to %s\n",filename);
     fclose(f);
}

