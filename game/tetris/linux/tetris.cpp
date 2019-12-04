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

int setBlock[7];
int checkBlock = 6;

int save1[4];
int save2[4];


int tetrisData[22][22];
int nextTetris[4][4];
int nowTetris[4][4];

int nowData;

int init();

void mainScrean();
void gameScrean(int);
void creatorData();

int downBlock();

void nextScrean(int);

int gameAlgorithm(int);

int collision(int);


int rotationAlgorithm(int);
int rotationState;

double score;
double maxscore = 0;
void scoreAlgorithm();
int combo;

int nextSet();
int nowSet(int);

void exitScrean();

void l1();
void l2();
void l3();
void l4();
void l5();


void scoreAlgorithm()
{
	int clearLine = 0;
	double tmpsc = 0;

	double comsc = 1;
	int linesc = 100;

	for(int l = 0;l < 20;l++)
	{
		for(int i = 20;i > 0;i--)
		{
			int check = 0;
			for(int j = 1;j < 11;j++)
			{
				if(tetrisData[i][j] == 0)
				{
					check++;
					break;
				}
			}
	
			if(check == 0)
			{
				cout<<"check "<<i<<" ";
				
				clearLine++;
				
				for(int j = 1;j < 11;j++)
					tetrisData[i][j] = 0;
	
				for(int j = i-1;j > 0;j--)
				{
					if(j != 0)
					{
						for(int k = 1;k < 11;k++)
							tetrisData[j+1][k] = tetrisData[j][k];
					}
					else
					{
						for(int k = 1;k < 11;k++)
							tetrisData[1][k] = 0;
					}
				}
			}
		}
	}
	cout<<"score "<<clearLine<<endl;


	if(clearLine != 0)
	{
		if(combo == 0)
			comsc = 1;
		else if(combo == 1)
			comsc = 1.2;
		else if(combo == 2)
			comsc = 1.3;
		else if(combo == 3)
			comsc = 1.4;
		else
			comsc = 1.5;

		combo++;

		if(clearLine == 1)
			tmpsc += linesc * comsc;
		else if(clearLine == 2)
			tmpsc += linesc * comsc * 2;
		else if(clearLine == 3)
			tmpsc += linesc * comsc * 3;
		else if(clearLine == 4)
			tmpsc += linesc * comsc * 4;
	}
	else
		combo = 0;


	score += tmpsc;

	if(maxscore < score)
		maxscore = score;

	return ;
}

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

int init()
{
	score = combo = 0;

	rotationState = 1;

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

	srand((unsigned int)time(NULL));
	int tmp = rand()%7;

	nowData = tmp;

	nowSet(tmp);

	return nextSet();
}

int nowSet(int type)
{
	int tmp = type;

	if(tmp == 0)	//I
	{
		tetrisData[1][4] = 10;
		tetrisData[1][5] = 10;
		tetrisData[1][6] = 10;
		tetrisData[1][7] = 10;
	}
	else if(tmp == 1)	//J
	{
		tetrisData[1][6] = 11;
		tetrisData[2][6] = 11;
		tetrisData[3][5] = 11;
		tetrisData[3][6] = 11;

		/*
		tetrisData[1][4] = 11;
		tetrisData[2][4] = 11;
		tetrisData[2][5] = 11;
		tetrisData[2][6] = 11;
		*/
	}
	else if(tmp == 2)	//L
	{
		tetrisData[1][5] = 12;
		tetrisData[2][5] = 12;
		tetrisData[3][5] = 12;
		tetrisData[3][6] = 12;
		/*
		tetrisData[1][6] = 12;
		tetrisData[2][6] = 12;
		tetrisData[2][5] = 12;
		tetrisData[2][4] = 12;
		*/
	}
	else if(tmp == 3)	//O
	{
		tetrisData[1][5] = 13;
		tetrisData[1][6] = 13;
		tetrisData[2][5] = 13;
		tetrisData[2][6] = 13;
	}
	else if(tmp == 4)	//S
	{
		tetrisData[1][6] = 14;
		tetrisData[1][5] = 14;
		tetrisData[2][5] = 14;
		tetrisData[2][4] = 14;
	}
	else if(tmp == 5)	//T
	{
		tetrisData[1][4] = 15;
		tetrisData[1][5] = 15;
		tetrisData[1][6] = 15;
		tetrisData[2][5] = 15;
	}
	else if(tmp == 6)	//Z
	{
		tetrisData[1][4] = 16;
		tetrisData[1][5] = 16;
		tetrisData[2][5] = 16;
		tetrisData[2][6] = 16;
	}
	

	return tmp;
}

