#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("go.inp");
ofstream fout("go.out");

clock_t start_t;
double end_t;

int size;

char finGo[21][21];

void finFunction();
void foutFunction();
void go();
void xaxis(int,int,int);
void yaxis(int,int,int);
int checkX(int,int,int,char);

void insertx(int,int);

void finFunction()
{
	fin>>size;

	char tmp;
	for(int i = 1;i <= size;i++)
	{
		for(int j = 1;j <= size;j++)
		{
			fin>>tmp;

			finGo[i][j] = tmp;
		}
	}

	return;
}

void xaxis(int x,int f,int s)
{
	if(f == s)
		return;
	else
	{
		if(finGo[x][f] == '.')
		{
			for(int i = f;i < s;i++)
			{
				if(finGo[x][s] == 'B')
					finGo[x][i] = 'b';
				else
					finGo[x][i] = 'w';
			}
		}
		else if( (finGo[x][f] == 'B' && finGo[x][s] == 'W') || (finGo[x][f] == 'W' && finGo[x][s] == 'B') )
		{
			for(int i = f+1;i < s;i++)
				finGo[x][i] = 'x';
		}
		else if(finGo[x][f] == 'B' && finGo[x][s] == 'B')
		{
			for(int i = f+1;i < s;i++)
				finGo[x][i] = 'b';
		}
		else if(finGo[x][f] == 'W' && finGo[x][s] == 'W')
		{
			for(int i = f+1;i < s;i++)
				finGo[x][i] = 'w';
		}
		else if(finGo[x][s] == '.')
		{
			for(int i = s;i > f;i--)
			{
				if(finGo[x][f] == 'B')
					finGo[x][i] = 'b';
				else
					finGo[x][i] = 'w';
			}
		}
	}

	return;
}

int checkX(int ax,int f,int s,char check)
{
	for(int i = f;i <= s;i++)
	{
		if( (finGo[i][ax] == 'x' || finGo[i][ax] != check) && finGo[i][ax] != '.')
			return 1;
	}

	return 0;
}

void yaxis(int y,int f,int s)
{
	int check = 0;

	if(f == s)
		return;
	else
	{
		if(finGo[f][y] == 'b')
		{
			if(finGo[s][y] == 'B')
				check = checkX(y,f,s-1,'b');
			else
				check = checkX(y,f,s-1,'w');
				
			if(check != 0)
			{
				for(int i = f;i < s;i++)
					finGo[i][y] = 'x';
			}
		}
		else if(finGo[f][y] == 'w')
		{
			if(finGo[s][y] == 'W')
				check = checkX(y,f,s-1,'w');
			else
				check = checkX(y,f,s-1,'b');

			if(check != 0)
			{
				for(int i = f;i < s;i++)
					finGo[i][y] = 'x';
			}
		}
		else if( (finGo[f][y] == 'B' && finGo[s][y] == 'W') || (finGo[f][y] == 'W' && finGo[s][y] == 'B') )
		{
			for(int i = f+1;i < s;i++)
				finGo[i][y] = 'x';
		}
		else if(finGo[f][y] == 'B' && finGo[s][y] == 'B')
		{
			check = checkX(y,f+1,s-1,'b');

			if(check != 0)
			{
				for(int i = f+1;i < s;i++)
					finGo[i][y] = 'x';
			}
			else
			{
				for(int i = f+1;i < s;i++)
					finGo[i][y] = 'b';
			}
		}
		else if(finGo[f][y] == 'W' && finGo[s][y] == 'W')
		{
			check = checkX(y,f+1,s-1,'w');

			if(check != 0)
			{
				for(int i = f+1;i < s;i++)
					finGo[i][y] = 'x';
			}
			else
			{
				for(int i = f+1;i < s;i++)
					finGo[i][y] = 'w';
			}
		}
		else if(finGo[s][y] == 'b')
		{
			if(finGo[f][y] == 'B')
				check = checkX(y,f+1,s,'b');
			else
				check = checkX(y,f+1,s,'w');

			if(check != 0)
			{
				for(int i = f+1;i <= s;i++)
					finGo[i][y] = 'x';
			}
		}
		else if(finGo[s][y] == 'w')
		{
			if(finGo[f][y] == 'W')
				check = checkX(y,f+1,s,'w');
			else
				check = checkX(y,f+1,s,'b');

			if(check != 0)
			{
				for(int i = f+1;i <= s;i++)
					finGo[i][y] = 'x';
			}
		}
		else if(finGo[f][y] == '.')
		{
			for(int i = f;i < s;i++)
			{
				if(finGo[s][y] == 'B')
					finGo[i][y] = 'b';
				else
					finGo[i][y] = 'w';
			}
		}
		else if(finGo[s][y] == '.')
		{
			for(int i = s;i > f;i--)
			{
				if(finGo[f][y] == 'B')
					finGo[i][y] = 'b';
				else
					finGo[i][y] = 'w';
			}
		}
	}

	return;
}

