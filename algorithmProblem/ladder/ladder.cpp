#include <iostream>
#include <fstream>

#include <vector>
#include <tuple>

#include <algorithm>	//sort

#include <functional>	//내림차순 (greater<type>())

#include <time.h>

using namespace std;

typedef tuple <int,int,int> tu;

clock_t start_t;
double end_t;

vector < vector <tu> > v;

ifstream fin("ladder.inp");
ofstream fout("ladder.out");

int testCase;

void finFunction();
void foutFunction();
void sortFunction();
void ladder();

void finFunction()
{
	fin>>testCase;

	v.reserve(testCase);

	int t1,t2,t3,t4;
	while(1)
	{
		fin>>t1>>t2>>t3>>t4;
		
		if(t1 == 0 && t2 == 0 && t3 == 0 && t4 == 0)
			break;
		
		tu tmp = make_tuple(t2,t3,t4);
		
		v[t1].push_back(tmp);
	
		tmp = make_tuple(t4,t1,t2);

		v[t3].push_back(tmp);
	}
	
	return;
}

void sortFunction()
{
	for(int i = 0;i < testCase;i++)
		sort(v[i].begin(),v[i].end(),greater<tu>());

	return;
}

void ladder()
{
	vector <int> num;

	num.reserve(testCase);

	for(int i = 0;i < testCase;i++)
	{
		int checkf = 0;
		int d1,d2;
		d1 = get<1>(v[i][0]);
		d2 = get<2>(v[i][0]);
		
		while(1)
		{
			for(int k = 0;k < v[d1].size();k++)
			{
				if( d2 > get<0>(v[d1][k]) )
				{
					int tmpd1 = d1;
					
					d1 = get<1>(v[tmpd1][k]);
					d2 = get<2>(v[tmpd1][k]);
					
					break;
				}
				
				if(k == v[d1].size() - 1)
				{
					checkf++;
					break;
				}
			}
			if(checkf != 0)
				break;
		}
	
		num[i] = d1;
	}

	return;
}


int main()
{
	start_t = clock();

	finFunction();

	sortFunction();

	ladder();

	fin.close();
	fout.close();

	end_t = clock();

	cout<<endl<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
