#include <iostream>
#include <unistd.h>	//system

#include <time.h>	//clocks

#include <sys/select.h>	//kbhit
#include <termios.h>	//kbhit

using namespace std;
/**/

static struct termios initial_settings, new_settings;

static int peek_character = -1;

void init_keyboard()
{
    tcgetattr(0,&initial_settings);
    new_settings = initial_settings;
    new_settings.c_lflag &= ~ICANON;
    new_settings.c_lflag &= ~ECHO;
    new_settings.c_cc[VMIN] = 1;
    new_settings.c_cc[VTIME] = 0;
    tcsetattr(0, TCSANOW, &new_settings);
}

void close_keyboard()
{
    tcsetattr(0, TCSANOW, &initial_settings);
}

int _kbhit()
{
    unsigned char ch;
    int nread;

    if(peek_character != -1)
            return 1;
    new_settings.c_cc[VMIN]=0;
    tcsetattr(0, TCSANOW, &new_settings);
    nread = read(0,&ch,1);
    new_settings.c_cc[VMIN]=1;
    tcsetattr(0, TCSANOW, &new_settings);
    if(nread == 1)
    {
        peek_character = ch;
        return 1;
    }

    return 0;
}

int _getch()
{
    char ch;

    if(peek_character != -1)
    {
        ch = peek_character;
        peek_character = -1;

        return ch;
    }
    read(0,&ch,1);

    return ch;
}

int _putch(int c)
{
    putchar(c);
    fflush(stdout);

    return c;
}


/**/
clock_t start_t;
double end_t;

int tetrisData[22][22];
int nextTetris[4][4];
int nowTetris[4][4];

int score;

void init();

void mainScrean();
void gameScrean();
void creatorData();

void nextScrean(int);

void nextSet();
void nowSet();

void exitScrean();

void l1();
void l2();
void l3();
void l4();
void l5();

void l1()
{
	cout<<"\t\t\033[44m        \033[49m";
	cout<<" \033[45m        \033[49m";
	cout<<" \033[41m        \033[49m";
	cout<<" \033[46m       \033[49m";
	cout<<"  \033[43m        \033[49m";
	cout<<" \033[42m        \033[49m";
	cout<<endl;
	return;
}

void l2()
{
	cout<<"\t\t   \033[44m  \033[49m";
	cout<<"    \033[45m  \033[49m";
	cout<<"          \033[41m  \033[49m";
	cout<<"    \033[46m  \033[49m    \033[46m  \033[49m";
	cout<<"    \033[43m  \033[49m";
	cout<<"    \033[42m  \033[49m";
	cout<<endl;
	return;
}

void l3()
{
	cout<<"\t\t   \033[44m  \033[49m";
	cout<<"    \033[45m        \033[49m";
	cout<<"    \033[41m  \033[49m";
	cout<<"    \033[46m        \033[49m";
	cout<<"    \033[43m  \033[49m";
	cout<<"    \033[42m        \033[49m";
	cout<<endl;
	return;
}

void l4()
{
	cout<<"\t\t   \033[44m  \033[49m";
	cout<<"    \033[45m  \033[49m";
	cout<<"          \033[41m  \033[49m";
	cout<<"    \033[46m  \033[49m   \033[46m  \033[49m";
	cout<<"     \033[43m  \033[49m";
	cout<<"          \033[42m  \033[49m";
	cout<<endl;
	return;
}

void l5()
{
	cout<<"\t\t   \033[44m  \033[49m";
	cout<<"    \033[45m        \033[49m";
	cout<<"    \033[41m  \033[49m";
	cout<<"    \033[46m  \033[49m    \033[46m  \033[49m";
	cout<<" \033[43m        \033[49m";
	cout<<" \033[42m        \033[49m";
	cout<<endl;
	return;
}

void creatorData()
{
	cout<<"\033[36m\t\tsite : https://github.com/atomic0x90"<<endl;
        cout<<"\t\temail : hanyujun.study@gmail.com";
        cout<<"\033[39m"<<endl;

	return;
}

void init()
{
	score = 0;

	for(int i = 0;i < 22;i++)
	{
		for(int j = 0;j < 22;j++)
			tetrisData[i][j] = 0;
	}

	for(int i = 0;i < 22;i++)	//wall
	{
		tetrisData[i][11] = 1;
		tetrisData[i][0] = 1;
		tetrisData[0][i] = 1;
		tetrisData[21][i] = 1;
	}

	for(int i = 0;i < 4;i++)
	{
		for(int j = 0;j < 4;j++)
		{
			nextTetris[i][j] = 0;
			nowTetris[i][j] = 0;
		}
	}

	nowSet();
	nextSet();

	return;
}

void nowSet()
{
	srand((unsigned int)time(NULL));

	int tmp;
	
	tmp = rand()%7;

	if(tmp == 0)	//I
	{}
	else if(tmp == 1)	//J
	{}
	else if(tmp == 2)	//L
	{}
	else if(tmp == 3)	//O
	{}
	else if(tmp == 4)	//S
	{}
	else if(tmp == 5)	//T
	{}
	else if(tmp == 6)	//Z
	{}

	return;
}