void go()
{
	int t1,t2;

	// x axis
	for(int i = 1;i <= size;i++)
	{
		t1 = t2 = 1;
		for(int j = 1;j <= size;j++)
		{
			if(finGo[i][j] == 'B' || finGo[i][j] == 'W')
			{
				t2 = j;
				
				xaxis(i,t1,t2);
			
				t1 = t2;
			}
		}

		t1 = t2 = size;
		for(int j = size;j > 0;j--)
		{
			if(finGo[i][j] == 'B' || finGo[i][j] == 'W')
			{
				t1 = j;

				xaxis(i,t1,t2);

				t2 = t1;
			}
		}
	}

	// y axis
	for(int i = 1;i <= size;i++)
	{
		t1 = t2 = 1;
		for(int j = 1;j <= size;j++)
		{
			if(finGo[j][i] == 'B' || finGo[j][i] == 'W')
			{
				t2 = j;

				yaxis(i,t1,t2);

				t1 = t2;
			}
		}

		t1 = t2 = size;
		for(int j = size;j > 0;j--)
		{
			if(finGo[j][i] == 'B' || finGo[j][i] == 'W')
			{
				t1 = j;

				yaxis(i,t1,t2);

				t2 = t1;
			}
		}
	}


	//1 ~ size '.'
	for(int i =1;i <= size;i++)
	{
		for(int j = 1;j <= size;j++)
		{
			if(finGo[i][j] == '.')
				finGo[i][j] = 'x';
		}
	}

	for(int k = 0;k < size*size;k++)
	{
		for(int i = 1;i <= size;i++)
		{
			for(int j = 1;j <= size;j++)
			{
				if(finGo[i][j] == 'x')
					insertx(i,j);
			}
		}
	}

	return;
}

void insertx(int y,int x)
{
	int t1,t2;

	//x
	t1 = t2 = x;
	for(int i = x;;i--)
	{
		if(finGo[y][i] == 'B' || finGo[y][i] == 'W')
		{
			t1 = i+1;
			break;
		}
		else if(i == 1)
		{
			t1 = 1;
			break;
		}
	}
	for(int i = x;;i++)
	{
		if(finGo[y][i] == 'B' || finGo[y][i] == 'W')
		{
			t2 = i-1;
			break;
		}
		else if(i == size)
		{
			t2 = size;
			break;
		}
	}
	
	for(int i = t1;i <= t2;i++)
		finGo[y][i] = 'x';

	//y
	t1 = t2 = y;
	for(int i = y;;i--)
	{
		if(finGo[i][x] == 'B' || finGo[i][x] == 'W')
		{
			t1 = i+1;
			break;
		}
		else if(i == 1)
		{
			t1 = 1;
			break;
		}
	}
	for(int i = y;;i++)
	{
		if(finGo[i][x] == 'B' || finGo[i][x] == 'W')
		{
			t2 = i-1;
			break;
		}
		else if(i == size)
		{
			t2 = size;
			break;
		}
	}

	for(int i = t1;i <= t2;i++)
		finGo[i][x] = 'x';

	return;
}

void foutFunction()
{
	int checkb,checkw;
	checkb = checkw = 0;

	for(int i = 1;i <= size;i++)
	{
		for(int j = 1;j <= size;j++)
		{
			if(finGo[i][j] == 'b')
				checkb++;
			else if(finGo[i][j] == 'w')
				checkw++;
		}
	}

	fout<<checkb<<" "<<checkw<<endl;
	cout<<checkb<<" "<<checkw<<endl;

	return;
}

int main()
{
	start_t = clock();

	finFunction();


	go();

	for(int i = 1;i <= size;i++)
        {
                for(int j = 1;j <= size;j++)
                {
                        cout<<finGo[i][j];
                }
                cout<<endl;
        }

	foutFunction();

	fin.close();
	fout.close();

	end_t = clock();
	cout<<endl<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
