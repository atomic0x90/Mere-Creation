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
vector < pair<int,int> > qprc;
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

bool qCompare(const pair<int,int> &a, const pair<int,int> &b)
{
	if(a.second > b.second)
		return true;
	else if(a.second < b.second)
		return false;
	else
	{
		if(a.first < b.first)
			return false;
		else
			return true;
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

		saveUT[num] = ut;
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
		cout<<prc[i].first.first<<" "<<prc[i].first.second<<" "<<prc[i].second.first<<" "<<saveUT[i]<<endl;
	}
	fout<<waitTime<<endl;

	return;
}

void algo()
{
	int checkTime = 0;
	int save = 0;
	for(int i = 0;i < prc.size();i++)
	{
		cout<<"nowTime : "<<nowTime<<" "<<save<<" "<<checkTime<<endl;
		if(i == 0)
		{
			prc[i].first.second = -2;
			nowTime = 0;
			checkTime = prc[i].second.second;
			save = 0;
		}
		else
		{
			if(checkTime > prc[i].second.first)
			{
				if(prc[i].first.second == -1)
				{
					if(nowTime + prc[save].second.second - prc[i].second.first > prc[i].second.second)
					{
						cout<<"111111111111111111"<<endl;
						prc[save].second.second += nowTime - prc[i].second.first;
						nowTime = prc[i].second.first;
						save = i;
						checkTime = nowTime + prc[i].second.second;
						prc[i].first.second = -2;
					}
					else
					{
						cout<<"2222222222222222222"<<endl;
						prc[i].first.second = -2;
					}
				}
			}
			else if(checkTime == prc[i].second.first)
			{
				prc[save].first.second = prc[i].second.first;
			
				int check = 9999999,tmp = -1;
				for(int j = 0;j < prc.size();j++)
				{
					if(prc[j].first.second == -2 && prc[i].second.second > prc[j].second.second)
					{
						if(check > prc[j].second.second)
						{
							check = prc[j].second.second;
							tmp = j;
						}
					}
				}

				if(tmp == -1)
				{
					cout<<"3333333333333333"<<endl;
					nowTime = prc[i].second.first;
					prc[i].first.second = -2;
					save = i;
					checkTime = nowTime + prc[i].second.second;
				}
				else
				{
					cout<<"4444444444444444"<<endl;
					nowTime = prc[i].second.first;
					prc[i].first.second = -2;
					save = tmp;
					checkTime = nowTime + check;
				}
			}
			else
			{
				prc[save].first.second = checkTime;

				nowTime = checkTime;

				int check = 9999999,tmp = -1;
				for(int j = 0;j < prc.size();j++)
				{
					if(prc[j].first.second == -2 && prc[j].second.second < check)
					{
						check = prc[j].second.second;
						tmp = j;
					}
				}

				if(tmp == -1)
				{
					cout<<"55555555555555555"<<endl;
					nowTime = prc[i].second.first;
					checkTime = nowTime + prc[i].second.second;
					save = i;
					prc[i].first.second = -2;
				}
				else
				{
					cout<<"6666666666666666666"<<endl;
					nowTime = checkTime;
					save = tmp;
					checkTime = nowTime + prc[tmp].second.second;
					
				}
			}
		}

		for(int l = 0;l < prc.size();l++)
		{
			cout<<i<<"번째 : l "<<l<<" "<<prc[l].first.first<<" "<<prc[l].first.second;
			cout<<" "<<prc[l].second.first<<" "<<prc[l].second.second<<endl;
		}
		cout<<endl;
	}


	nowTime = checkTime;
	prc[save].first.second = nowTime;
cout<<"nowTime : "<<nowTime<<" "<<save<<" "<<checkTime<<endl;

	while(1)
	{
		int min = 9999999;
		int save = 0;

		int checknum = 1;
		for(int i = 0;i < prc.size();i++)
		{
			if(prc[i].first.second < 0)
				checknum = 0;

			if(prc[i].first.second < 0 && prc[i].second.second < min)
			{
				min = prc[i].second.second;
				save = i;
			}
		}

		if(checknum)
			break;

		prc[save].first.second = nowTime + prc[save].second.second;
		nowTime += prc[save].second.second;
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
