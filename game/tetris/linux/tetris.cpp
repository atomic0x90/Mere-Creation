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

int score;

void init();

void mainScrean();
void gameScrean();
void creatorData();

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

	for(int i = 0;i < 22;i++)
	{
		tetrisData[i][11] = 1;
		tetrisData[i][0] = 1;
		tetrisData[0][i] = 1;
		tetrisData[21][i] = 1;
	}

	for(int i = 0;i < 4;i++)
	{
		for(int j = 0;j < 4;j++)
			nextTetris[i][j] = 0;
	}
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
				cout<<"\t\033[01m NEXT \033[22m";

			cout<<endl;
		}


		cout<<endl;
		creatorData();

		start_t = clock();

		while(1)
		{
			init_keyboard();
			end_t = clock();
			if( ((end_t - start_t)/CLOCKS_PER_SEC) > 100000.0/sp)
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