int nextSet()
{
	int tmpBlock;

	for(int i = 0;i < 4;i++)
	{
		for(int j = 0;j < 4;j++)
			nextTetris[i][j] = 0;
	}

	if(checkBlock == 6)
	{
		tmpBlock = setBlock[6];

		checkBlock = 0;

		srand((unsigned int)time(NULL));
		
		int randomBox = rand()%7;

		if(randomBox == 0)
		{
			setBlock[0] = 0;
			setBlock[1] = 1;
			setBlock[2] = 2;
			setBlock[3] = 3;
			setBlock[4] = 4;
			setBlock[5] = 5;
			setBlock[6] = 6;
		}
		else if(randomBox == 1)
		{
			setBlock[0] = 6;
			setBlock[1] = 5;
			setBlock[2] = 4;
			setBlock[3] = 3;
			setBlock[4] = 2;
			setBlock[5] = 1;
			setBlock[6] = 0;
		}
		else if(randomBox == 2)
		{
			setBlock[0] = 6;
			setBlock[1] = 1;
			setBlock[2] = 4;
			setBlock[3] = 3;
			setBlock[4] = 2;
			setBlock[5] = 5;
			setBlock[6] = 0;
		}
		else if(randomBox == 3)
		{
			setBlock[0] = 1;
			setBlock[1] = 0;
			setBlock[2] = 3;
			setBlock[3] = 2;
			setBlock[4] = 5;
			setBlock[5] = 4;
			setBlock[6] = 6;
		}
		else if(randomBox == 4)
		{
			setBlock[0] = 2;
			setBlock[1] = 0;
			setBlock[2] = 1;
			setBlock[3] = 6;
			setBlock[4] = 3;
			setBlock[5] = 4;
			setBlock[6] = 5;
		}
		else if(randomBox == 5)
		{
			setBlock[0] = 1;
			setBlock[1] = 2;
			setBlock[2] = 3;
			setBlock[3] = 0;
			setBlock[4] = 5;
			setBlock[5] = 6;
			setBlock[6] = 4;
		}
		else if(randomBox == 6)
		{
			setBlock[0] = 2;
			setBlock[1] = 5;
			setBlock[2] = 0;
			setBlock[3] = 1;
			setBlock[4] = 6;
			setBlock[5] = 3;
			setBlock[6] = 4;
		}
	}
	else
	{
		tmpBlock = setBlock[checkBlock];
		checkBlock++;
	}

	if(tmpBlock == 0)	//I
	{
		for(int i = 0;i<4;i++)
			nextTetris[1][i] = 2;
	}
	else if(tmpBlock == 1)	//J
	{
		nextTetris[1][2] = 3;
		nextTetris[2][2] = 3;
		nextTetris[3][1] = 3;
		nextTetris[3][2] = 3;
	}
	else if(tmpBlock == 2)	//L
	{
		nextTetris[1][1] = 4;
		nextTetris[2][1] = 4;
		nextTetris[3][1] = 4;
		nextTetris[3][2] = 4;
	}
	else if(tmpBlock == 3)	//O
	{
		nextTetris[1][1] = 5;
		nextTetris[1][2] = 5;
		nextTetris[2][1] = 5;
		nextTetris[2][2] = 5;
	}
	else if(tmpBlock == 4)	//S
	{
		nextTetris[1][1] = 6;
		nextTetris[1][2] = 6;
		nextTetris[2][0] = 6;
		nextTetris[2][1] = 6;
	}
	else if(tmpBlock == 5)	//T
	{
		nextTetris[2][1] = 7;
		nextTetris[2][2] = 7;
		nextTetris[2][3] = 7;
		nextTetris[3][2] = 7;
	}
	else if(tmpBlock == 6)	//Z
	{
		nextTetris[1][0] = 8;
		nextTetris[1][1] = 8;
		nextTetris[2][1] = 8;
		nextTetris[2][2] = 8;
	}

	return tmpBlock;
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

void gameScrean(int initnext)
{
	int tmpnext = initnext;
	system("clear");


	double sp = 1000000;

	int fblock = 0;

	int repetition = 0;

	int checkLastPress = 0;

	while(1)
	{
		start_t = clock();
		int checkcoll = 0;
		int checkDown = 0;
		int input = 0;

		for(int i = 0;i < 22;i++)
		{
			cout<<"\t\t";
			for(int j = 0;j < 12;j++)
			{
				if(tetrisData[i][j] == 0)	//null
					cout<<"\033[40m  \033[49m";
				
				else if(tetrisData[i][j] == 1)	//wall
					cout<<"\033[47m  \033[49m";
				
				else if(tetrisData[i][j] == 10 || tetrisData[i][j] == 100)	//I
					cout<<"\033[46m  \033[49m";
				
				else if(tetrisData[i][j] == 11 || tetrisData[i][j] == 110)	//J
					cout<<"\033[44m  \033[49m";
				
				else if(tetrisData[i][j] == 12 || tetrisData[i][j] == 120)	//L
					cout<<"\033[43m  \033[49m";

				else if(tetrisData[i][j] == 13 || tetrisData[i][j] == 130)	//O
					cout<<"\033[43m  \033[49m";

				else if(tetrisData[i][j] == 14 || tetrisData[i][j] == 140)	//S
					cout<<"\033[42m  \033[49m";

				else if(tetrisData[i][j] == 15 || tetrisData[i][j] == 150)	//T
					cout<<"\033[45m  \033[49m";

				else if(tetrisData[i][j] == 16 || tetrisData[i][j] == 160)	//Z
					cout<<"\033[41m  \033[49m";
				else
					cout<<tetrisData[i][j];
			}

			if(i == 0)
				cout<<"\t\033[42m \033[49m\033[01m NEXT \033[22m\033[42m \033[49m";
			else if(i == 1)
				cout<<"       \033[9m          \033[29m";
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
		//	else if(i == 6)
		//		cout<<"       \033[9m          \033[29m";
			else if(i == 7)
				cout<<"       \033[01m S C O R E \033[22m";
			else if(i == 8)
				cout<<"       \033[9m          \033[29m";
			else if(i == 9)
				cout<<"          \033[01m\033[33m"<<score<<"\033[39m\033[22m";
			else if(i == 11)
				cout<<"        \033[01m B E S T \033[22m";
			else if(i == 12)
                                cout<<"       \033[9m          \033[29m";
			else if(i == 13)
                                cout<<"          \033[01m\033[33m"<<maxscore<<"\033[39m\033[22m";
			cout<<endl;
		}


		cout<<endl;
		creatorData();



		int checkPress = 0;

		while(1)
		{
			init_keyboard();
			end_t = clock();
			if( ((end_t - start_t)/CLOCKS_PER_SEC) > 1000000.0/sp)
			{
				close_keyboard();

				break;
			}
			else
			{
				if(_kbhit())
				{
					close_keyboard();
					input = _getch();
						
					checkPress++;
					
					if(input == 66 || input == 67 || input == 68)	//??? direction key
//					if(input == 224)	//direction key ASCII ???
					{
						//72 : up, 75 : left, 77 : right, 80 : down    ???? not operation
						//68 : left, 67: right, 66 : down
						//122 : z, 120 : x
						cout<<"input "<<input<<endl;
						if(checkLastPress == 66)
							repetition = 1;
					}
					cout<<"checkLast "<<checkLastPress<<" repe "<<repetition<<" in "<<input<<endl;
					
				

					break;
				}
			}
			close_keyboard();
		}
		close_keyboard();

		if(input == 68 || input == 67 || input == 66)
			checkLastPress = input;

		if(checkPress == 0)	//Input value not exist
		{
			checkDown = downBlock();

			if(checkDown == 1)	//Fix block on bottom
			{
		//		scoreAlgorithm();

				checkcoll = collision(tmpnext);

				rotationState = 1;

				if(checkcoll == 1)	//collision
				{
					break;
				}
				else	//Not collision
				{
					nowData = nowSet(tmpnext);

					tmpnext = nextSet();
				}
			}
		}
		else	//Input value exist
		{
			if(repetition == 0)
			{
				if(input == 68 || input == 67 || input == 66)
					gameAlgorithm(input);
				else if(input == 122 || input == 120)
					rotationState = rotationAlgorithm(input);
			}
			else if(repetition == 1)
			{
				if(input == 68 || input == 67)
					gameAlgorithm(input);
				else if(input == 66)	//Press more than twice in a row down key
				{
					checkDown = downBlock();

					if(checkDown == 1)	//Fix block on bottom
					{
			//			scoreAlgorithm();

						checkcoll = collision(tmpnext);

						rotationState = 1;

						if(checkcoll == 1)	//collision
						{
							break;
						}
						else	//Not collision
						{
							nowData = nowSet(tmpnext);
	
							tmpnext = nextSet();
	
							checkLastPress = 0;
						}

						repetition = 0;
					}
					else	//Not yet fix block on bottom
					{
						gameAlgorithm(input);
					}
				}
				else if(input == 122 || input == 120)
				{
					rotationState = rotationAlgorithm(input);
				}
			}
		}


//		system("clear");
	}
	return;
}


/*
 * That function(rotationAlgorithm) development goals
 *
 * If there is no space when rotating, move sideways to make it rotate
 * */
int rotationAlgorithm(int input)
{
	cout<<"In roatationAlgorithm"<<endl;
	
	int tmp = 0;

	for(int i = 1;i < 21;i++)
	{
		for(int j = 1;j < 11;j++)
		{
			if(tetrisData[i][j] >= 10 && tetrisData[i][j] <= 16)
			{
				save1[tmp] = i;
				save2[tmp] = j;
				tmp++;
			}
			if(tmp == 4)
				break;
		}
		if(tmp == 4)
			break;
	}

	tmp = tetrisData[save1[0]][save2[0]];

	/*
	 * Input value
	 * z : 122 : Counterclockwise
	 * x : 120 : A clockwise direction
	 *
	 * Block number
	 *
	 * 1 | 2 | 3 | 4
	 * 5 | 6 | 7 | 8
	 * 9 | 10| 11| 12
	 * 13| 14| 15| 16
	 *
	 * */

	/*
	 * I -> rotationState == 1 : 5.6.7.8
	 * I -> rotationState == 2 : 2.6.10.14
	 * */		
	if(nowData == 0)	//I
	{
		if(rotationState == 1)
		{
			int tmp1,tmp2;
			if(input == 122)
			{	//Priority : 3 1 2 4
				tmp1 = save1[0];
				tmp2 = save2[0];
				save1[0] = save1[1];
				save2[0] = save2[1];
				save1[1] = save1[2];
				save2[1] = save2[2];
				save1[2] = tmp1;
				save2[2] = tmp2;
			}
			else if(input == 120)
			{	//Priority : 4 2 1 3
				tmp1 = save1[2];
				tmp2 = save2[2];
				save1[2] = save1[0];
				save2[2] = save2[0];
				save1[0] = tmp1;
				save2[0] = tmp2;
				tmp1 = save1[2];
				tmp2 = save2[2];
				save1[2] = save1[3];
				save2[2] = save2[3];
				save1[3] = tmp1;
				save2[3] = tmp2;
			}
			for(int i = 0;i < 4;i++)
			{

				if(tetrisData[save1[i]+1][save2[i]] == 0 && tetrisData[save1[i]+2][save2[i]] == 0 && tetrisData[save1[i]+3][save2[i]] == 0)
				{	//When there's space below
					for(int j = 0;j < 4;j++)
						tetrisData[save1[j]][save2[j]] = 0;
					
					tetrisData[save1[i]][save2[i]] = tmp;
					tetrisData[save1[i]+1][save2[i]] = tmp;
					tetrisData[save1[i]+2][save2[i]] = tmp;
					tetrisData[save1[i]+3][save2[i]] = tmp;

					return 2;	//Rotation complete
				}
				else if(tetrisData[save1[i]-1][save2[i]] == 0 && tetrisData[save1[i]+1][save2[i]] == 0 && tetrisData[save1[i]+2][save2[i]] == 0)
				{	//When two space below is empty
					for(int j = 0;j < 4;j++)
						tetrisData[save1[j]][save2[j]] = 0;

					tetrisData[save1[i]][save2[i]] = tmp;
					tetrisData[save1[i]-1][save2[i]] = tmp;
	                                tetrisData[save1[i]+1][save2[i]] = tmp;
	                                tetrisData[save1[i]+2][save2[i]] = tmp;

					return 2;	//Rotation complete
				}
				else if(tetrisData[save1[i]-2][save2[i]] == 0 && tetrisData[save1[i]-1][save2[i]] == 0 && tetrisData[save1[i]+1][save2[i]] == 0)
				{	//When one space below is empty
					for(int j = 0;j < 4;j++)
						tetrisData[save1[j]][save2[j]] = 0;
				
					tetrisData[save1[i]][save2[i]] = tmp;
					tetrisData[save1[i]-2][save2[i]] = tmp;
     	                                tetrisData[save1[i]-1][save2[i]] = tmp;
       		                        tetrisData[save1[i]+1][save2[i]] = tmp;

					return 2;	//Rotation complete
				}
				else if(tetrisData[save1[i]-3][save2[i]] == 0 && tetrisData[save1[i]-2][save2[i]] == 0 && tetrisData[save1[i]-1][save2[i]] == 0)
 				{       //When there's space on top
					for(int j = 0;j < 4;j++)
						tetrisData[save1[j]][save2[j]] = 0;
	
					tetrisData[save1[i]][save2[i]] = tmp;
                                        tetrisData[save1[i]-3][save2[i]] = tmp;
                                        tetrisData[save1[i]-2][save2[i]] = tmp;
                                        tetrisData[save1[i]-1][save2[i]] = tmp;

                                        return 2;       //Rotation complete
                                }
			}

			return 1;	//Rotation fail
		}
		else if(rotationState == 2)
		{
			if(input == 122)	//Counterclockwise
			{
				for(int i = 3;i >= 0;i--)
				{
					if(tetrisData[save1[i]][save2[i]+1] == 0 && tetrisData[save1[i]][save2[i]+2] == 0 && tetrisData[save1[i]][save2[i]+3] == 0)
					{	//When left space == 0, right space == 3
						for(int j = 0;j < 4;j++)
							tetrisData[save1[j]][save2[j]] = 0;
						
						tetrisData[save1[i]][save2[i]] = tmp;
						tetrisData[save1[i]][save2[i]+1] = tmp;
						tetrisData[save1[i]][save2[i]+2] = tmp;
						tetrisData[save1[i]][save2[i]+3] = tmp;
					
						return 1;	//Rotation complete
					}
					else if(tetrisData[save1[i]][save2[i]-1] == 0 && tetrisData[save1[i]][save2[i]+1] == 0 && tetrisData[save1[i]][save2[i]+2] == 0)
					{	//When left space == 1, right space == 2
						for(int j = 0;j < 4;j++)
							tetrisData[save1[j]][save2[j]] = 0;

						tetrisData[save1[i]][save2[i]] = tmp;
						tetrisData[save1[i]][save2[i]-1] = tmp;
						tetrisData[save1[i]][save2[i]+1] = tmp;
						tetrisData[save1[i]][save2[i]+2] = tmp;
					
						return 1;	//Rotation complete
					}
					else if(tetrisData[save1[i]][save2[i]-2] == 0 && tetrisData[save1[i]][save2[i]-1] == 0 && tetrisData[save1[i]][save2[i]+1] == 0)
					{	//When left space == 2, right space == 1
						for(int j = 0;j < 4;j++)
							tetrisData[save1[j]][save2[j]] = 0;

						tetrisData[save1[i]][save2[i]] = tmp;
						tetrisData[save1[i]][save2[i]-2] = tmp;
						tetrisData[save1[i]][save2[i]-1] = tmp;
						tetrisData[save1[i]][save2[i]+1] = tmp;
					
						return 1;	//Rotation complete
					}
					else if(tetrisData[save1[i]][save2[i]-3] == 0 && tetrisData[save1[i]][save2[i]-2] == 0 && tetrisData[save1[i]][save2[i]-1] == 0)
					{	//When left space == 3, right space == 0
						for(int j = 0;j < 4;j++)
							tetrisData[save1[j]][save2[j]] = 0;

						tetrisData[save1[i]][save2[i]] = tmp;
						tetrisData[save1[i]][save2[i]-3] = tmp;
						tetrisData[save1[i]][save2[i]-2] = tmp;
						tetrisData[save1[i]][save2[i]-1] = tmp;
					
						return 1;	//Rotation complete
					}
				}

				return 2;	//Rotation fail
			}
			else if(input == 120)	//Clockwise
			{
				for(int i = 3;i >= 0;i--)
				{
					if(tetrisData[save1[i]][save2[i]-3] == 0 && tetrisData[save1[i]][save2[i]-2] == 0 && tetrisData[save1[i]][save2[i]-1] == 0)
                                        {       //When left space == 3, right space == 0
                                                for(int j = 0;j < 4;j++)
                                                        tetrisData[save1[j]][save2[j]] = 0;

                                                tetrisData[save1[i]][save2[i]] = tmp;
                                                tetrisData[save1[i]][save2[i]-3] = tmp;
                                                tetrisData[save1[i]][save2[i]-2] = tmp;
                                                tetrisData[save1[i]][save2[i]-1] = tmp;

                                                return 1;	//Rotation complete
                                        }
					else if(tetrisData[save1[i]][save2[i]-2] == 0 && tetrisData[save1[i]][save2[i]-1] == 0 && tetrisData[save1[i]][save2[i]+1] == 0)
                                        {       //When left space == 2, right space == 1
                                                for(int j = 0;j < 4;j++)
                                                        tetrisData[save1[j]][save2[j]] = 0;

                                                tetrisData[save1[i]][save2[i]] = tmp;
                                                tetrisData[save1[i]][save2[i]-2] = tmp;
                                                tetrisData[save1[i]][save2[i]-1] = tmp;
                                                tetrisData[save1[i]][save2[i]+1] = tmp;

                                                return 1;	//Rotation complete
                                        }
					else if(tetrisData[save1[i]][save2[i]-1] == 0 && tetrisData[save1[i]][save2[i]+1] == 0 && tetrisData[save1[i]][save2[i]+2] == 0)
                                        {       //When left space == 1, right space == 2
                                                for(int j = 0;j < 4;j++)
                                                        tetrisData[save1[j]][save2[j]] = 0;

                                                tetrisData[save1[i]][save2[i]] = tmp;
                                                tetrisData[save1[i]][save2[i]-1] = tmp;
                                                tetrisData[save1[i]][save2[i]+1] = tmp;
                                                tetrisData[save1[i]][save2[i]+2] = tmp;

                                                return 1;	//Rotation complete
                                        }
					else if(tetrisData[save1[i]][save2[i]+1] == 0 && tetrisData[save1[i]][save2[i]+2] == 0 && tetrisData[save1[i]][save2[i]+3] == 0)
                                        {       //When left space == 0, right space == 3
                                                for(int j = 0;j < 4;j++)
                                                        tetrisData[save1[j]][save2[j]] = 0;

                                                tetrisData[save1[i]][save2[i]] = tmp;
                                                tetrisData[save1[i]][save2[i]+1] = tmp;
                                                tetrisData[save1[i]][save2[i]+2] = tmp;
                                                tetrisData[save1[i]][save2[i]+3] = tmp;

                                                return 1;	//Rotation complete
                                        }
				}

				return 2;	//Rotation fail
			}

		}
	}

	/*
	 * J -> rotationState == 1 : 2.6.10.9
	 * J -> rotationState == 2 : 1.5.6.7
	 * J -> rotationState == 3 : 2.1.5.9
	 * J -> rotationState == 4 : 1.2.3.7
	 * */
	else if(nowData == 1)	//J
	{
		if(rotationState == 1)
		{
			if(input == 120)	//Clockwise
			{
				if(tetrisData[save1[2]-1][save2[2]] == 0 && tetrisData[save1[3]][save2[3]+1] == 0)
				{	//When null 5.11
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[2]-1][save2[2]] = tmp;
					tetrisData[save1[3]][save2[3]+1] = tmp;

					return 2;
				}
				else if(tetrisData[save1[2]][save2[2]-1] == 0 && tetrisData[save1[1]][save2[1]-2] == 0)
				{	//When null left.9 left.left.6
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[2]][save2[2]-1] = tmp;
					tetrisData[save1[1]][save2[1]-2] = tmp;

					return 2;
				}
				else if(tetrisData[save1[3]][save2[3]+1] == 0 && tetrisData[save1[3]][save2[3]+2] == 0)
				{	//When null 11.12
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;

					tetrisData[save1[3]][save2[3]+1] = tmp;
					tetrisData[save1[3]][save2[3]+2] = tmp;
				
					return 2;
				}
			}
			else if(input == 122)	//Counterclockwise
			{
				if(tetrisData[save1[3]+1][save2[3]] == 0 && tetrisData[save1[2]][save2[2]-1] == 0)
				{	//When null left.9 14
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[3]+1][save2[3]] = tetrisData[save1[2]][save2[2]-1] = tmp;

					return 4;
				}
				else if(tetrisData[save1[3]][save2[3]+1] == 0 && tetrisData[save1[3]+1][save2[3]+1] == 0)
				{	//When null 11.15
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[3]][save2[3]+1] = tetrisData[save1[3]+1][save2[3]+1] = tmp;
				
					return 4;
				}
				else if(tetrisData[save1[1]][save2[1]-2] == 0 && tetrisData[save1[1]][save2[1]-1] == 0)
				{	//When null left.5 5
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;

					tetrisData[save1[1]][save2[1]-2] = tetrisData[save1[1]][save2[1]-1] = tmp;
				
					return 4;
				}
				else if(tetrisData[save1[1]][save2[1]-1] == 0 && tetrisData[save1[1]][save2[1]+1] == 0 && tetrisData[save1[3]][save2[3]+1] == 0)
				{	//When null 5.7.11
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[1]][save2[1]-1] = tetrisData[save1[1]][save2[1]+1] = tetrisData[save1[3]][save2[3]+1] = tmp;
				
					return 4;
				}
			}
		
			return 1;	//Rotation fail
		}
		else if(rotationState == 2)
		{
			if(input == 120)	//Clockwise
			{
				if(tetrisData[save1[1]+1][save2[1]] == 0 && tetrisData[save1[1]+2][save2[1]] == 0)
				{	//When null 9.13
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;
	
					tetrisData[save1[1]+1][save2[1]] = tmp;
					tetrisData[save1[1]+2][save2[1]] = tmp;
				
					return 3;
				}
				else if(tetrisData[save1[0]][save2[0]+1] == 0 && tetrisData[save1[1]+1][save2[1]] == 0)
				{	//When null 2.9
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[0]][save2[0]+1] = tmp;
					tetrisData[save1[1]+1][save2[1]] = tmp;

					return 3;
				}
				else if(tetrisData[save1[0]-1][save2[0]] == 0 && tetrisData[save1[0]-1][save2[0]+1] == 0)
				{	//When null up.1 up.right.1
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[0]-1][save2[0]] = tmp;
					tetrisData[save1[0]-1][save2[0]+1] = tmp;
					
					return 3;
				}
			}
			else if(input == 122)	//Counterclockwise
			{
				if(tetrisData[save1[2]-1][save2[2]] == 0 && tetrisData[save1[2]-2][save2[2]] == 0)
				{	//When null 2 up.2
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[2]-1][save2[2]] = tetrisData[save1[2]-2][save2[2]] = tmp;

					return 1;
				}
			}
		
			return 2;	//Rotation fail
		}
		else if(rotationState == 3)
		{
			if(input == 120)	//Clockwise
			{
				if(tetrisData[save1[3]][save2[3]-1] == 0 && tetrisData[save1[3]][save2[3]+1] == 0 && tetrisData[save1[3]+1][save2[3]+1] == 0)
				{	//When null left.9 10.14	
					for(int i = 0;i < 3;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[3]][save2[3]-1] = tetrisData[save1[3]][save2[3]+1] = tetrisData[save1[3]+1][save2[3]+1] = tmp;
				
					return 4;
				}
				else if(tetrisData[save1[3]][save2[3]+1] == 0 && tetrisData[save1[3]][save2[3]+2] == 0 && tetrisData[save1[3]+1][save2[3]+2] == 0)
				{	//When null 10.11.15
					for(int i = 0;i < 3;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[3]][save2[3]+1] = tetrisData[save1[3]][save2[3]+2] = tetrisData[save1[3]+1][save2[3]+2] = tmp;
				
					return 4;
				}
				else if(tetrisData[save1[2]][save2[2]-1] == 0 && tetrisData[save1[2]][save2[2]+1] == 0 && tetrisData[save1[2]+1][save2[2]+1] == 0)
				{	//When null left.5 6.10
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[2]][save2[2]-1] = tetrisData[save1[2]][save2[2]+1] = tetrisData[save1[2]+1][save2[2]+1] = tmp;
				
					return 4;
				}
				else if(tetrisData[save1[2]][save2[2]+1] == 0 && tetrisData[save1[2]][save2[2]+2] == 0 && tetrisData[save1[2]+1][save2[2]+2] == 0)
				{	//When null 6.7.11
					tetrisData[save1[0]][save2[0]] = 0;
                                        tetrisData[save1[1]][save2[1]] = 0;
                                        tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[2]][save2[2]+1] = tetrisData[save1[2]][save2[2]+2] = tetrisData[save1[2]+1][save2[2]+2] = tmp;
				
					return 4;
				}
			}
			else if(input == 122)	//Counterclockwise
			{
				if(tetrisData[save1[3]][save2[3]-1] == 0 && tetrisData[save1[3]][save2[3]+1] == 0 && tetrisData[save1[2]][save2[2]-1] == 0)
				{	//When null left.5 left.9 10
					for(int i = 0 ;i < 3;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[3]][save2[3]-1] = tetrisData[save1[3]][save2[3]+1] = tetrisData[save1[2]][save2[2]-1] = tmp;
				
					return 2;
				}
				else if(tetrisData[save1[2]][save2[2]-2] == 0 && tetrisData[save1[3]][save2[3]-2] == 0 && tetrisData[save1[3]][save2[3]-1] == 0)
				{	//When null left.left.5 left.left.9 left.9
					for(int i = 0;i < 3;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[2]][save2[2]-2] = tetrisData[save1[3]][save2[3]-2] = tetrisData[save1[3]][save2[3]-1] = tmp;
			
					return 2;	
				}
				else if(tetrisData[save1[3]][save2[3]+1] == 0 && tetrisData[save1[3]][save2[3]+2] == 0)
				{	//When null 10.11
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[3]][save2[3]+1] = tetrisData[save1[3]][save2[3]+2] = tmp;
				
					return 2;
				}
			}
		
			return 3;	//Rotation fail
		}
		else if(rotationState == 4)
		{
			if(input == 120)	//Clockwise
			{
				if(tetrisData[save1[0]+1][save2[0]] == 0 && tetrisData[save1[1]+1][save2[1]] == 0 && tetrisData[save1[1]-1][save2[1]] == 0)
				{	//When null 5.6 up.2
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[0]+1][save2[0]] = tetrisData[save1[1]+1][save2[1]] = tetrisData[save1[1]-1][save2[1]] = tmp;
				
					return 1;
				}
				else if(tetrisData[save1[1]+1][save2[1]] == 0 && tetrisData[save1[2]-1][save2[2]] == 0)
				{	//When null 6 up.3
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;
				
					tetrisData[save1[1]+1][save2[1]] =tetrisData[save1[2]-1][save2[2]] = tmp;
				
					return 1;	
				}
			}
			else if(input == 122)	//Counterclockwise
			{
				if(tetrisData[save1[1]+1][save2[1]] == 0 && tetrisData[save1[1]-1][save2[1]] == 0 && tetrisData[save1[2]-1][save2[2]] == 0)
				{	//When null 6 up.2 up.3
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[1]+1][save2[1]] = tetrisData[save1[1]-1][save2[1]] = tetrisData[save1[2]-1][save2[2]] = tmp;
				
					return 3;
				}
				else if(tetrisData[save1[0]+1][save2[0]] == 0 && tetrisData[save1[0]-1][save2[0]] == 0 && tetrisData[save1[1]-1][save2[1]] == 0)
				{	//Whne null 5 up.1 up.2
					for(int i = 1;i < 4;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[0]+1][save2[0]] = tetrisData[save1[0]-1][save2[0]] = tetrisData[save1[1]-1][save2[1]] = tmp;
				
					return 3;
				}
				else if(tetrisData[save1[1]-1][save2[1]] == 0 && tetrisData[save1[1]-2][save2[1]] == 0 && tetrisData[save1[1]-2][save2[1]+1] == 0)
				{	//When null up.2 up.up.2 up.up.3
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[1]-1][save2[1]] = tetrisData[save1[1]-2][save2[1]] = tetrisData[save1[1]-2][save2[1]+1] = tmp;
				
					return 3;
				}
				else if(tetrisData[save1[0]-1][save2[0]] == 0 && tetrisData[save1[0]-2][save2[0]] == 0 && tetrisData[save1[0]-2][save2[0]+1] == 0)
				{	//When null up.1 up.up.1 up.up.2
					for(int i = 1;i < 4;i++)
						tetrisData[save1[i]][save2[i]] = 0;
				
					tetrisData[save1[0]-1][save2[0]] = tetrisData[save1[0]-2][save2[0]] = tetrisData[save1[0]-2][save2[0]+1] = tmp;
				
					return 3;
				}
			}
			
			return 4;	//Rotation fail
		}
	}

	/*
	 * L -> rotationState == 1 : 1.5.9.10
	 * L -> rotationState == 2 : 3.2.1.5
	 * L -> rotationState == 3 : 1.2.6.10
	 * L -> rotationState == 4 : 5.6.7.3
	 * */
	else if(nowData == 2)	//L
	{
		if(rotationState == 1)
		{
			if(input == 120)	//Clockwise
			{
				if(tetrisData[save1[2]][save2[2]-1] == 0 && tetrisData[save1[2]+1][save2[2]-1] == 0)
				{	//When null left.9 left.13
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[2]][save2[2]-1] = tetrisData[save1[2]+1][save2[2]-1] = tmp;
				
					return 2;
				}
				else if(tetrisData[save1[2]+1][save2[2]] == 0 && tetrisData[save1[3]][save2[3]+1] == 0)
				{	//When null 13.11
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[2]+1][save2[2]] = tetrisData[save1[3]][save2[3]+1] = tmp;
				
					return 2;
				}
				else if(tetrisData[save1[1]][save2[1]-1] == 0 && tetrisData[save1[2]][save2[2]-1] == 0 && tetrisData[save1[1]][save2[1]+1] == 0)
				{	//When null left.5 left.9 6
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[1]][save2[1]-1] = tetrisData[save1[2]][save2[2]-1] = tetrisData[save1[1]][save2[1]+1] = tmp;
				
					return 2;
				}
				else if(tetrisData[save1[1]][save2[1]+1] == 0 && tetrisData[save1[1]][save2[1]+2] == 0)
				{	//When null 6.7
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[1]][save2[1]+1] = tetrisData[save1[1]][save2[1]+2] = tmp;
				
					return 2;
				}
			}
			else if(input == 122)	//Counterclockwise
			{
				if(tetrisData[save1[2]][save2[2]-1] == 0 && tetrisData[save1[1]][save2[1]+1] == 0)
				{	//When null left.9 6
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[2]][save2[2]-1] = tetrisData[save1[1]][save2[1]+1] = tmp;
				
					return 4;
				}
				else if(tetrisData[save1[1]][save2[1]+2] == 0 && tetrisData[save1[3]][save2[3]+1] == 0)
				{	//When null 7.11
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[1]][save2[1]+2] = tetrisData[save1[3]][save2[3]+1] = tmp;
				
					return 4;
				}
			}

			return 1;	//Rotation fail
		}
		else if(rotationState == 2)
		{
			if(input == 120)	//Clockwise
			{
				if(tetrisData[save1[0]-1][save2[0]] == 0 && tetrisData[save1[1]-1][save2[1]] == 0 && tetrisData[save1[1]+1][save2[1]] == 0)
				{	//when null up.1 up.2 6
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[0]-1][save2[0]] = tetrisData[save1[1]-1][save2[1]] = tetrisData[save1[1]+1][save2[1]] = tmp;
				
					return 3;
				}
				else if(tetrisData[save1[1]-1][save2[1]] == 0 && tetrisData[save1[2]-1][save2[2]] == 0 && tetrisData[save1[2]+1][save2[2]] == 0)
				{	//When null 7 up.2 up.3
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[1]-1][save2[1]] = tetrisData[save1[2]-1][save2[2]] = tetrisData[save1[2]+1][save2[2]] = tmp;
			
					return 3;
				}
				else if(tetrisData[save1[0]-2][save2[0]] == 0 && tetrisData[save1[1]-1][save2[1]] == 0 && tetrisData[save1[1]-2][save2[1]] == 0)
				{	//When null up.2 up.up.2 up.up.1
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[0]-2][save2[0]] = tetrisData[save1[1]-1][save2[1]] = tetrisData[save1[1]-2][save2[1]] = tmp;
				
					return 3;
				}
				else if(tetrisData[save1[1]-2][save2[1]] == 0 && tetrisData[save1[2]-1][save2[2]] == 0 && tetrisData[save1[2]-2][save2[2]] == 0)
				{	//When null up.up.2 up.3 up.up.3
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[1]-2][save2[1]] = tetrisData[save1[2]-1][save2[2]] = tetrisData[save1[2]-2][save2[2]] = tmp;
				
					return 3;
				}
			}
			else if(input == 122)	//Counterclockwise
			{
				if(tetrisData[save1[1]-1][save2[1]] == 0 && tetrisData[save1[1]+1][save2[1]] == 0 && tetrisData[save1[2]+1][save2[2]] == 0)
				{	//When null 6.7 up.2
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[1]-1][save2[1]] = tetrisData[save1[1]+1][save2[1]] = tetrisData[save1[2]+1][save2[2]] = tmp;
			
					return 1;
				}
				else if(tetrisData[save1[3]][save2[3]+1] == 0 && tetrisData[save1[0]-1][save2[0]] == 0)
				{	//When null 6 up.1
					tetrisData[save1[1]][save2[1]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;

					tetrisData[save1[3]][save2[3]+1] = tetrisData[save1[0]-1][save2[0]] = tmp;
				
					return 1;
				}
			}
		
			return 2;	//Rotation fail
		}
		else if(rotationState == 3)
		{
			if(input == 120)	//Clockwise
			{
				if(tetrisData[save1[2]][save2[2]+1] == 0 && tetrisData[save1[3]][save2[3]-1] == 0 && tetrisData[save1[3]][save2[3]+1] == 0)
				{	//When null 7 9.11
					for(int i = 0;i < 3;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[2]][save2[2]+1] = tetrisData[save1[3]][save2[3]-1] = tetrisData[save1[3]][save2[3]+1] = tmp;
				
					return 4;
				}
				else if(tetrisData[save1[3]][save2[3]-1] == 0 && tetrisData[save1[3]][save2[3]-2] == 0)
				{	//When null 9 left.9
					for(int i = 0;i < 2;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[3]][save2[3]-1] = tetrisData[save1[3]][save2[3]-2] = tmp;
				
					return 4;
				}
			}
			else if(input == 122)	//Counterclockwise
			{
				if(tetrisData[save1[3]][save2[3]-1] == 0 && tetrisData[save1[3]][save2[3]-2] == 0 && tetrisData[save1[3]+1][save2[3]-2] == 0)
				{	//When null 9 left.9 left.13 
					for(int i = 0;i < 3;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[3]][save2[3]-1] = tetrisData[save1[3]][save2[3]-2] = tetrisData[save1[3]+1][save2[3]-2] = tmp;
				
					return 2;
				}
				else if(tetrisData[save1[3]][save2[3]-1] == 0 && tetrisData[save1[3]+1][save2[3]-1] == 0 && tetrisData[save1[3]][save2[3]+1] == 0)
				{	//When null 9.13 11
					for(int i = 0;i < 3;i++)
						tetrisData[save1[i]][save2[i]] = 0;

					tetrisData[save1[3]][save2[3]-1] = tetrisData[save1[3]+1][save2[3]-1] = tetrisData[save1[3]][save2[3]+1] = tmp;

					return 2;
				}
				else if(tetrisData[save1[0]+1][save2[0]] == 0 && tetrisData[save1[0]+2][save2[0]] == 0 && tetrisData[save1[2]][save2[2]+1] == 0)
				{	//When null 5.9.7
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;
				
					tetrisData[save1[0]+1][save2[0]] = tetrisData[save1[0]+2][save2[0]] = tetrisData[save1[2]][save2[2]+1] = tmp;
				
					return 2;
				}
				else if(tetrisData[save1[2]+2][save2[2]] == 0 && tetrisData[save1[2]+1][save2[2]] == 0 && tetrisData[save1[3]][save2[3]-2] == 0)
				{	//When null left.5 5 left.9
					tetrisData[save1[0]][save2[0]] = 0;
                                        tetrisData[save1[1]][save2[1]] = 0;
                                        tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[2]+2][save2[2]] = tetrisData[save1[2]+1][save2[2]] = tetrisData[save1[3]][save2[3]-2] = tmp;
			
					return 2;
				}
			}
		
			return 3;	//Rotation fail
		}
		else if(rotationState == 4)
		{

			if(input == 120)	//Clockwise
			{
				if(tetrisData[save1[2]-1][save2[2]] == 0 && tetrisData[save1[2]-2][save2[2]] == 0)
				{	//When null 2 up.2
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;

					tetrisData[save1[2]-1][save2[2]] = tetrisData[save1[2]-2][save2[2]] = tmp;
				
					return 1;
				}
			}
			else if(input == 122)	//Counterclockwise
			{
				if(tetrisData[save1[2]-1][save2[2]] == 0 && tetrisData[save1[2]-2][save2[2]] == 0 && tetrisData[save1[1]-2][save2[1]] == 0)
				{	//When null 2 up.2 up.1
					tetrisData[save1[0]][save2[0]] = 0;
					tetrisData[save1[1]][save2[1]] = 0;
					tetrisData[save1[3]][save2[3]] = 0;

					tetrisData[save1[2]-1][save2[2]] = tetrisData[save1[2]-2][save2[2]] = tetrisData[save1[1]-2][save2[1]] = tmp;
				
					return 3;
				}
				else if(tetrisData[save1[0]-1][save2[0]] == 0 && tetrisData[save1[2]-2][save2[2]] == 0)
				{	//When null up.3 up.2
					tetrisData[save1[1]][save2[1]] = 0;
					tetrisData[save1[2]][save2[2]] = 0;

					tetrisData[save1[0]-1][save2[0]] = tetrisData[save1[2]-2][save2[2]] = tmp;
				
					return 3;
				}
			}
		
			return 4;	//Rotation fail
		}
	}

	/*
	 * O -> rotationState == 1 : 1.2.6.5
	 * */
	else if(nowData == 3)	//O
	{}

	/*
	 * S -> rotationState == 1 : 5.6.2.3
	 * S -> rotationState == 2 : 1.5.6.10
	 * */
	else if(nowData == 4)	//S
	{}

	/*
	 * T -> rotationState == 1 : 5.6.7.10
	 * T -> rotationState == 2 : 2.6.10.5
	 * T -> rotationState == 3 : 2.5.6.7
	 * T -> rotationState == 4 : 2.6.10.7
	 * */
	else if(nowData == 5)	//T
	{}
	/*
	 * Z -> rotationState == 1 : 1.2.6.7
	 * Z -> rotationState == 2 : 2.6.5.9
	 * */
	else if(nowData == 6)	//Z
	{}


}

