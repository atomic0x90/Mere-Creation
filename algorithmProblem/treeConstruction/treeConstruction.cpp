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
	int i = 0,check = 0;
	while(tmp > 0)
	{
		if(splitString[i] == '(')
		{
			saveR.push(check++);
		}
		else if(splitString[i] == ')')
		{
			
		}
		else if(splitString[i] != ' ')
		{
			cout<<splitString[i];
			fout<<splitString[i];
			int j = 1;
			i++;
			while(i < checkLength)
			{
				if(splitString[i] == ' ')
					break;
				else
				{
					cout<<splitString[i];
					fout<<splitString[i];
				}
				i++;
				j++;
			}
			tmp -= j;
//			if(i < checkLength)
//			{
				cout<<endl;
				fout<<endl;
//			}
			if(splitString[i+1] != '(' || splitString[i+1] != ')')
			{
				if(!saveR.empty())
				{
					cout<<'r'<<saveR.top();
					fout<<'r'<<saveR.top();

					saveR.pop();

					cout<<endl;
					fout<<endl;
				}
			}
		}
		tmp--;
		i++;
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
