/*
Write a program which first collects all word-level trigrams in a novel-length story. Then, choosing any arbitrary trigram 
as the starting point, generate a short story which is between 200 to 300 words. The next trigram in the chain must always 
have the first two words same as that of the previous trigrams last two words.

What is a trigram you ask? The sentence "The quick red fox jumps over the lazy brown dog" has the following trigrams - 
"The quick red", "quick red fox", "red fox jumps", "fox jumps over", "jumps over the", "over the lazy", "the lazy brown", 
"lazy brown dog".

Hint: Project Gutenberg is a good place to find a lot of plain text books
*/

/*NAME: NIDHIN JOSE*/

#include<stdio.h>

#define MAX_WORDLENGTH 100

void trigram_generator();
void shortstory();
int randomgenerator();

int main()
{
       trigram_generator();
       shortstory();
       printf("\n\nProgram successfully completed");
       
}

void shortstory()
{
     FILE *trigram_file,*story_file;
     int n,wordlimit;
     char c;
     char str[MAX_WORDLENGTH];
     trigram_file=fopen("trigram.txt","r");
    if(trigram_file==NULL)
    {
                        perror("Trigram_file");
                        exit(0);
                        }
    story_file=fopen("story.txt","w");
    if(story_file==NULL)
    {
                        perror("story_file");
                        exit(0);
                        }
    n=randomgenerator();
    wordlimit=n%100+200;
    fseek(trigram_file,0,SEEK_END);
    n=n% (ftell(trigram_file));
    if(n%2)
    fseek(trigram_file,n,SEEK_SET);
    else
    fseek(trigram_file,-n,SEEK_END);
    while(fscanf(trigram_file,"%c",&c))
    {
                                         if(c=='.')
                                         break;
                                               }
    fscanf(trigram_file,"%s",str);
    fscanf(trigram_file,"%s",str);
    for(n=0;n<wordlimit;n++)
    {
                            if(fscanf(trigram_file,"%s",str)!=1)
                            break;
                            fprintf(story_file,"%s ",str);
                            fscanf(trigram_file,"%s",str);
                            fscanf(trigram_file,"%s",str);
                            }
    fscanf(trigram_file,"%c",&c);
                           
    while(fscanf(trigram_file,"%c",&c))
    {
                                                   fprintf(story_file,"%c",c);
                                                   if(c=='.')
                                                   break;
                                                   else if (c==' ')
                                                   {
                                                        fscanf(trigram_file,"%s",str);
                                                        fscanf(trigram_file,"%s",str);
                                                        fscanf(trigram_file,"%c",&c);
                                                        fprintf(story_file,"%c",c);
                                                        }
                                                                                                     
                                                   }
           
    printf("\n\nShort story created in the file story.txt");                        
    fclose(trigram_file);
    fclose(story_file);
}
    
void trigram_generator()
{
     FILE *novel_file,*trigram_file;
    char str[3][MAX_WORDLENGTH];
    int n=3,a=4,b=5;
    novel_file=fopen("novel.txt","r");
    if(novel_file==NULL)
    {
                        perror("Novel_file");
                        exit(0);
                        }
    trigram_file=fopen("trigram.txt","w");
    if(trigram_file==NULL)
    {
                        perror("Trigram_file");
                        exit(0);
                        }
 
    if(fscanf(novel_file,"%s%s%s",str[0],str[1],str[2])!=3)
    {
                                                       printf("Not Enough content in the novel");
                                                       exit(0);
                                                       }
                                                       
    do
    {
                        fprintf(trigram_file,"%s %s %s ",str[n%3],str[a++%3],str[b++%3]); 
                        }while((fscanf(novel_file,"%s",str[n++%3])!=EOF));
    fclose(novel_file);
    fclose(trigram_file);
    printf("\n\nTrigram created in the trigram.txt");
    }
    
    int randomgenerator()
{
     srand ((unsigned int)time(NULL));
     return rand();    
}
