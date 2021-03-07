#include <iostream>

#include <cstring>

using namespace std;

string inString;
string RED,GREEN,BLUE;

char *splitString;

int ri,gi,bi;


void inFunction();
void hexAlgo();
int htoi(int,int);
string itoh();

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
