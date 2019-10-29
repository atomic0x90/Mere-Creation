#include <iostream>
#include <fstream>

using namespace std;

ifstream fin("paper.inp");
ofstream fout("paper.out");

int testCase;
int x[2000] = {0,},y[2000] = {0,},xx[2000] = {0,},yy[2000] = {0,};
int checkOL[2000] = {0,};

void finFunction();
void overlapCheck();
void foutFunction();

void finFunction()
{
	fin>>testCase;
	
	int t1,t2,t3,t4;
	int i = 0,tmp = testCase;
	while(tmp)
	{
		fin>>t1>>t2>>t3>>t4;
		
		x[i] = t1;
		y[i] = t2;
		xx[i] = t1 + t3;
		yy[i] = t2 + t4;
		
		i++;
		tmp--;
	}

	return;
}

void overlapCheck()
{
	int tmp = testCase-1;

	for(int i = tmp;i >= 0;i--)
	{
		for(int j = tmp;j > i;j--)
		{
			if(x[i] >= x[j] && y[i] >= y[j] && xx[i] <= xx[j] && yy[i] <= yy[j])
			{	//전부 덮일 경우
				x[i] = x[j];
				y[i] = y[j];
				xx[i] = xx[j];
				yy[i] = yy[j];
				checkOL[i] = 2;
				break;
			}
			
			if(x[i] == x[j] && xx[i] == xx[j])
			{	//x좌표가 같을 경우
				if(y[i] <= y[j] && y[j] <= yy[i] && yy[i] <= yy[j])
				{
					y[j] = y[i];
					yy[i] = yy[j];
					checkOL[i] = 1;
				}
				else if(y[i] >= y[j] && y[i] <= yy[j] && yy[i] >= yy[j])
				{
					y[i] = y[j];
					yy[j] = yy[i];
					checkOL[i] = 1;
				}
			}
			else if(y[i] == y[j] && yy[i] == yy[j])
			{	//y좌표가 같을 경우
				if(x[i] <= x[j] && x[j] <= xx[i] && xx[i] <= xx[j])
				{
					x[j] = x[i];
					xx[i] = xx[j];
					checkOL[i] = 1;
				}
				else if(x[i] >= x[j] && x[i] <= xx[j] && xx[i] >= xx[j])
				{
					x[i] = x[j];
					xx[j] = xx[i];
					checkOL[i] = 1;
				}
			}
			else if( ((xx[i] < x[j]) || (x[i] > xx[j])) && ((yy[i] < y[j]) || (y[i] > yy[j])) )
			{	//겹치지 않는 경우
//				if(checkOL[i] != 1)
//					checkOL[i] = 0;
			}
			else if( (x[i] <= x[j] && xx[i] >= x[j]) || (x[i] <= xx[j] && xx[i] >= xx[j]) )
			{
				//모서리
				if( (y[i] <= y[j] && yy[i] >= y[j]) || (y[i] <= yy[j] && yy[i] >= yy[j]) )
					checkOL[i] = 1;
				else if(y[i] >= y[j] && yy[i] <= yy[j])
					checkOL[i] = 1;
			}
			else if( (y[i] <= y[j] && yy[i] >= y[j]) || (y[i] <= yy[j] && yy[i] >= yy[j]) )
			{
				//모서리
				if( (x[i] <= x[j] && xx[i] >= x[j]) || (x[i] <= xx[j] && xx[i] >= xx[j]) )
					checkOL[i] = 1;
				else if(x[i] >= x[j] && xx[i] <= xx[j])
					checkOL[i] = 1;
			}

//			else
//				checkOL[i] = 1;

		}
	}

	return;
}

void foutFunction()
{
	int t0,t1,t2;
	t0 = t1 = t2 = 0;
	for(int i = 0;i<testCase;i++)
	{
		if(checkOL[i] == 2)
			t2++;
		else if(checkOL[i] == 1)
			t1++;
		else
			t0++;
	}
	cout<<t2<<" "<<t1<<" "<<t0<<endl;

	return;
}

int main()
{
	finFunction();
	overlapCheck();
	cout<<"testCase "<<testCase<<endl;
	for(int i = 0;i<testCase;i++)
	{
		cout<<x[i]<<" "<<y[i]<<" "<<xx[i]<<" "<<yy[i]<<" "<<checkOL[i]<<endl;
	}
	foutFunction();

	return 0;
}
