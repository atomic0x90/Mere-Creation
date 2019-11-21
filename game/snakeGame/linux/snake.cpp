#include <iostream>
#include <unistd.h>	//system

#include <time.h>

#include <utility>

#include <sys/select.h>		//kbhit
#include <termios.h>		//kbhit
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
int screan[100] = {0,};

int snakeData[30][30] = {0,};
int arrdata[30][30] = {0,};

int score = 0;

pair <int,int> head;

char direction;

void init();

void mainScrean();
void gameScrean();
int setData();
int gameAlgorithm();
int collision();
void searchTail(int);
void creatorData();

void l1();
void l2();
void l3();
void l4();
void l5();

void ll1();
void ll2();
void ll3();
void ll4();
void ll5();

void l1()
{
	cout<<"\t\t"<<"\033[42m       \033[49m";
	cout<<"\t\033[43m   \033[49m   \033[43m  \033[49m";
	cout<<"     \033[46m   \033[49m";
	cout<<"     \033[44m  \033[49m   \033[44m   \033[49m";
	cout<<" \033[45m       \033[49m";

	cout<<endl;
	return;
}

void l2()
{
	cout<<"\t\t"<<"\033[42m  \033[49m";
	cout<<"\t\033[43m    \033[49m  \033[43m  \033[49m";
	cout<<"    \033[46m     \033[49m";
	cout<<"    \033[44m  \033[49m \033[44m   \033[49m";
	cout<<"   \033[45m  \033[49m";

	cout<<endl;
	return;
}

void l3()
{
	cout<<"\t\t"<<"\033[42m       \033[49m";
	cout<<"\t\033[43m  \033[49m \033[43m  \033[49m \033[43m  \033[49m";
	cout<<"   \033[46m  \033[49m   \033[46m  \033[49m";
	cout<<"   \033[44m     \033[49m";
	cout<<"    \033[45m       \033[49m";

	cout<<endl;
	return;
}

void l4()
{
	cout<<"\t\t"<<"     \033[42m  \033[49m";
	cout<<"\t\033[43m  \033[49m  \033[43m    \033[49m";
	cout<<"  \033[46m         \033[49m";
	cout<<"  \033[44m  \033[49m \033[44m   \033[49m";
	cout<<"   \033[45m  \033[49m";

	cout<<endl;
	return;
}

void l5()
{
	cout<<"\t\t"<<"\033[42m       \033[49m";
	cout<<"\t\033[43m  \033[49m   \033[43m   \033[49m";
	cout<<" \033[46m   \033[49m     \033[46m   \033[49m";
	cout<<" \033[44m  \033[49m   \033[44m   \033[49m";
	cout<<" \033[45m       \033[49m";

	cout<<endl;
	return;
}

void ll1()
{
	cout<<endl;
	
	cout<<"\t\t\033[47m         \033[49m";
	cout<<"     \033[47m   \033[49m";
	cout<<"     \033[47m   \033[49m        \033[47m   \033[49m";
	cout<<" \033[47m        \033[49m";

	cout<<endl;
	return;
}

void ll2()
{
	cout<<"\t\t\033[47m   \033[49m   \033[47m   \033[49m";
	cout<<"    \033[47m     \033[49m";
	cout<<"    \033[47m     \033[49m    \033[47m     \033[49m";
	cout<<" \033[47m   \033[49m";

	cout<<endl;
	return;
}

void ll3()
{
	cout<<"\t\t\033[47m         \033[49m";
	cout<<"   \033[47m  \033[49m   \033[47m  \033[49m";
	cout<<"   \033[47m   \033[49m \033[47m  \033[49m  \033[47m  \033[49m \033[47m   \033[49m";
	cout<<" \033[47m        \033[49m";

	cout<<endl;
	return;
}

void ll4()
{
	cout<<"\t\t      \033[47m   \033[49m";
	cout<<"  \033[47m         \033[49m";
	cout<<"  \033[47m   \033[49m  \033[47m    \033[49m  \033[47m   \033[49m";
	cout<<" \033[47m   \033[49m";

	cout<<endl;
	return;
}

void ll5()
{
	cout<<"\t\t\033[47m         \033[49m";
	cout<<" \033[47m   \033[49m     \033[47m   \033[49m";
	cout<<" \033[47m   \033[49m   \033[47m  \033[49m   \033[47m   \033[49m";
	cout<<" \033[47m        \033[49m";

	cout<<endl;
	return;
}

void sn(int data)
{
	int tmp = data%35;
	for(int i = 0;i < tmp;i++)
	{
		if(i%35 < 25)
		{
			if(screan[i%35] < 10)
			{
				cout<<"\033[42m  \033[49m ";
				screan[i%35]++;
			}
			else
				cout<<"   ";
		}
		else
		{
			if(screan[i%35] == 10)
				cout<<"   ";
			else if(screan[i%35] > 0)
				cout<<"\033[42m  \033[49m";
		}

		if(i == 33)
		{
			for(int j = 0;j < 35;j++)
				screan[j] = 0;
		}
	}


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

void mainScrean()
{
	system("clear");
	int i = 1;
	while(1)
	{
		char startc = ' ';

		cout<<"\t\t\033[9m                                             \033[29m"<<endl;

		l1(),l2(),l3(),l4(),l5();

		ll1(),ll2(),ll3(),ll4(),ll5();

		cout<<"\t\t\033[9m                                             \033[29m"<<endl;
	

		sn(i++);
		
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
					startc = _getch();
					break;
				}
			}
			close_keyboard();
		}

		close_keyboard();
		
		cout<<endl;
		
		if(startc != ' ')
			break;
		
		usleep(10000);

		system("clear");
	}
	return;
}

