#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

clock_t start_t;
double end_t;

int testCase;

int card[1001];
int front,rear;
int result;

ifstream fin("card.inp");
ofstream fout("card.out");

void finFunction();
void foutFunction();
void algo();
void init();

void init()
{
	result = 0;

	front = 1;

	for(int i = 0;i < 1001;i++)
		card[i] = 0;

	return;
}

void finFunction()
{
	fin>>rear;

	for(int i = 1;i <= rear;i++)
		fin>>card[i];

	for(int i = 1;i <= rear;i++)
		cout<<card[i]<<" ";

	cout<<endl;

	return;
}

void algo()
{
	int order = 1;
	//order % 2 == 1 : Alice
	//order % 2 == 0 : Computer

	while(1)
	{
		cout<<"front "<<front<<" rear "<<rear<<endl;

		if(rear - front <= 2)
		{
			for(int i = 0;i < 2;i++)
			{
				if(card[front] >= card[rear])
				{
					if(order % 2 == 1)
						result += card[front];
	
					front++;
				}
				else
				{
					if(order % 2 == 1)
						result += card[rear];
	
					rear--;
				}

				order++;
			}

			if(order % 2 == 1)
				result += card[front];

			break;
		}

		int tf,tr;

		tf = card[front+1] + card[rear];
		tr = card[front] + card[rear-1];

		if(tf > tr)
		{
			if(order % 2 == 1)
				result += card[rear];
	
			rear--;
		}
		else if(tf < tr)
		{
			if(order % 2 == 1)
				result += card[front];
	
			front++;
		}
		else if(tf == tr)
		{
			if(card[front] > card[rear])
			{
				if(order % 2 == 1)
					result += card[front];

				front++;
			}
			else if(card[front] < card[rear])
			{
				if(order % 2 == 1)
					result += card[rear];

				rear--;
			}
			else if(card[front] == card[rear])
			{
				if(order % 2 == 1)
					result += card[front];

				front++;
			}
		}

		
		order++;
	}

	return;
}

void foutFunction()
{
	cout<<result<<endl;
	fout<<result<<endl;

	return;
}

int main()
{
	start_t = clock();

	fin>>testCase;

	while(testCase)
	{
		init();

		finFunction();

		algo();

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();

	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;

	return 0;
}
