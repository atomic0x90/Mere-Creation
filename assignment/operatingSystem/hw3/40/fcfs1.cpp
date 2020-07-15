#include <iostream>
#include <fstream>

#include <vector>

#include <algorithm>
#include <utility>

using namespace std;

ifstream fin("fcfs.inp");
ofstream fout("fcfs.out");

vector < pair< pair<int,int> , pair<int,int> > > prc;

int testCase;

int n,at,ut;

int nowTime = 0;
int waitTime = 0;

bool timeCompare(const pair< pair<int,int> , pair<int,int> > &a, const pair< pair<int,int> , pair<int,int> > &b)
{
	if(a.second.first < b.second.first)
		return true;
	else if(a.second.first > b.second.first)
		return false;
	else
	{
		if(a.first.first < b.first.first)
			return true;
		else
			return false;
	}
}

void finFunction()
{
	fin>>n>>at>>ut;

	pair <int,int> p1 = make_pair(n,0);
	pair <int,int> p2 = make_pair(at,ut);

	prc.push_back(make_pair(p1,p2));

	return;
}

void foutFunction()
{
	prc.clear();

	fout<<waitTime<<endl;

	return;
}

void algo()
{
	for(int i = 0;i < prc.size();i++)
	{
		if(i == 0)
		{
			nowTime = prc[i].second.first + prc[i].second.second;
			waitTime = 0;
		}
		else
		{
			if(nowTime > prc[i].second.first)	//대기 시간 발생
				waitTime += (nowTime - prc[i].second.first);

			nowTime += prc[i].second.second;
		}
	}

	return;
}

int main()
{
	fin>>testCase;

	while(testCase)
	{
		finFunction();
	
		testCase--;
	}


	sort(prc.begin(),prc.end(),timeCompare);

	algo();

	foutFunction();

	fin.close();
	fout.close();

	return 0;
}
