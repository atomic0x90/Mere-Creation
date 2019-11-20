#include <iostream>
#include <unistd.h>	//system

#include <time.h>


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

void mainScrean();
void gameExplanation();
void gameScrean();
void gameAlgorithm();
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
			
			if( ((end_t - start_t)/CLOCKS_PER_SEC) > 0.8)
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

int main()
{
	mainScrean();

	return 0;
}
