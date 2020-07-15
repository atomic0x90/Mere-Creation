#include <iostream>
#include <fstream>

#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

ifstream fin("sjf.inp");
ofstream fout("sjf.out");

vector <pair < pair<int,int> , pair<int,int> > > prc;

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
		if(a.second.second < b.second.second)
			return true;
		else if(a.second.second > b.second.second)
			return false;
		else
		{
			if(a.first.first < b.first.first)
				return true;
			else
				return false;
		}
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
			prc[i].first.second = 1;
		}
		else
		{
			int checkPRC = -1;
			int checkUT = 999999999;

			for(int j = 1;j < prc.size();j++)
			{
				if(prc[j].first.second == 0 && prc[j].second.first <= nowTime)
				{
					if(prc[j].second.second < checkUT)
					{
						checkPRC = j;
						checkUT = prc[j].second.second;
					}
					else if(prc[j].second.second == checkUT)
					{
						if(prc[j].first.first < prc[checkPRC].first.first)
							checkPRC = j;
					}
				}
			}


			if(checkPRC == -1)	//실행이 도착 시간 보다 빨리 끝났을 때
			{
				prc[i].first.second = 1;
				nowTime += prc[i].second.first - nowTime + prc[i].second.second;
			}
			else
			{
				prc[checkPRC].first.second = 1;
				waitTime += nowTime - prc[checkPRC].second.first;
				nowTime += prc[checkPRC].second.second;
			}
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
