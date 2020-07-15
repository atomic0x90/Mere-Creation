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

long long n,at,ut;

long long nowTime = 0;
long long waitTime = 0;

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
		else if(a.first.first == b.first.first)
		{
			if(a.second.second < b.second.second)
				return true;
			else
				return false;
		}
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
			{
	//			cout<<"A now:"<<nowTime<<" wait:"<<waitTime<<" at:"<<prc[i].second.first;
	//			cout<<" ut:"<<prc[i].second.second<<endl;
				waitTime += (nowTime - prc[i].second.first);
				nowTime += prc[i].second.second;
			}
			else
			{
	//			cout<<"B now:"<<nowTime<<" wait:"<<waitTime<<endl;
				nowTime = prc[i].second.first + prc[i].second.second;
			}
		}

	//	cout<<i<<" now :"<<nowTime<<" wait:"<<waitTime<<endl<<endl;
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

//	for(int i = 0;i < prc.size();i++)
//		cout<<prc[i].first.first<<" "<<prc[i].second.first<<" "<<prc[i].second.second<<endl;
//	cout<<endl;

	algo();

	foutFunction();

	fin.close();
	fout.close();

	return 0;
}
