#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("coin.inp");
ofstream fout("coin.out");

clock_t start_t;
double end_t;

int b1,b2,b3;

int testCase;
int result;

void init();
void finFunction();
void foutFunction();
int algo(int,int,int);

void finFunction()
{
	fin>>b1>>b2>>b3;

	return;
}

void init()
{
	result = 0;
	return;
}

void foutFunction()
{
//	cout<<"("<<b1<<" "<<b2<<" "<<b3<<") : "<<result<<endl;
	fout<<"("<<b1<<" "<<b2<<" "<<b3<<") : "<<result<<endl;
	
	return;
}

int algo(int t1,int t2,int t3)
{
	int max,data;

	t1 %= 4;
	t2 %= 4;
	t3 %= 4;
	
//	cout<<t1<<" "<<t2<<" "<<t3<<endl;

	if(t1 >= t2 && t1 >= t3)
		max = t1;
	else if(t2 >= t1 && t2 >= t3)
		max = t2;
	else
		max = t3;

	if( (t1 == 0 && t2 != 0 && t3 != 0) || (t1 != 0 && t2 == 0 && t3 != 0) || (t1 != 0 && t2 != 0 && t3 == 0) )
	{	//1개 0
		if(t1+t2+t3 == 2)
			return 1;

		data = (t1+t2+t3) % max;

		if(data == 0)
			return -1;
		else
			return 1;
	}
	else if( (t1 == 0 && t2 == 0 && t3 != 0) || (t1 == 0 && t2 != 0 && t3 == 0) || (t1 != 0 && t2 == 0 && t3 == 0) )
	{	//2개 0
		if(t1 + t2 + t3 == 1)
			return -1;
		else
			return 1;
	}
	else if(t1 == 0 && t2 == 0 && t3 == 0)
	{	//3개 0
		return 1;
	}
	else
	{
		if(t1+t2+t3 == 3)
			return -1;
		else
		{
			if(max == 2 || t1 + t2 + t3 == 9)
			{
				return 1;
			}
			else
			{
				data = (t1+t2+t3) % max;

				if(data == 0)
					return -1;
				else
					return 1;
			}
		}
	}
}


int main()
{
	start_t = clock();

	fin>>testCase;
	while(testCase)
	{
		finFunction();
		
		init();
		
		result = algo(b1,b2,b3);

		foutFunction();
	
		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
