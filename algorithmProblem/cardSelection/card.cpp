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
int t2[1001];
int tgap[1001];

int result;


void finFunction();
void foutFunction();
void card();
void algo(int);
//int algo(int,int);
void init();


void foutFunction()
{
//	for(int i = 1;i <= cardLength;i++)
//		cout<<cardLine[i]<<" ";

//	cout<<endl;
//	for(int i = 1;i <= cardLength;i++)
//		cout<<tmpl[i]<<" ";

//	cout<<endl;
//	cout<<result<<endl;

	fout<<result<<endl;
//	fout<<tmpl[cardLength]<<endl;
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
	tmpl[1] = cardLine[1];
	tmpl[2] = cardLine[2];
	tmpl[3] = cardLine[3];

	tgap[1] = 3;
	tgap[2] = 3;
	tgap[3] = 3;

	return;
}

//tgap 1 : oxoxxx
//tgap 2 : oxxoxx
//tgap 3 : oxxxox
//tgap 5 : Same tgap 2, tgap 3 data
void algo(int now)
{
//	cout<<"now "<<now<<endl;
	if(now == 4)
	{
		if(tmpl[1] > tmpl[2])
		{
			tmpl[4] = tmpl[1] + cardLine[4];
			tgap[4] = 2;
			algo(now+1);
		}
		else
		{
			tmpl[4] = tmpl[2] + cardLine[4];
			tgap[4] = 1;
			t2[4] = tmpl[1] + cardLine[4];
			algo(now+1);
		}
	}
	else
	{
		int tt2,tt3,tt4;
//		tt2 = tt3 = tt4 = -100000;
		
		if(tgap[now-2] == 1)
		{
			tt2 = t2[now-2];
			tt3 = tmpl[now-3];
			tt4 = tmpl[now-4];
		}
		else
		{
			tt2 = tmpl[now-2];
			tt3 = tmpl[now-3];
			tt4 = tmpl[now-4];
		}


//		cout<<" tt2 tt3 tt4 "<<tt2<<" "<<tt3<<" "<<tt4<<endl;

		if(tt2 > tt3 && tt2 > tt4)
		{
			tmpl[now] = tt2 + cardLine[now];
			tgap[now] = 1;

			if(tt3 > tt4)
				t2[now] = tt3 + cardLine[now];
			else
				t2[now] = tt4 + cardLine[now];


			if(now != cardLength)
				algo(now+1);
		}
		else if(tt3 >= tt2 && tt3 > tt4)
		{
			tmpl[now] = tt3 + cardLine[now];
			tgap[now] = 2;
			if(now != cardLength)
				algo(now+1);
		}
		else if(tt4 >= tt2 && tt4 > tt3)
		{
			tmpl[now] = tt4 + cardLine[now];
			tgap[now] = 3;
			if(now != cardLength)
		       		algo(now+1);
		}
		else if(tt3 == tt4 && tt3 > tt2)
		{
			tgap[now] = 5;
			tmpl[now] = tt3 + cardLine[now];
			
			if(now != cardLength)
				algo(now+1);
		}


		if(now == cardLength)
			return;
	}


	return;
}

void init()
{
	for(int i = 1;i <= 1000;i++)
	{
		tgap[i] = 0;
		t2[i] = 0;
		tmpl[i] = 0;
	}

	result = 0;

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

		card();

		algo(4);

		result = tmpl[cardLength];

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();

	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;

	return 0;
}
