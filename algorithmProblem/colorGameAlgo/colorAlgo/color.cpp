#include <iostream>

#include <cstring>

using namespace std;

string inString;
string RED,GREEN,BLUE;

char *splitString;

int ri,gi,bi;
int rc[10][10],gc[10][10],bc[10][10];
string result[10][10];

void inFunction();
void hexAlgo();
int htoi(int,int);
void itoh();

void color();

int main(){
	inFunction();
	
	hexAlgo();

	return 0;
}

void hexAlgo(){
	RED = splitString[0];
	RED += splitString[1];
	GREEN = splitString[2];
	GREEN = splitString[3];
	BLUE = splitString[4];
	BLUE = splitString[5];
	
	ri = htoi(0,1);
	gi = htoi(2,3);
	bi = htoi(4,5);

	color();
/*
	for(int i = 0;i < 10;i++){
		for(int j = 0;j < 10;j++)
			cout<<rc[i][j]<<" "<<gc[i][j]<<" "<<bc[i][j]<<endl;
	}
*/
	itoh();
	return;
}

void itoh(){
	string tmp;
	int a,b,c,d,e,f;
	for(int i = 0;i < 10;i++){
		for(int j = 0;j < 10;j++){
			a = rc[i][j]/16;
			b = rc[i][j]%16;
			c = gc[i][j]/16;
			d = gc[i][j]%16;
			e = bc[i][j]/16;
			f = bc[i][j]%16;
			cout<<"a : "<<a<<" b "<<b<<" c "<<c<<" d "<<d<<" e "<<e<<" f "<<f<<endl;
			if(a == 1)
				result[i][j] = '1';
			else if(a == 2)
				result[i][j] = '2';
			else if(a == 3)
				result[i][j] = '3';
			else if(a == 4)
				result[i][j] = '4';
			else if(a == 5)
				result[i][j] = '5';
			else if(a == 6)
				result[i][j] = '6';
			else if(a == 7)
				result[i][j] = '7';
			else if(a == 8)
				result[i][j] = '8';
			else if(a == 9)
				result[i][j] = '9';
			else if(a == 10)
				result[i][j] = 'a';
			else if(a == 11)
				result[i][j] = 'b';
			else if(a == 12)
				result[i][j] = 'c';
			else if(a == 13)
				result[i][j] = 'd';
			else if(a == 14)
				result[i][j] = 'e';
			else if(a == 15)
				result[i][j] = 'f';

		}
	}

	cout<<endl<<"result"<<endl;
	for(int i = 0;i < 10;i++){
		for(int j = 0;j < 10;j++)
			cout<<result[i][j]<<endl;
	}

	return;
}

void color(){
	double a = 1,b = 0;
	for(int i = 0;i < 10;i++){
		for(int j = 0;j < 10;j++){
			rc[i][j] = a * ((double)ri + b);
			gc[i][j] = a * ((double)gi + b);
			bc[i][j] = a * ((double)bi + b);

			b -= 5;
		}
		a += 0.1;
		b = 0;
	}

	return;
}

int htoi(int a,int b){
	int tmp = 0;
	if(splitString[a] >= 48 && splitString[a] <= 57)
		tmp += ((int)splitString[a] - 48) * 16;
	else if(splitString[a] >= 97 && splitString[a] <= 102){
		if(splitString[a] == 'a')
			tmp += 16 * 10;
		else if(splitString[a] == 'b')
			tmp += 16 * 11;
		else if(splitString[a] == 'c')
			tmp += 16 * 12;
		else if(splitString[a] == 'd')
			tmp += 16 * 13;
		else if(splitString[a] == 'e')
			tmp += 16 * 14;
		else if(splitString[a] == 'f')
			tmp += 16 * 15;
	}
	
	if(splitString[b] >= 48 && splitString[b] <= 57)
		tmp += splitString[b] - 48;
	else if(splitString[b] >= 97 && splitString[b] <= 102){
		if(splitString[b] == 'a')
			tmp += 10;
		else if(splitString[b] == 'b')
			tmp += 11;
		else if(splitString[b] == 'c')
			tmp += 12;
		else if(splitString[b] == 'd')
			tmp += 13;
		else if(splitString[b] == 'e')
			tmp += 14;
		else if(splitString[b] == 'f')
			tmp += 15;
	}
	return tmp;
}

void inFunction(){
	cin>>inString;

	splitString = (char*)inString.c_str();
	
	return;
}
