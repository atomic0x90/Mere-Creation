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

void finFunction();
void foutFunction();
void card();

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

void card()
{
	int tmp = cardLength;

	int c4,c3,c2;	//Card order
	int t2,t3,t4;	//Card sum data

	int checkl = tmp;	//Check last card;

	for(int i = cardLength;i > 0;)
	{
		t2 = t3 = t4 = -10000;

		c4 = i - 4;
		c3 = i - 3;
		c2 = i - 2;
		
		cout<<"i "<<i<<" "<<cardLine[i]<<" "<<checkl<<endl;
		
		if(i > 3)
		{
			result += cardLine[i];
		
			if(c4 <= 3 && c4 > 0)
				t4 = cardLine[c4];
			else if(c4 > 3)
			{
				for(int j = 2;j < 5;j++)
				{
					if(cardLine[c4] + cardLine[c4 - j] > t4)
						t4 = cardLine[c4] + cardLine[c4 - j];
				}
			}
			
			if(c3 <= 3 && c3 > 0)
				t3 = cardLine[c3];
			else if(c3 > 3)
			{
				for(int j = 2;j < 5;j++)
				{
					if(cardLine[c3] + cardLine[c3 - j] > t3)
						t3 = cardLine[c3] + cardLine[c3 - j];
				}
			}
			
			if(c2 <= 3 && c2 > 0)
				t2 = cardLine[c2];
			else if(c2 > 3)
			{
				for(int j = 3;j < 5;j++)
				{
					if(cardLine[c2] + cardLine[c2 - j] > t2)
						t2 = cardLine[c2] + cardLine[c2 - j];
				}
			}
		
			checkl = i;

			if(t4 > t3 && t4 > t2)	//t4
				i = c4;
			else if(t3 > t4 && t3 > t2)	//t3
				i = c3;
			else if(t2 > t4 && t2 > t3)	//t2
				i = c2;
		
			cout<<"t data "<<t4<<" "<<t3<<" "<<t2<<endl;
		}
		/*
		else if(i > 3)		//Middle card
		{}
		*/
		else if(i <= 3)		//First card
		{
			result += cardLine[i];
			break;
		}
	}

	return;
}

int main()
{
	fin>>testCase;

	while(testCase)
	{
		result = 0;

		finFunction();

		card();

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