int downBlock()
{
	int tmp = 0;
	int check = 0;
	for(int i = 1;i < 21;i++)
	{
		for(int j = 1;j < 11;j++)
		{
			if(tetrisData[i][j] >= 10 && tetrisData[i][j] <= 16)
			{
				save1[tmp] = i;
				save2[tmp] = j;
				tmp++;

				if(tetrisData[i+1][j] >= 100 || tetrisData[i+1][j] == 1)
					check++;
			}
		}
	}

	cout<<"downBlock "<<check<<" "<<tmp<<endl;

	if(check != 0)	//When there's no space to go down
	{
		for(int i = 0;i < tmp;i++)
			tetrisData[save1[i]][save2[i]] *= 10;

		scoreAlgorithm();

		return 1;
	}
	else	//When there's space to go down
	{
		int tmpcolor = tetrisData[save1[0]][save2[0]];
	
		for(int i = 0;i < tmp;i++)
			tetrisData[save1[i]][save2[i]] = 0;
	
		for(int i = 0;i < tmp;i++)
			tetrisData[save1[i] + 1][save2[i]] = tmpcolor;

		return 0;
	}
}

int collision(int type)
{
	int tmp = type;
	if(tmp == 0)	//I
	{
		if(tetrisData[1][4] == 0 && tetrisData[1][5] == 0 && tetrisData[1][6] == 0 && tetrisData[1][7] == 0)
			return 0;
		else
			return 1;
	}
	else if(tmp == 1)	//J
	{
		if(tetrisData[1][6] == 0 && tetrisData[2][6] == 0 && tetrisData[3][5] == 0 && tetrisData[3][6] == 0)
			return 0;
		else
			return 1;
	}
	else if(tmp == 2)	//L
	{
		if(tetrisData[1][5] == 0 && tetrisData[2][5] == 0 && tetrisData[3][5] == 0 && tetrisData[3][6] == 0)
			return 0;
		else
			return 1;
	}
	else if(tmp == 3)	//O
	{
		if(tetrisData[1][5] == 0 && tetrisData[1][6] == 0 && tetrisData[2][5] == 0 && tetrisData[2][6] == 0)
			return 0;
		else
			return 1;
	}
	else if(tmp == 4)	//S
	{
		if(tetrisData[1][5] == 0 && tetrisData[1][6] == 0 && tetrisData[2][5] == 0 && tetrisData[2][4] == 0)
			return 0;
		else
			return 1;
	}
	else if(tmp == 5)	//T
	{
		if(tetrisData[1][4] == 0 && tetrisData[1][5] == 0 && tetrisData[1][6] == 0 && tetrisData[2][5] == 0)
			return 0;
		else
			return 1;
	}
	else if(tmp == 6)	//Z
	{
		if(tetrisData[1][4] == 0 && tetrisData[1][5] == 0 && tetrisData[2][5] == 0 && tetrisData[2][6] == 0)
			return 0;
		else
			return 1;
	}
}

