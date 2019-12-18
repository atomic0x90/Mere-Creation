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

int tmpl[1001];

int result;


void finFunction();
void foutFunction();
void card();
void algo();
void init();


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
	for(int i = 1;i <= cardLength;i++)
	{
		if(i <= 3 || i > cardLength - 2)
		{
			tmpl[i] = cardLine[i];
		}
		else if(i == cardLength - 2)
		{
			for(int j = 1;j <= 3;j++)
				tmpl[i] += cardLine[i-j];

			for(int j = 1;j <= 2;j++)
				tmpl[i] += cardLine[i+j];
		}
		else
		{
			for(int j = 1;j <= 3;j++)
				tmpl[i] += cardLine[i-j];

			for(int j = 1;j <= 3;j++)
				tmpl[i] += cardLine[i+j];
		}
	}

	return;
}

void algo()
{
	int range = 0;

	for(int i = cardLength;i > 0;)
	{
		int low = 10000;
		int check = 0;
		cout<<"i "<<i<<endl;
		if(i == cardLength)
		{
			cout<<"First "<<cardLine[i]<<endl;
			result += cardLine[i];

			i -= 2;

			range = 2;
		}
		else if(i < 7)
		{
			cout<<"in < 7 "<<i<<" "<<range<<endl;
			if(i == 2)
			{
				if(tmpl[1] > tmpl[2])
					result += tmpl[1];
				else
					result += tmpl[2];
			
				break;
			}
			else if(i == 3)
			{
				if(range == 2)	//1,2,3
				{
					if(tmpl[1] > tmpl[2] && tmpl[1] > tmpl[3])
						result += tmpl[1];
					else if(tmpl[2] > tmpl[1] && tmpl[2] > tmpl[3])
						result += tmpl[2];
					else if(tmpl[3] > tmpl[1] && tmpl[3] > tmpl[2])
						result += tmpl[3];
				}
				else if(range == 1)	//2,3
				{
					if(tmpl[1] > tmpl[2])
						result += tmpl[1];
					else
						result += tmpl[2];
				}
			
				break;
			}
			for(int j = 4;j < 7;j++)
			{
				if(low > tmpl[j])
				{
					check = j;
					low = tmpl[j];
				}
			}

			if(check == 4)
			{
				result += cardLine[4];

				if(tmpl[1] > tmpl[2])
					result += cardLine[1];
				else
					result += cardLine[2];
			}
			else if(check == 5)
			{
				result += cardLine[5];

				if(tmpl[1] > tmpl[2] && tmpl[1] > tmpl[3])
					result += tmpl[1];
				else if(tmpl[2] > tmpl[1] && tmpl[2] > tmpl[3])
					result += tmpl[2];
				else if(tmpl[3] > tmpl[1] && tmpl[3] > tmpl[2])
					result += tmpl[3];
			}
			else if(check == 6)
			{
				result += cardLine[6];

				if(cardLine[4] + cardLine[1] > cardLine[3] && cardLine[4] + cardLine[1] > cardLine[2])
				{
					result += cardLine[4] + cardLine[1];
				}
				else if(cardLine[3] > cardLine[4] + cardLine[1] && cardLine[3] > cardLine[2])
				{
					result += cardLine[3];
				}
				else if(cardLine[2] > cardLine[4] + cardLine[1] && cardLine[2] > cardLine[3])
				{
					result += cardLine[2];
				}
			}


			break;
		}
		else
		{
			cout<<"cardLine "<<cardLine[i]<<" "<<cardLine[i-1]<<" "<<cardLine[i-2]<<endl;
			cout<<"tmp "<<result<<"\t\t"<<tmpl[i]<<" "<<tmpl[i-1]<<" "<<tmpl[i-2]<<endl;
			for(int j = i;j >= i-range;j--)
			{
				if(low > tmpl[j])
				{
					check = j;
					low = tmpl[j];
				}
			}

			if(check == i)
			{
				result += cardLine[check];
				i -= 3;

				range = 1;
			}
			else if(check == i - 1)
			{
				result += cardLine[check];
				i -= 3;

				range = 2;
			}
			else if(check == i - 2)
			{
				result += cardLine[check];
				i -= 4;

				range = 2;
			}
			cout<<"select i "<<check<<endl<<endl;
		}
	}
}

void init()
{
	for(int i = 0;i < 1001;i++)
		tmpl[i] = 0;

	result = 0;

	return;
}

int main()
{
	fin>>testCase;

	while(testCase)
	{
		init();
		
		finFunction();

		card();

		algo();

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
