#include <iostream>
#include <fstream>

#include <cstring>

#include <vector>
#include <algorithm>
#include <utility>

using namespace std;


ofstream fout("colorOut.out");

vector <string> t44;
vector <string> t55;
vector <string> tx;

string inString;
string RED,GREEN,BLUE;

bool flag = true;
char type;
int redtmp = 0;
int greentmp = 0;
int bluetmp = 0;

char *splitString;

void inFunction();
void foutFunction(bool,char);
void hexAlgo(char);
void vectorSet(char);
void vectorFree(char);
void cal44();
void cal55();
void calx();
int htoiAlgo(int,int);
string itohAlgo(int,int);

int main(){

	inFunction();

	hexAlgo(type);

	foutFunction(flag,type);

	vectorFree(type);

	return 0;
}


void inFunction(){
	cin>>type;
	cin>>inString;

	splitString = (char*)inString.c_str();

	for(int i = 0;i < 6;i++)
	{
		cout<<splitString[i]<<endl;
	}

	return;
}

void foutFunction(bool Tflag,char Ttype){
	if(Tflag){
		if(Ttype == '4'){
			for(int i = 0; i < 17;i++){
				cout<<t44[i]<<endl;
			}
		}	
		//
		//

		return;
	}
	else{
		return;
	}
}

void vectorSet(char Ttype){
	if(Ttype == '4'){
		t44.reserve(17);
	}
	else if(Ttype == '5'){
		t55.reserve(26);
	}
	else if(Ttype == 'x'){
		tx.reserve(26);
	}

	return;
}

void vectorFree(char Ttype){
	if(Ttype == '4'){
		t44.clear();
	}
	else if(Ttype == '5'){
		t55.clear();
	}
	else if(Ttype == 'x'){
		tx.clear();
	}
}

int htoiAlgo(int a,int b){
	int tmp = 0;
	if(splitString[a] >= 48 && splitString[a] <= 57)
		tmp += ((int)splitString[a] - 48) * 16;
	else if(splitString[a] >= 97 && splitString[a] <= 102){
		if(splitString[a] == 'a')
			tmp += 16 * 1;
		else if(splitString[a] == 'b')
			tmp += 16 * 2;
		else if(splitString[a] == 'c')
			tmp += 16 * 3;
		else if(splitString[a] == 'd')
			tmp += 16 * 4;
		else if(splitString[a] == 'e')
			tmp += 16 * 5;
		else if(splitString[a] == 'f')
			tmp += 16 * 6;
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

void hexAlgo(char Ttype){
	if(Ttype != '4' && Ttype != '5' && Ttype != 'x'){
		flag = false;
		return;
	}
	
	if(strlen(splitString) != 6){
		flag = false;
		return;
	}

	vectorSet(Ttype);
	
	RED = splitString[0];
	RED += splitString[1];

	GREEN = splitString[2];
	GREEN = splitString[3];

	BLUE = splitString[4];
	BLUE = splitString[5];

	redtmp = htoiAlgo(0,1);
	greentmp = htoiAlgo(2,3);
	bluetmp = htoiAlgo(4,5);

	if(Ttype == '4')
		cal44();
	else if(Ttype == '5')
		cal55();
	else if(Ttype == 'x')
		calx();

	return;
}

string itohAlgo(int data, int add){
	string str = "";

	int tmp = data + add;
	int tmp1 = tmp / 16;
	int tmp2 = tmp % 16;

	if(tmp1 > 9)
	{
		if(tmp1 == 10)
			str = "a";
		else if(tmp1 == 11)
			str = "b";
		else if(tmp1 == 12)
			str = "c";
		else if(tmp1 == 13)
			str = "d";
		else if(tmp1 == 14)
			str = "e";
		else if(tmp1 == 15)
			str = "f";
	}
	else
		str = to_string(tmp1);


	if(tmp2 > 9)
	{
		if(tmp2 == 10)
			str += "a";
		else if(tmp2 == 11)
			str += "b";
		else if(tmp2 == 12)
			str += "c";
		else if(tmp2 == 13)
			str += "d";
		else if(tmp2 == 14)
			str += "e";
		else if(tmp2 == 15)
			str += "f";
	}
	else
		str += to_string(tmp2);

	return str;
}

void cal44(){
	string tmpString = "";

//	int tmpr = redtmp / 10;
//	int tmpg = greentmp / 10;
//	int tmpb = bluetmp / 10;

	for(int i = 1;i < 17;i++){
		int j,k;
		int tmp = 10;/*
		if(i <= 4)
			tmp = 20;
		else if(i <= 8)
			tmp = 17;
		else if(i <= 12)
			tmp = 14;
		else if(i <= 16)
			tmp = 11;*/
		int tmpr = redtmp / tmp;
		int tmpg = greentmp / tmp;
		int tmpb = bluetmp / tmp;
		int tmprr = redtmp / 7;
		int tmpgg = greentmp / 7;
		int tmpbb = bluetmp / 7;
		if(i <= 4)
			j = 0;
		else if(i <= 8)
			j = 1;
		else if(i <= 12)
			j = 2;
		else if(i <= 16)
			j = 3;

		if(i % 4 == 1)
			k = 0;
		else if(i % 4 == 2)
			k = 1;
		else if(i % 4 == 3)
			k = 2;
		else if(i % 4 == 0)
			k = 3;

		

		tmpString = itohAlgo(redtmp -(tmprr*j), -(tmpr*k));
		tmpString += itohAlgo(greentmp -(tmpgg*j), -(tmpg*k));
		tmpString += itohAlgo(bluetmp -(tmpbb*j), -(tmpb*k));

		t44.push_back(tmpString);
	}



	return;
}
void cal55(){

	return;
}
void calx(){

	return;
}
