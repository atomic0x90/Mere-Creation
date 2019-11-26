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

void init();

void mainScrean();
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

void mainScrean()
{
	system("clear");

	cout<<"\t\t\033[9m                                                     \033[29m"<<endl;
	
	l1(),l2(),l3(),l4(),l5();
	
	cout<<"\t\t\033[9m                                                     \033[29m"<<endl;


	return;
}

int main()
{
	char check = ' ';
//	while(1)
	{
		mainScrean();
	
//		if(check == 't')
//			break;
	}


	return 0;
}
