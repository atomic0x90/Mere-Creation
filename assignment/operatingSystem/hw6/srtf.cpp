#include <iostream>
#include <fstream>

#include <vector>

#include <algorithm>
#include <utility>

using namespace std;

ifstream fin("srtf.inp");
ofstream fout("srtf.out");

int testCase;
int nowTime = 0;
int waitTime = 0;

int saveUT[51];
vector < pair < pair<int,int> , pair<double,double> > > prc;

bool timeCompare(const pair< pair<int,int> , pair<double,double> > &a, const pair< pair<int,int> , pair<double,double> > &b)
{
	if(a.second.first < b.second.first)
		return true;
	else if(a.second.first > b.second.first)
		return false;
	else
	{
		if(a.second.second < b.second.second)
			return true;
		else if(a.second.second == b.second.second)
		{
			if(a.first.first < b.first.first)
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
	int num;
	double at,ut;
	fin>>testCase;
	while(testCase)
	{
		fin>>num>>at>>ut;

		pair <int,int> p1 = make_pair(num,-1);
		pair <double,double> p2 = make_pair(at,ut);
		prc.push_back(make_pair(p1,p2));
	
		testCase--;
	}

	return;
}

void foutFunction()
{
	for(int i = 0;i < prc.size();i++)
	{
		waitTime += prc[i].first.second - prc[i].second.first - saveUT[i];
	}
	fout<<waitTime<<endl;

	return;
}

void algo()
{
	int checkTime = 0;
	int savepr = 0;
	for(int i = 0;i < prc.size();i++)
	{
		if(i == 0)
		{
			savepr = 0;
			prc[0].first.second = -2;
			nowTime = prc[0].second.first;
			checkTime = nowTime + prc[0].second.second;
		}
		else
		{
			if(prc[i].first.second == -1 && prc[i].second.first < checkTime)
			{
				if(prc[i].second.second < checkTime - prc[i].second.first)
				{	//새로운 요청이 짧을 경우
					prc[savepr].second.second = checkTime - prc[i].second.first;
					nowTime = prc[i].second.first;
					checkTime = nowTime + prc[i].second.second;
					savepr = i;
					prc[i].first.second = -2;
				}
				else
				{
					prc[i].first.second = -2;
				}
			}
			else if(prc[i].first.second == -1 && prc[i].second.first == checkTime)
			{
				prc[savepr].second.second = 0;
				prc[savepr].first.second = prc[i].second.first;

				int checkpr = -1;
				int tmput = 9999999;
				for(int j = 0;j <= i;j++)
				{
					if(prc[j].first.second == -2 && tmput > prc[j].second.second)
					{
						checkpr = j;
						tmput = prc[j].second.second;
					}
				}

				if(checkpr == -1)
				{	//대기중 프로세스가 없음
					nowTime = prc[i].second.first;
					checkTime = nowTime + prc[i].second.second;
					savepr = i;
					prc[i].first.second = -2;
				}
				else
				{
					nowTime = prc[i].second.first;
					checkTime = nowTime + prc[checkpr].second.second;
					savepr = checkpr;
					prc[i].first.second = -2;	
				}
			}
			else
			{	//프로세스 종료 후 새로운 프로세스 요청이 없을 경우
				prc[savepr].second.second = 0;
				prc[savepr].first.second = checkTime;

				int checkpr = -1;
				int tmput = 99999999;
				for(int j = 0;j <= i;j++)
				{
					if(prc[j].first.second == -2 && tmput > prc[j].second.second)
					{
						checkpr = j;
						tmput = prc[j].second.second;
					}
				}

				if(checkpr == -1)
				{	//대기중인 프로세스가 없을 경우
					nowTime = prc[i].second.first;
					checkTime = nowTime + prc[i].second.second;
					savepr = i;
					prc[i].first.second = -2;
				}
				else
				{
					nowTime = checkTime;
					checkTime = nowTime + prc[checkpr].second.second;
					savepr = checkpr;
					i--;
				}
			}
		}
	}



	nowTime = checkTime;
	prc[savepr].first.second = nowTime;

	while(1)
	{
		int checktmp = -1;
		int tmput = 9999999;
		for(int i = 0;i < prc.size();i++)
		{
			if(prc[i].first.second == -2 && tmput > prc[i].second.second)
			{
				checktmp = i;
				tmput = prc[i].second.second;
			}
		}

		if(checktmp == -1)
			break;

		prc[checktmp].first.second = nowTime + prc[checktmp].second.second;
		nowTime += prc[checktmp].second.second;
	}

	return;
}

int main()
{
	finFunction();

	sort(prc.begin(),prc.end(),timeCompare);	

	for(int i = 0;i < prc.size();i++)
		saveUT[i] = prc[i].second.second;

       	algo();

	foutFunction();


	prc.clear();
	fin.close();
	fout.close();
	return 0;
}
