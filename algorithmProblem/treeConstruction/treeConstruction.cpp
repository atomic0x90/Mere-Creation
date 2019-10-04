#include <iostream>
#include <fstream>
#include <stack>

#include <cstring>	//c_str, string

using namespace std;

ifstream fin("tree.inp");
ofstream fout("tree.out");

int testCase, checkLength;
int checkR;

stack<int>saveR;

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


	int i = 0,tmp = checkLength;
	while(tmp)
	{
		cout<<splitString[i];
		
		fout<<splitString[i];	//

		i++;
		tmp--;
	}
	cout<<endl;

	fout<<endl;	//

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
	cout<<"Preorder"<<endl;
	
	fout<<"Preorder"<<endl;	//
	int tmp = checkLength;
	int i = 0;
	while(tmp)
	{
		if(splitString[i] == '(')
		{
			cout<<'r'<<checkR<<endl;
			fout<<'r'<<checkR<<endl;	//
			checkR++;
		}
		else if(splitString[i] != ' ' && splitString[i] != ')')//(splitString[i] == 'T')
		{
			cout<<splitString[i];
			fout<<splitString[i];	//
			int j = 1;
			i++;
			while(1)
			{
				if(splitString[i] == ' ')
					break;
				else// if( !(atoi(&splitString[j]) >= 0 && atoi(&splitString[j]) < 10) )
				{
					cout<<splitString[i];
					fout<<splitString[i];	//
				}
				i++;
				j++;
			}
			tmp -= j;
			cout<<endl;
			fout<<endl;	//
		}
	
		i++;
		tmp--;
	}


	return;
}

void inorder()
{
	cout<<"Inorder"<<endl;
	fout<<"Inorder"<<endl;	//
	int tmp = checkLength;
	int i = 0;
	while(tmp)
	{
		if(splitString[i] == '(')
		{
			saveR.push(checkR++);
		}
		else if(splitString[i] == ')')
		{
			if(!saveR.empty())
			{
				cout<<'r'<<saveR.top()<<endl;
				fout<<'r'<<saveR.top()<<endl;	//
				saveR.pop();
			}
		}
		else if(splitString[i] == 'T')
		{
			cout<<'T';
			fout<<'T';	//
			int j = i + 1;
			while(1)
			{
				if(splitString[j] == ' ')
					break;
				else 
				{
					cout<<splitString[j];
					fout<<splitString[j];	//
				}
				j++;
			}
			
			cout<<endl;
			fout<<endl;	//

			if(!saveR.empty())
			{
				cout<<'r'<<saveR.top()<<endl;
				fout<<'r'<<saveR.top()<<endl;	//
				saveR.pop();
			}
		}
	
		i++;
		tmp--;
	}

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
