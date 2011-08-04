#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>
#include<semaphore.h>
unsigned long nCounts[10];
sem_t sem;
void *Count(void* vFileNo)
{
	int *nFileNo = vFileNo;
	unsigned long nDisCount;
	char sFileName[] = "0.txt";
	short nCtr = 0;
	FILE *FilePtr;
	
	sFileName[0] = *nFileNo + 48;
	while(1)
	{
		FilePtr = fopen(sFileName,"r");
		nDisCount = 0;
		if(FilePtr)
		{
			while(getc(FilePtr) != EOF)
			{
				nCtr++;
				if(nCtr == 11)
				{
					nDisCount++;
					
					nCtr = 0;
				}
			}	
			fclose(FilePtr);
			sem_wait(&sem);
			nCounts[*nFileNo] = nDisCount;
			sem_post(&sem);
		}
		else
		{
			perror("Run filter program first");
			return;
		}
		sleep(1);
	}

}

void *Display()
{
	int i = 0;
	while(1)
	{
		sleep(1);
		system("clear");
		for( i = 0; i<10; i++)
		{
			sem_wait(&sem);
			printf("\nFile %d.txt: Number count:%ld\n",i,nCounts[i]);	
			sem_post(&sem);
		}
		
	}

}

int main()
{
    int i,nFileNo[10];
    pthread_t CountThread[10],DisplayThread;
  sem_init(&sem, 0, 1);
    for(i=0;i<10;i++)
    {
    	nFileNo[i] = i;
    	nCounts[i] = 0;
        pthread_create(&CountThread[i],NULL,Count,&nFileNo[i]);
     
    }
    pthread_create(&DisplayThread,NULL,Display,NULL);
    for(i=0;i<10;i++)
        pthread_join(CountThread[i],NULL);
    
    pthread_join(DisplayThread,NULL);
     
    return 0;
}


