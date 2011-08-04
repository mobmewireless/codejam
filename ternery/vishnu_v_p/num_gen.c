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

void GenNumber(char sNum[])
{
	int i;
	
	for( i = 0; i<10; i++)
		sNum[i] = rand()%10 + 48;
	sNum[i] = '\0';
	
printf("\n%s",sNum);
}
int main()
{

	char sNum[11], *ShMem;
	int i, nShID,nSemID;
	union semun semunVar;
	
	nSemID = semget((key_t)2222,2,IPC_CREAT|0700);
	semunVar.val = 1;
	semctl(nSemID,0,SETVAL,semunVar);//perror("Error");
	semctl(nSemID,1,SETVAL,semunVar);
	
	nShID = shmget((key_t)3333,0x6400,IPC_CREAT|0700);
	ShMem = shmat(nShID,0,0);
	
	
	P(nSemID,1);
	while(1)
	{
		GenNumber(sNum);
		P(nSemID,0);
		strcpy(ShMem,sNum);
		printf("\n%s",ShMem);
		V(nSemID,1);
		//sleep(1);
	}
	return 0;


	
}