void nextSet()
{
	for(int i = 0;i < 4;i++)
	{
		for(int j = 0;j < 4;j++)
			nextTetris[i][j] = 0;
	}

	srand((unsigned int)time(NULL));

	int tmp;

	tmp = rand()%7;

	if(tmp == 0)	//I
	{
		for(int i = 0;i<4;i++)
			nextTetris[1][i] = 2;
	}
	else if(tmp == 1)	//J
	{
		nextTetris[1][2] = 3;
		nextTetris[2][2] = 3;
		nextTetris[3][1] = 3;
		nextTetris[3][2] = 3;
	}
	else if(tmp == 2)	//L
	{
		nextTetris[1][1] = 4;
		nextTetris[2][1] = 4;
		nextTetris[3][1] = 4;
		nextTetris[3][2] = 4;
	}
	else if(tmp == 3)	//O
	{
		nextTetris[1][1] = 5;
		nextTetris[1][2] = 5;
		nextTetris[2][1] = 5;
		nextTetris[2][2] = 5;
	}
	else if(tmp == 4)	//S
	{
		nextTetris[1][1] = 6;
		nextTetris[1][2] = 6;
		nextTetris[2][0] = 6;
		nextTetris[2][1] = 6;
	}
	else if(tmp == 5)	//T
	{
		nextTetris[1][2] = 7;
		nextTetris[2][1] = 7;
		nextTetris[2][2] = 7;
		nextTetris[3][2] = 7;
	}
	else if(tmp == 6)	//Z
	{
		nextTetris[1][0] = 8;
		nextTetris[1][1] = 8;
		nextTetris[2][1] = 8;
		nextTetris[2][2] = 8;
	}

	return;
}

void nextScrean(int x)
{
	for(int i = 0;i < 4;i++)
	{
		if(nextTetris[x][i] == 0)
			cout<<"\033[40m  \033[49m";
		else if(nextTetris[x][i] == 2)	//I
			cout<<"\033[46m  \033[49m";
		else if(nextTetris[x][i] == 3)	//J
			cout<<"\033[44m  \033[49m";
		else if(nextTetris[x][i] == 4)	//L
			cout<<"\033[43m  \033[49m";
		else if(nextTetris[x][i] == 5)	//O
			cout<<"\033[43m  \033[49m";
		else if(nextTetris[x][i] == 6)	//S
			cout<<"\033[42m  \033[49m";
		else if(nextTetris[x][i] == 7)	//T
			cout<<"\033[45m  \033[49m";
		else if(nextTetris[x][i] == 8)	//Z
			cout<<"\033[41m  \033[49m";
	}

	return;
}

void gameScrean()
{
	system("clear");

	double sp = 1000000;
	
	while(1)
	{
		char input = ' ';

		for(int i = 0;i < 22;i++)
		{
			cout<<"\t\t";
			for(int j = 0;j < 12;j++)
			{
				if(tetrisData[i][j] == 0)	//null
					cout<<"\033[40m  \033[49m";
				else if(tetrisData[i][j] == 1)	//wall
					cout<<"\033[47m  \033[49m";
			}

			if(i == 0)
				cout<<"\t\033[42m \033[49m\033[01m NEXT \033[22m\033[42m \033[49m";
			else if(i == 1)
			{
				cout<<"       \033[9m          \033[29m";
			}
			else if(i == 2)
			{
				cout<<"        ";
				nextScrean(0);
			}
			else if(i == 3)
			{
				cout<<"        ";
				nextScrean(1);
			}
			else if(i == 4)
			{
				cout<<"        ";
				nextScrean(2);
			}
			else if(i == 5)
			{
				cout<<"        ";
				nextScrean(3);
			}
			else if(i == 6)
				cout<<"       \033[9m          \033[29m";

			cout<<endl;
		}


		cout<<endl;
		creatorData();

		nextSet();

		start_t = clock();

		while(1)
		{
			init_keyboard();
			end_t = clock();
			if( ((end_t - start_t)/CLOCKS_PER_SEC) > 10000000.0/sp)
				break;
			else
			{
				if(_kbhit())
				{
					close_keyboard();
					input = _getch();
					break;
				}
			}
			close_keyboard();
		}
		close_keyboard();


		system("clear");
	}
	return;
}

void mainScrean()
{
	system("clear");

	while(1)
	{
		int start = 0;
		cout<<"\t\t\033[9m                                                     \033[29m"<<endl;
	
		l1(),l2(),l3(),l4(),l5();
	
		cout<<"\t\t\033[9m                                                     \033[29m"<<endl;
	
	
		start_t = clock();

		cout<<endl;
		cout<<"\t\t\t\033[1m   \033[42m \033[49m Press any key to start \033[42m \033[49m\033[22m";
		cout<<endl<<endl;

		creatorData();

		while(1)
		{
			init_keyboard();

			end_t = clock();

			if( ((end_t - start_t)/CLOCKS_PER_SEC) > 0.5)
				break;
			else
			{
				if(_kbhit())
				{
					close_keyboard();
					start++;
					break;
				}
			}
			close_keyboard();
		}
		close_keyboard();

		cout<<endl;

		if(start != 0)
			break;

		system("clear");
	}

	return;
}

/*
 * value means
 *
 * tetrisData : 1 -> wall
 * tetrisData : 0 -> null
 *
 * */
int main()
{
	char check = ' ';
//	while(1)
	{
		mainScrean();

		init();

		gameScrean();

//		if(check == 't')
//			break;
	}


	return 0;
}
