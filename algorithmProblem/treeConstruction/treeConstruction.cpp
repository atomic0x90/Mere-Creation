#include <iostream>
#include <fstream>

#include <cstring>

using namespace std;

ifstream fin("tree.inp");
ofstream fout("tree.out");

int testCase, checkLength;
int checkR;

string finString;

char *splitString;

void finFunction();
void foutFunction();
void treeConstruction();
void preorder();
void inorder();

void finFunction()
{
	getline(fin,finString);

	splitString = (char *)finString.c_str();
	
	checkLength = strlen(splitString);

	cout<<checkLength<<endl;

	int i = 0,tmp = checkLength;
	while(tmp)
	{
		cout<<splitString[i];
	
		i++;
		tmp--;
	}
	cout<<endl;

	return;
}

void treeConstruction()
{
	checkR = 0;

	preorder();

	checkR = 0;

	inorder();

	return;
}

void preorder()
{
	int tmp = checkLength;
	int i = 0;
	while(tmp)
	{
		if(splitString[i] == '(')
			cout<<'r'<<checkR++<<endl;
		
		else if(splitString[i] == 'T')
		{
			cout<<'T';
			int j = i + 1;
			while(1)
			{
				if(splitString[j] == ' ')
					break;
				else
					cout<<splitString[j];
				j++;
			}
			cout<<endl;
		}
	
		i++;
		tmp--;
	}


	return;
}

void inorder()
{

	return;
}
void foutFunction()
{

	return;
}

int main()
{
	string tempString;

	getline(fin,tempString);
	testCase = atoi(tempString.c_str());


	while(testCase)
	{
		finFunction();
		
		treeConstruction();
		
		foutFunction();

		testCase--;
	}


	fin.close();
	fout.close();

	return 0;
}
