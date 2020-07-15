#include <iostream>
#include <fstream>

#include <queue>

#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

ifstream fin("rr.inp");
ofstream fout("rr.out");

vector < pair <int,int> > v1;
vector < pair < pair<int,int> , pair<int,int> > > v2;
//CPU 사용 요구 시간(남은 시간), IO 사용 요구 시간, CPU 사용 요구 시간, prc 처음 ready queue 확인

vector < pair < pair<int,int> , pair<int,int> > > tmpv;	//지금 시간에 동시에 들어올 경우를 대비한 임시 vector

queue < pair < pair<int,int> , pair<int,int> > > q1;	//ready queue

queue < pair <int,int> > realq;		//run queue


int prcNum;
int timeSlice;

int firstCheck[101] = {0,};
int checkTime[101] = {0,};

int checkNum[101] = {0,};	//몇번째 요구인지

void finFunction()
{
	int a,b;
	fin>>prcNum>>timeSlice;

	for(int i = 0;i < prcNum;i++)
	{
		fin>>a>>b;
		v1[i].first = a;
		v1[i].second = b;

		cout<<a<<" "<<b<<endl;
		for(int j = 0;j < (v1[i].second/2) + 1;j++)
		{
			if(j != v1[i].second/2)
				fin>>a>>b;
			else
			{
				fin>>a;
				b = 0;
			}
			cout<<a<<" "<<b<<endl;
			v2[j].first.first = a;
			v2[j].first.second = b;
			v2[j].second.first = a;
			v2[j].second.second = 0;
		}
		cout<<endl;
	}
	return;
}

void algo()
{
	int nowTime = 0;
	
	while(true)
	{
		for(int i = 0;i < prcNum;i++)
		{
			if(checkNum[i] == 0)
			{
				cout<<"i : "<<i<<endl;
				cout<<v2[0].first.first<<v1[0].first<<" "<<v2[i].first.first<<endl;
				if(v1[i].first == nowTime)
					q1.push(v2[0]);
			}
			else
			{}
		}


		break;
	
		nowTime++;
	}
	while(!q1.empty())
	{
		cout<<q1.front().first.first<<" "<<q1.front().first.second<<endl;
	
		q1.pop();
	}
	

	return;
}

int main()
{
	v1.reserve(101);
	v2.reserve(101);
	
	finFunction();

	algo();

	fin.close();
	fout.close();
	return 0;
}
