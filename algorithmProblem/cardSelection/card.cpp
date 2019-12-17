#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("card.inp");
ofstream fout("card.out");

clock_t start_t;
double end_t;

int testCase;
int cardLength;
int cardLine[1001];

int result;

int tmp = 0;

void finFunction();
void foutFunction();
void card();

void algo(int,int);

void foutFunction()
{
	for(int i = 1;i <= cardLength;i++)
		cout<<cardLine[i]<<" ";

	cout<<endl;
	cout<<result<<endl;

	fout<<result<<endl;
	return;
}

void finFunction()
{
	fin>>cardLength;

	for(int i = 1;i <= cardLength;i++)
		fin>>cardLine[i];

	return;
}

void algo(int now,int range)
{
//	cout<<"now "<<now<<" data "<<cardLine[now]<<endl;
	if(now > 3)
	{
		tmp += cardLine[now];

		int t2,t3,t4;
		t2 = t3 = t4 = 0;

		if(range == 2)
		{
			if(now - 4 > 0)
			{
				if(cardLine[now-4] < cardLine[now-3] && cardLine[now-4] < cardLine[now-2])
				{	//The smallest of 'now-4' data 
		//			if(cardLine[now-3] > cardLine[now-2])
						t3++;
		//			else if(cardLine[now-2] > cardLine[now-3])
						t2++;
				}
				else if(cardLine[now-3] < cardLine[now-4] && cardLine[now-3] < cardLine[now-2])
				{	//The smallest of 'now-3' data
		//			if(cardLine[now-4] > cardLine[now-2])
						t4++;
		//			else if(cardLine[now-2] > cardLine[now-4])
						t2++;
				}
				else if(cardLine[now-2] < cardLine[now-4] && cardLine[now-2] < cardLine[now-3])
				{	//The smallest of 'now-2' data
		//			if(cardLine[now-4] > cardLine[now-3])
						t4++;
		//			else if(cardLine[now-3] > cardLine[now-4])
						t3++;
				}
			}
			else if(now - 3 > 0)
			{
				if(cardLine[now-3] < cardLine[now-2])
				{
					t2++;
				}
				else
					t3++;
			}
		}


		if(range != 3 && now - 2 > 0 && t2 != 0)	//When not coninuous 2 gap
		{
			algo(now - 2,3);
		}

		if(now - 3 > 0 && t3 != 0)
			algo(now - 3,2);

		if(now - 4 > 0 && t4 != 0)
			algo(now - 4,2);

		tmp -= cardLine[now];
	}
	else if(now <= 3 && now > 0)
	{
		tmp += cardLine[now];

//		cout<<"tmp "<<tmp<<" result "<<result<<endl<<endl;

		if(tmp > result)
			result = tmp;

		tmp -= cardLine[now];
	}

	return;
}

void card()
{
	algo(cardLength,2);
	return;
}

int main()
{
	fin>>testCase;

	while(testCase)
	{
		result = -100000;
		finFunction();

		card();

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