void init()
{
	arrdata[1][1] = 3;
	arrdata[1][2] = 2;
	arrdata[1][3] = 1;

	head.first = 1;
	head.second = 3;

	direction = 'd';

	score = 0;

	for(int i = 0;i < 30;i++)
	{
		snakeData[0][i] = 3;
		snakeData[26][i] = 3;
		snakeData[i][0] = 3;
		snakeData[i][26] = 3;
	}
	snakeData[1][1] = snakeData[1][2] = snakeData[1][3] = 1;
	return;
}

void searchTail(int st)
{
	int max = 0;
	int p1,p2;
	p1 = p2 = 1;
	if(st == 0)
	{
		for(int i = 1;i < 26;i++)
		{
			for(int j = 1;j < 26;j++)
			{
				if(arrdata[i][j] > max)
				{
					max = arrdata[i][j];
					p1 = i;
					p2 = j;
				}
			}
		}
		arrdata[p1][p2] = 0;
		snakeData[p1][p2] = 0;
		return;
	}
	else if(st == 1)	//food
	{
		return;
	}

}

int setData()
{
	if(snakeData[head.first][head.second] == 2)	//food
	{
	
		return 0;
	}
	else if(snakeData[head.first][head.second] == 0)	//null
	{
		for(int i = 1;i < 26;i++)
		{
			for(int j = 1;j < 26;j++)
			{
				if(arrdata[i][j] > 0)
					arrdata[i][j]++;
			}
		}
		arrdata[head.first][head.second] = 1;

		snakeData[head.first][head.second] = 1;
		searchTail(0);

		return 0;
	}
	else	//collision
	{
		snakeData[head.first][head.second] = 4;
		searchTail(0);
	
		return 1;
	}
}
int gameAlgorithm(char input)
{

	if(direction == 'w')
	{
		if(input == 'a')
		{
			direction = 'a';
			head.second--;

			return setData();
		}
		else if(input == 'd')
		{
			direction = 'd';
			head.second++;

			return setData();
		}
		else
		{
			head.first--;

			return setData();
		}
	}
	else if(direction == 's')
	{
		if(input == 'a')
		{
			direction = 'a';
			head.second--;

			return setData();
		}
		else if(input == 'd')
		{
			direction = 'd';
			head.second++;

			return setData();
		}
		else
		{
			head.first++;

			return setData();
		}
	}
	else if(direction == 'd')
	{
		if(input == 'w')
		{
			direction = 'w';
			head.first--;
			
			return setData();
		}
		else if(input == 's')
		{
			direction = 's';
			head.first++;
		
			return setData();
		}
		else
		{
			head.second++;
			
			return setData();
		}
	}
	else if(direction == 'a')
	{
		if(input == 'w')
		{
			direction = 'w';
			head.first--;

			return setData();
		}
		else if(input == 's')
		{
			direction = 's';
			head.first++;

			return setData();
		}
		else
		{
			head.second--;
		
			return setData();
		}
	}

	return 0;
}

void gameScrean()
{
	system("clear");

	double sp = 400000;
	int checkCollision = 0;
	while(1)
	{
		for(int i = 0;i < 27;i++)
		{
			for(int j = 0;j < 27;j++)
			{
				if(snakeData[i][j] == 0)	//null
					cout<<"\033[40m  \033[49m";
				else if(snakeData[i][j] == 1)	//tail
					cout<<"\033[42m  \033[49m";
				else if(snakeData[i][j] == 2)	//food
					cout<<"\033[41m  \033[49m";
				else if(snakeData[i][j] == 3)	//wall
					cout<<"\033[44m  \033[49m";
				else if(snakeData[i][j] == 4)	//collision
					cout<<"\033[43m  \033[49m";
			}
		
			if(i == 0)
				cout<<"\t   \033[43m \033[49m \033[01m Help \033[22m \033[43m \033[49m";
			else if(i == 2)
				cout<<"\t     up : w";
			else if(i == 3)
				cout<<"\t   down : s";
			else if(i == 4)
				cout<<"\t  right : d";
			else if(i == 5)
				cout<<"\t   left : a";
			else if(i == 7)
				cout<<"\t   exit : x";
			else if(i == 10)
				cout<<"\t   \033[43m \033[49m \033[01m Score \033[22m \033[43m \033[49m";
			else if(i == 12)
				cout<<"\t        \033[33m\033[01m"<<score<<"\033[22m\033[39m";
			else if(i == 15)
				cout<<"\t   \033[43m \033[49m \033[01m Speed \033[22m \033[43m \033[49m";
			else if(i == 17)
				cout<<"\t    \033[33m\033[01mspeed * "<<400000.0/sp<<"\033[22m\033[39m";
			
			
			cout<<endl;
		}

		cout<<endl;
		creatorData();

		if(checkCollision != 0)
			break;
		/**/
		char input = ' ';

		start_t = clock();

		while(1)
		{
			init_keyboard();
			end_t = clock();
			if( ((end_t - start_t)/CLOCKS_PER_SEC) > sp/4000000.0)
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
		/**/

		cout<<head.first<<" "<<head.second<<endl;
		checkCollision = gameAlgorithm(input);
		cout<<head.first<<" "<<head.second<<endl;

//		usleep(sp);
		
		system("clear");
	}


	return;
}

/*
 * snakeData == 3 : wall
 * snakeData == 2 : food
 * snakeData == 1 : tail
 * snakeData == 0 : null
*/
int main()
{
	mainScrean();

	init();

	gameScrean();

	return 0;
}
