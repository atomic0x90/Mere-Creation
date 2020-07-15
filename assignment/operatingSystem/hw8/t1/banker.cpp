#include <iostream>
#include <fstream>

#include <queue>

#include <cstring>

#include <vector>
using namespace std;

int prc;
int rNum;

int systemR[51] = {0,};
int MAX[51][51] = {0,};
int ALLOCATION[51][51] = {0,};

int NEED[51][51] = {0,};

int now[51] = {0,};
int AVAILABLE[51] = {0,};

int nextP;
int nextR[51] = {0,};

string order;

queue <int> q;

vector < vector <int> > v;

int checkV = 0;

ifstream fin("banker.inp");
ofstream fout("banker.out");

void finFunction()
{
	fin>>prc>>rNum;

	for(int i = 0;i < rNum;i++)
		fin>>systemR[i];

	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
			fin>>MAX[i][j];
	}

	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
			fin>>ALLOCATION[i][j];
	}



/*
	for(int i = 0;i < rNum;i++)
		cout<<systemR[i]<<" ";
	cout<<endl;

	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
			cout<<MAX[i][j]<< " ";
		cout<<endl;
	}

	cout<<endl;

	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
			cout<<ALLOCATION[i][j]<<" ";
		cout<<endl;
	}
*/
	return;
}

void orderFin()
{
	fin>>nextP;
	for(int i = 0;i < rNum;i++)
		fin>>nextR[i];


	cout<<nextP<<" : ";

	for(int i = 0;i < rNum;i++)
		cout<<nextR[i]<<" ";
	cout<<endl;

	return;
}

void availableAlgo()
{
	for(int i = 0;i < rNum;i++)
	{
		now[i] = 0;
		AVAILABLE[i] = 0;
	}
	for(int i = 0;i < rNum;i++)
	{
		for(int j = 0;j < prc;j++)
		{
			AVAILABLE[i] += ALLOCATION[j][i];
		}
		now[i] = AVAILABLE[i];
	}

	for(int i = 0;i < rNum;i++)
		AVAILABLE[i] = systemR[i] - AVAILABLE[i];

	cout<<"available"<<endl;
	for(int i = 0;i < rNum;i++)
		cout<<AVAILABLE[i]<<" ";
	cout<<endl;

	cout<<endl<<"now"<<endl;
	for(int i = 0;i < rNum;i++)
		cout<<now[i]<<" ";
	cout<<endl;


	return;
}

void needAlgo()
{
	cout<<"NEED"<<endl;
	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
		{
			NEED[i][j] = MAX[i][j] - ALLOCATION[i][j];
			cout<<NEED[i][j]<<" ";
		}
		cout<<endl;
	}

	return;
}

void checkRequest()
{
	cout<<endl<<"CHECK REQUEST"<<endl;
	int tmp1 = 0;
	int tmp2 = 0;

	for(int i = 0;i < rNum;i++)
	{
		if(nextR[i] > AVAILABLE[i])	//다음 요청이 현재 사용 가능한 범위를 벗어난 경우
		{
			tmp1++;
			break;
		}
	}


	for(int i = 0;i < rNum;i++)
	{
		if(NEED[nextP][i] < nextR[i])
		{
			tmp2++;
			break;
		}
	}

	if(tmp1 == 0 && tmp2 == 0)	//현재 사용 가능
	{
		for(int i = 0;i < rNum;i++)
			ALLOCATION[nextP][i] += nextR[i];
	}
	else	//현재 사용 불가 -> 큐에 넣고 대기
	{
		q.push(checkV);


		v[checkV].reserve(rNum + 1);

		for(int i = 0;i < rNum;i++)
			v[checkV][i] = nextR[i];

		v[checkV][rNum] = nextP;

		cout<<"vector"<<endl;
		for(int i = 0;i < rNum + 1;i++)
			cout<<v[checkV][i]<<" ";
		cout<<endl;

		checkV++;
	}

	cout<<q.empty()<<endl;
	cout<<"END CHECK REQUEST"<<endl;
	return;
}

void checkRelease()
{
	for(int i = 0;i < rNum;i++)
	{
		ALLOCATION[nextP][i] -= nextR[i];
	}


	availableAlgo();

	while(1)
	{
		if(!q.empty())	//대기중인 prc가 있는 경우
		{
			int tmpF = q.front();
			int tmpCheck = 0;

			for(int i = 0;i < rNum;i++)
			{
				if(v[tmpF][i] > AVAILABLE[i])
				{
					tmpCheck++;
					break;
				}
			}

			if(tmpCheck == 0)	//사용 가능
			{
				for(int i = 0;i < rNum;i++)
				{
					ALLOCATION[v[tmpF][rNum]][i] += v[tmpF][i];
				}

				q.pop();

			}
			else
				break;
		}

		else
			break;
	}


	return;
}

int main()
{
	finFunction();

	v.reserve(1000);

	while(1)
	{
		cout<<"---------------------------------------"<<endl;
		fin>>order;

		cout<<order<<" ";
		if(order == "quit")
			break;

		orderFin();
		needAlgo();
		availableAlgo();

		if(order == "request")
		{
			checkRequest();
		}
		else if(order == "release")
		{
			checkRelease();
		}


		cout<<"available "<<endl;
		availableAlgo();
		cout<<endl;

		for(int i = 0;i < rNum;i++)
			fout<<AVAILABLE[i]<<" ";
		fout<<endl;


		cout<<"allocation"<<endl;
		for(int i = 0;i < prc;i++)
		{
			for(int j = 0;j < rNum;j++)
				cout<<ALLOCATION[i][j]<<" ";
			cout<<endl;
		}

		cout<<"---------------------------------------end"<<endl;
	}

	v.clear();
	fin.close();
	fout.close();

	return 0;
}
