#include <iostream>
#include <fstream>

#include <vector>
#include <tuple>

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
		cout<<t1<<" "<<t2<<" "<<t3<<" "<<t4<<endl;
		if(t1 == 0 && t2 == 0 && t3 == 0 && t4 == 0)
			break;
		
		tu tmp = make_tuple(t2,t3,t4);
		
		v[t1].push_back(tmp);
	
		tmp = make_tuple(t4,t1,t2);

		v[t3].push_back(tmp);
	}

	for(int i = 0;i < testCase;i++)
	{
		for(int j = 0;j < v[i].size();j++)
		{
			cout<<get<0>(v[i][j])<<" "<<get<1>(v[i][j])<<" "<<get<2>(v[i][j])<<endl;
		}
	
		cout<<endl;
	}
	return;
}

int main()
{
	start_t = clock();

	finFunction();

	fin.close();
	fout.close();

	end_t = clock();

	cout<<endl<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
