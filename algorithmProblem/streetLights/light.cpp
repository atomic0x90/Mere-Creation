#include <iostream>
#include <fstream>

#include <time.h>

#include <vector>
#include <utility>

#include <algorithm>
using namespace std;

ifstream fin("light.inp");
ofstream fout("light.out");

clock_t start_t;
double end_t;

int result;
int t1,t2;
int num;
int test;
int minL = 999999,maxR = 0;

vector <pair <int,int> > light;

void finFunction();
int algo(int,int);

bool compare(const pair<int,int> &a,const pair<int,int> &b)
{
	if(a.first != b.first)
		return a.first < b.first;
	else
		return a.second > b.second;
}

void finFunction()
{
	fin>>num;

	light.reserve(num);

	for(int i = 0;i < num;i++)
	{
		fin>>t1>>t2;
	
		if(minL > t1)
			minL = t1;
		if(maxR < t2)
			maxR = t2;


		light.push_back({t1,t2});
//		light[i].first = t1;
//		light[i].second = t2;
	}

	sort(light.begin(),light.end(),compare);
	
	fin>>test;

	return;
}

int algo(int L,int R,int now)
{
	int checkR = 0,checknow = now;
	for(int i = now+1;i < num;i++)
	{
		if(light[i].first > R)
			break;

		if(light[i].first != checknow && light[i].first <= L && light[i].second >= L && checkR < light[i].second)
		{
			checknow = i;
			checkR = light[i].second;
		}
	}

	if(checkR)
	{
		if(checkR >= R)
			return ++result;
		else
		{
			algo(checkR,R,checknow);
			return ++result;
		}
	}
	else
		return result = -999999;
}

int main()
{
	start_t = clock();

	finFunction();

	while(test)
	{
		result = 0;
		fin>>t1>>t2;

		int tmp;//	= algo(t1,t2,-1);

		if(t1 < minL || t2 > maxR)
			tmp = -1;
		else
			tmp = algo(t1,t2,-1);

		if(tmp > 0)
			fout<<tmp<<endl;
		else
			fout<<"-1"<<endl;
		test--;
	}

	fin.close();
	fout.close();
	end_t = clock();
	cout<<(double)((end_t - start_t)/CLOCKS_PER_SEC)<<endl;
	return 0;
}
