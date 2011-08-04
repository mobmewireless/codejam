#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/sem.h>
#include <sys/shm.h>
#include<string.h>

union semun
{
int val;
struct semid_ds *buf;
unsigned short *array;
struct seminfo *__buf;

};

void P(int nSID,int n)
{
	struct sembuf sops;
	
	sops.sem_num = n;
	sops.sem_op  =-1;
	sops.sem_flg =SEM_UNDO;
	
	semop(nSID, &sops, 1); 
}

void V(int nSID,int n)
{
	struct sembuf sops;
	
	sops.sem_num = n;
	sops.sem_op  = 1;
	sops.sem_flg = SEM_UNDO;
	
	semop(nSID, &sops, 1); 



}

	
void Process(char *sNum)
{
	char sFileName[6];
	FILE *FilePtr;
	sFileName[0] = sNum[0];
	sFileName[1] = '.';
	sFileName[2] = 't';
	sFileName[3] = 'x';
	sFileName[4] = 't';
	sFileName[5] = '\0';
	
	FilePtr = fopen(sFileName,"a");
	fprintf(FilePtr,"%s\n",sNum);
	fclose(FilePtr);
}

int main()
{


	int nShID,nSemID;
	char sNum[11], *ShMem;
	union semun semunVar;
	
	nSemID = semget((key_t)2222,2,IPC_CREAT|0700);
	semunVar.val = 1;
	semctl(nSemID,0,SETVAL,semunVar);//perror("Error");
	semctl(nSemID,1,SETVAL,semunVar);
	
	nShID = shmget((key_t)3333,0x6400,IPC_CREAT|0700);
	ShMem = shmat(nShID,0,0);
	while(1)
	{	
		P(nSemID,1);
		strcpy(sNum,ShMem);
		V(nSemID,0);
		
		Process(sNum);
		
	}
	shmdt(ShMem);
	return 0;


	
}
