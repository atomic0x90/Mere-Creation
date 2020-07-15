#include <iostream>
#include <fstream>

#include <vector>

#include <algorithm>
#include <utility>

using namespace std;

ifstream fin("hrrn.inp");
ofstream fout("hrrn.out");

int testCase;
int nowTime = 0;
int waitTime = 0;

vector < pair < pair<int,int> , pair<double,double> > > prc;

bool timeCompare(const pair< pair<int,int> , pair<double,double> > &a ,const pair< pair<int,int> , pair<double,double> > &b)
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
	int num;
	double at,ut;
	fin>>testCase;
	while(testCase)
	{
		fin>>num>>at>>ut;

		pair <int,int> p1 = make_pair(num,0);
		pair <double,double> p2 = make_pair(at,ut);
		prc.push_back(make_pair(p1,p2));
	
		testCase--;
	}

	return;
}

void foutFunction()
{
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
			double checkPriority = -1;

			for(int j = 1;j < prc.size();j++)
			{
				if(prc[j].first.second == 0 && prc[j].second.first <= nowTime)
				{
					double tmpWait = nowTime - prc[j].second.first;
					if(checkPriority < ( (tmpWait + prc[j].second.second) / prc[j].second.second ) )
					{
						checkPRC = j;
						checkPriority = ( tmpWait + prc[j].second.second ) / prc[j].second.second;
					}
					else if(checkPriority == ( tmpWait + prc[j].second.second) / prc[j].second.second)
					{
						if(prc[j].first.first < prc[checkPRC].first.first)
							checkPRC = j;
					}
				}
			}


			if(checkPRC == -1)
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
	finFunction();

	sort(prc.begin(),prc.end(),timeCompare);

	algo();

	foutFunction();

	prc.clear();
	fin.close();
	fout.close();

	return 0;
}
