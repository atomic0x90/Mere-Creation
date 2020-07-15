#include <iostream>
#include <cstring>
//#include <queue>
#include <fstream>

#include <stdlib.h>
 
#define MAX 50

using namespace std;

ifstream fin("banker.inp");
ofstream fout("banker.out");

int prcNum, RsNum;

int AVAILABLE[MAX];
int ALLOCATION[MAX][MAX];
int Resource_MAX[MAX];
int Max[MAX][MAX];
int NEED[MAX][MAX];

int i, j, temp, qCount;
string word;
  
typedef struct save
{
	int *RESOURCE;
	int nowPrc;
	save *next;
} save;
 
typedef struct Queue
{
	int qCount;
	save *front, *rear;
} Queue;


void init_Q(Queue *q)
{
	q-> qCount = 0;
	q-> front = NULL;
	q-> rear = NULL;

	return;
}

void enQueue(Queue *q, save item, int RNum)
{ //큐 삽입 함수
	
	save *temp = (save*)malloc(sizeof(save));
	temp->RESOURCE = (int*)malloc(sizeof(int)*RNum);

	temp->nowPrc = item.nowPrc;

	for(int i = 0;i < RNum;i++)
		temp->RESOURCE[i] = item.RESOURCE[i];


	temp->next = NULL;

	if(q->qCount != 0)
	{
		q->rear->next = temp;
		q->rear = temp;
	}
	else
	{
		q->front = temp;
		q->rear = temp;
	}
	q->qCount++;

	return;
}
 
save deQueue(Queue *q,int RNum)
{ //큐 삭제 함수

	save *temp = q->front;
	save item;


	item.RESOURCE = (int*)malloc(sizeof(int)*RNum);
	item.nowPrc = temp->nowPrc;

	q->front = q->front->next;

	for(int i = 0;i < RNum;i++)
		item.RESOURCE[i] = temp->RESOURCE[i];

	q->qCount--;

	return item;
}


void array1(int t1[], int ori[], int num)
{
	for(int i = 0;i < num;i++)
		t1[i] = ori[i];
	return;
}

void foutFunction()
{
	for(i = 0;i < RsNum;i++)
		fout<<AVAILABLE[i]<<" ";
	fout<<endl;

	return;
}

int AV_RE(int AV[], int Re_Ne[], int t)
{
	int i = 0;
	while(i < t)
	{
		if(Re_Ne[i] > AV[i])
			return 0;	
		i++;
	}
	return 1;
}
 

void array2(int (*t1)[50], int (*ori)[50], int PNum, int RNum)
{
	for(int i = 0;i < PNum;i++) {
		for(int j = 0;j < RNum;j++)
			t1[i][j] = ori[i][j];
	}
	return;
}
 
void finFunction()
{
	for(i = 0; i < RsNum; i++)
		fin>>Resource_MAX[i];

	for(i = 0; i < prcNum ; i++)
	{
		for(j = 0; j < RsNum ; j++)
			fin>>Max[i][j];
	}

	for(i = 0;i < prcNum;i++)
	{
		for(j = 0;j < RsNum;j++)
			fin>>ALLOCATION[i][j];
	}

	for(i = 0;i < prcNum;i++)
	{
		for(j = 0;j < RsNum;j++)
			NEED[i][j] = Max[i][j] - ALLOCATION[i][j];
	}

	for(i = 0;i < RsNum;i++)
	{
		temp = 0;
		for(j = 0;j < prcNum;j++)
			temp += ALLOCATION[j][i];
	
		AVAILABLE[i] = Resource_MAX[i] - temp;
	}
	return;
}

void RELEASE(int (*ALL)[50], int (*NE)[50], int AV[], save RE, int PNum, int RNum)
{
	int i = 0;
	while(i < RNum)
	{
		ALL[RE.nowPrc][i] -= RE.RESOURCE[i];
		AV[i] += RE.RESOURCE[i];
		NE[RE.nowPrc][i] += RE.RESOURCE[i];	
	
		i++;
	}
	return;
}
//return => 1 : 참, 0 : 거짓
int requestCheck(int (*ALL)[50], int (*NE)[50], int AV[], save RE, int PNum, int RNum)
{
	int flag[MAX],tmpN[MAX][MAX],i,j,tmpAVAILABLE[MAX],tmpAll[MAX][MAX],Next = 1;
	//next pr : 확인변수 1이면 확인하고 0이면 안해도됨  
	for(i = 0;i < PNum;i++)
		flag[i] = 0; //0이면 확인 안했음, 1이면 확인 했음


	if(AV_RE(NE[RE.nowPrc], RE.RESOURCE, RNum) == 0)		//Request가 Need보다 큰 경우
		return 2;
	

	array2(tmpAll, ALL, PNum, RNum);

	array2(tmpN, NE, PNum, RNum);

	array1(tmpAVAILABLE, AV, RNum);


		
	for(i = 0;i < RNum;i++)
	{
		tmpAll[RE.nowPrc][i] += RE.RESOURCE[i];
		tmpN[RE.nowPrc][i] -= RE.RESOURCE[i];
		tmpAVAILABLE[i] -=  RE.RESOURCE[i];
	}


	while(Next)
	{
		Next = 0;
		for(i = 0 ; Next == 0 && i < PNum ; i++)
		{
			if(flag[i] == 0)
			{
				if(AV_RE(tmpAVAILABLE,tmpN[i],RNum) != 0)
				{
					Next = 1;
					for(j = 0 ; j < RNum ; j++)
						tmpAVAILABLE[j] += tmpAll[i][j];
					flag[i] = 1;
				}
			}
		}
	}

	i = 0;
	while(i < PNum)
	{
		if(flag[i] == 0)
			return 0;
	
		i++;
	}

	i = 0;
	while(i < RNum)
	{
		ALL[RE.nowPrc][i] += RE.RESOURCE[i];
		NE[RE.nowPrc][i] -= RE.RESOURCE[i];
		AV[i] -=  RE.RESOURCE[i];
	
		i++;
	}
	
	return 1;
} 



int main()
{
	Queue q;
	save com;
	
	fin>>prcNum>>RsNum;
	init_Q(&q);

	finFunction();

	com.RESOURCE = (int*)malloc(sizeof(int)*RsNum);
     
	for(;;)
	{
		fin>>word;
		fin>>com.nowPrc;

		for(i = 0;i < RsNum;i++)
			fin>>com.RESOURCE[i];

		if(word == "quit") break;
		else if(word == "request")
		{
			if(AV_RE(AVAILABLE, com.RESOURCE, RsNum))
			{
				temp = requestCheck(ALLOCATION,NEED,AVAILABLE, com,prcNum,RsNum);
			
				if(temp != 1 && temp != 2)
					enQueue(&q,com,RsNum);
			}
			else
				enQueue(&q,com,RsNum);
		}
		else if(word == "release")
		{
			int qOrderNum; //명령어 개수
			RELEASE(ALLOCATION,NEED,AVAILABLE,com,prcNum,RsNum);

			qOrderNum = q.qCount;

			for(i = 0;i < qOrderNum;i++)
			{
				com = deQueue(&q, RsNum);
				if(AV_RE(AVAILABLE,com.RESOURCE,RsNum) == 0)
				{//요청이 현재실행 가능한 양보다 클 경우
					enQueue(&q, com, RsNum);
					continue;
				}
				temp = requestCheck(ALLOCATION, NEED, AVAILABLE, com, prcNum, RsNum);
				if(temp == 0)
				     enQueue(&q, com, RsNum);
			}
		}

		foutFunction();
	}

	fin.close();
	fout.close();
	return 0;
}
