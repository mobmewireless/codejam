#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<unistd.h>
typedef struct Node
{

	unsigned int nIteration;
	unsigned int nCount;
	struct Node*  Next;
} Node;

Node* CreateNode()
{


	return (Node *)malloc(sizeof(Node));
}

Node* Search(int nI,Node *Head)
{
	Node *Temp, *Prev;
	Temp = Prev = Head;
	
	while(Temp)
	{
		if(Temp->nIteration == nI)
		{ 
			
			return Temp;
		
		}
		else if(Temp->nIteration > nI)
		{
			
			return Prev;
		}
		Prev = Temp;
		Temp = Temp->Next;
	}
	return Prev;

}
Node* Insert(int nI,Node* Head)
{

	Node *New,*Existing;
	
	Existing = Search(nI,Head);
	
	if(!Existing)
	{	New = CreateNode();
		New->nIteration = nI;
		New->nCount 	= 1;
		New->Next = NULL;
		return New;
	}
	
	else if(Existing->nIteration == nI)
	{
		Existing->nCount++;
	}
	
	else if(Existing->nIteration < nI)
	{
		New = CreateNode();
		New->nIteration = nI;
		New->nCount 	= 1;
		New->Next = Existing->Next;
		Existing->Next = New;
		
	}
	else if(Existing->nIteration > nI && Existing == Head)
	{
		New = CreateNode();
		New->nIteration = nI;
		New->nCount 	= 1;
		New->Next = Head;
		Head = New;
	
	}
	return Head;
}

void DeleteList(Node *Head)
{

Node *T;
while(Head)
{
T = Head;
Head = Head->Next;
free(T);
}
}
void PrintList(Node *Head)
{
	
              
	system("clear");
	printf("\nIteration	Total Count of Numbers",Head->nIteration, Head->nCount);
	while(Head)
	{
		printf("\n%9d	%22d\n",Head->nIteration, Head->nCount);
		
		Head = Head->Next ;
	
	}
	
}
int PerformFunc(int nVal)
{
	int nDiscrete[4] = {0,0,0,0},i,j,nNewVal;
	i = 0;
	//printf("\nnow at%d",nVal);
	while(nVal)
	{
	 nDiscrete[i++] = nVal%10; 
	 nVal /= 10;
	}
	for( i = 0; i<4;i++)
		for( j =i+1; j<4; j++)
			if(nDiscrete[i] > nDiscrete[j])
			{
				nDiscrete[i] = nDiscrete[i] + nDiscrete[j];
				nDiscrete[j] = nDiscrete[i] - nDiscrete[j];
				nDiscrete[i] = nDiscrete[i] - nDiscrete[j];
			}
	nVal = nDiscrete[0]*1000 + nDiscrete[1]*100 + nDiscrete[2]*10 + nDiscrete[3];
	nNewVal = nDiscrete[3]*1000 + nDiscrete[2]*100 + nDiscrete[1]*10 + nDiscrete[0];
	
	
	return abs(nVal - nNewVal);
}
int OK(int i)
{

	switch(i)
	{
		case 1111:
		case 2222:
		case 3333:
		case 4444:
		case 5555:
		case 6666:
		case 7777:
		case 8888: return 0;
	
	
	}
	return 1;


}

int main()
{

	Node *Head = NULL;
	int i,foo,foobar,nCount,nCtr = 0;
		
	for( i = 1000;i<9999; i++)
	{
		
		if(OK(i))
		{	
			foo = i;nCtr++;
			foobar = nCount = 0;
			
			while(foobar != 6174 )
			{
				nCount++;
				
				foobar = PerformFunc(foo);
				foo = foobar;
							
			}
			Head = Insert(nCount, Head);
		
		}
		
	}
	PrintList(Head);
	DeleteList(Head);
	return 0;

}



