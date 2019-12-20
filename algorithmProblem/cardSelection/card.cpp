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
	return;
}

/*
 * tmpl == 0 : Not decision
 * tmpl == 1 : Selected
 * tmpl == 2 : Not selected
 *
*/
void algo()
{
	if(cardLength <= 5)
	{
	
		return;
	}

	for(int i = 0;i <= cardLength - 2;)
	{
		cout<<"i "<<i<<endl;
		int se = 0;
		int checkl;
		int tlen = cardLength - i;
		if(i == 0)
		{
			for(int j = 1;j <= 4;j++)
			{
				if(se < cardLine[i+j])
				{
					se = cardLine[i+j];
					checkl = j;
				}
			}
			
			result += se;
			tmpl[i+checkl] = 1;
			tmpl[i+checkl-1] = tmpl[i+checkl+1] = 2;
			i += checkl;

			if(checkl == 1)
			{
				tmpl[3] = 2;
			}
			else if(checkl == 3)
			{
				tmpl[1] = 2;
			}
		}
		else
		{
			if(i == 1)
			{
				if(cardLength - i < 6)
				{
					result += cardLine[i+3] + cardLine[i+5];
					return;
				}
				else
				{
					for(int j = 3;j < 5;j++)
					{
						if(se < cardLine[i+j])
						{
							se = cardLine[i+j];
							checkl = j;
						}
					}

					result += se;
					tmpl[i+checkl] = 1;
					tmpl[i+checkl-1] = tmpl[i+checkl+1] = 2;
					i += checkl;
				}
			}
			else if(i == 2)
			{
				if(cardLength - i < 6)
				{

					return;
				}
				else
				{
					for(int j = 2;j < 5;j++)
					{
						if(se < cardLine[i+j])
						{
							se = cardLine[i+j];
							checkl = j;
						}
					}

					result += se;
					tmpl[i+checkl] = 1;
					tmpl[i+checkl-1] = tmpl[i+checkl+1] = 2;
					i += checkl;
				}
			}
			else if(i == 3)
			{
				if(cardLength - i < 6)
				{
					return;
				}
				else
				{
					for(int j = 2;j < 5;j++)
					{
						if(se < cardLine[i+j])
						{
							se = cardLine[i+j];
							checkl = j;
						}
					}

					result += se;
					tmpl[i+checkl] = 1;
					tmpl[i+checkl-1] = tmpl[i+checkl+1] = 2;
					i += checkl;
				}
			}
			else
			{
				if(i == 4)
				{
					if(cardLine[1] > cardLine[2])
					{
						tmpl[1] = 1;
						result += cardLine[1];
					}
					else
					{
						tmpl[2] = 1;
						result += cardLine[2];
					}
				}

				if(cardLength - i < 6)
				{
					if(tlen == 5)
					{
						if(tmpl[i-2] == 1)
						{
							result += cardLine[i+3] + cardLine[i+5];
						}
						else
						{
							if(cardLine[i+2] > cardLine[i+3])
								result += cardLine[i+2] + cardLine[i+5];
							else
								result += cardLine[i+3] + cardLine[i+5];
						}
					}
					else if(tlen == 4)
					{
						result += cardLine[i+4];
					}
					else if(tlen == 3)
					{
						result += cardLine[i+3];
					}
					else if(tlen == 2)
					{
						result += cardLine[i] + cardLine[i+2];
					}
					break;
				}
				else
				{
					int tmpj;
					if(tmpl[i-2] == 1)
						tmpj = 3;
					else
						tmpj = 2;

					for(int j = tmpj;j < 5;j++)
					{
						if(se < cardLine[i+j])
						{
							se = cardLine[i+j];
							checkl = j;
						}
					}

					result += se;
					tmpl[i+checkl] = 1;
					tmpl[i+checkl-1] = tmpl[i+checkl+1] = 2;
					i += checkl;
				}
			}
		}
	}

	return;
}

void init()
{
	for(int i = 1;i <= 1000;i++)
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