int gameAlgorithm(int in)
{
	//collision


	int tmpcolor;
	int blocknum = 4;
	int check = 0;

	if(in == 68)	//left
	{
		for(int i = 1;i < 21;i++)
		{
			for(int j = 1;j < 11;j++)
			{
				if(tetrisData[i][j] >= 10 && tetrisData[i][j] <= 16)	//nowblock
				{
					save1[check] = i;
					save2[check] = j;
					if( !(tetrisData[i][j-1] == tetrisData[i][j] || tetrisData[i][j-1] == 0) )
						return 1;	//block on the left

					check++;
				}
			}
		}

		tmpcolor = tetrisData[save1[0]][save2[0]];

		for(int i = 0;i < check;i++)
			tetrisData[save1[i]][save2[i]] = 0;
	
		for(int i = 0;i < check;i++)
			tetrisData[save1[i]][save2[i] - 1] = tmpcolor;

		return 1;
	}
	else if(in == 67)	//right
	{
		for(int i = 1;i < 21;i++)
		{
			for(int j = 1;j < 11;j++)
			{
				if(tetrisData[i][j] >= 10 && tetrisData[i][j] <= 16)	//nowblock
				{
					save1[check] = i;
					save2[check] = j;
					if( !(tetrisData[i][j+1] == tetrisData[i][j] || tetrisData[i][j+1] == 0) )
						return 1;

					check++;
				}
			}
		}

		tmpcolor = tetrisData[save1[0]][save2[0]];

		for(int i = 0;i < check;i++)
			tetrisData[save1[i]][save2[i]] = 0;
	
		for(int i = 0;i < check ;i++)
			tetrisData[save1[i]][save2[i] + 1] = tmpcolor;

		return 1;
	}
	else if(in == 66)	//down
	{
		int tmp = 20,gap = 0;
		for(int i = 1;i < 21;i++)
		{
			for(int j = 1;j < 11;j++)
			{
				if(tetrisData[i][j] >= 10 && tetrisData[i][j] <= 16)	//nowblock
				{
					save1[check] = i;
					save2[check] = j;

					gap = 0;

					for(int k = i + 1;k < 21;k++)
					{
						if(tetrisData[k][j] == 0)
							gap++;
						else
							break;
					}

					if(tetrisData[i+1][j] != tetrisData[i][j])
					{
						if(tmp > gap)
							tmp = gap;
					}

					check++;
				}
				
				if(check == blocknum)
					break;
			}
			if(check == blocknum)
				break;

		}
				//Need down block after move left, right, rotation
				//
		cout<<"tmp "<<tmp<<" check "<<check<<endl;

		tmpcolor = tetrisData[save1[0]][save2[0]];

		for(int i = 0;i < blocknum;i++)	//down block, fix to the bottom
			tetrisData[save1[i]][save2[i]] = 0;

		for(int i = 0;i < blocknum;i++)
			tetrisData[save1[i] + tmp][save2[i]] = tmpcolor;

		return 1;
	}

	return 1;
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
	int initnext;
//	while(1)
	{
		mainScrean();

		initnext = init();


		gameScrean(initnext);

	}


	return 0;
}
