#include <iostream>
#include <fstream>
//#include <vector>
#include <cstring>	//strlen()


using namespace std;

ifstream fin("palindrome.inp");
ofstream fout("palindrome.out");

int testCase, checkNumber;

string finString;

char *splitString;

/*
char finValue;

vector <char>finString;
*/

void finFunction();
void foutFunction(int);
int palindromeCheckFunction(char *);

void finFunction()
{
	getline(fin,finString);

	splitString = (char *)finString.c_str();
	
	cout<<*splitString<<" "<<strlen(splitString)<<endl;

	checkNumber = palindromeCheckFunction(splitString);

	foutFunction(checkNumber);
	return;
}

int palindromeCheckFunction(char *value)
{
	int i = 0, j = strlen(value) - 1;
	int insertNumber = 0;

	cout<<i<<" "<<j<<" "<<value[i]<<" "<<value[j]<<endl;

	while(1)
	{
		cout<<value[i]<<" "<<value[j]<<endl;
		if(value[i] == value[j])
		{
			i++;
			j--;
		}
		else if(value[i] != value[j])
		{
			if(value[i+1] == value[j])
			{
				insertNumber++;
				i += 2;
				j--;
			}
			else if(value[i] == value[j-1])
			{
				insertNumber++;
				j -= 2;
				i++;
			}
			else if(value[i+1] != value[j] && value[i+2] == value[j])
			{
				insertNumber += 2;
				i += 3;
				j--;
			}
			else if(value[i] != value[j-1] && value[i] == value[j-2])
			{
				insertNumber += 2;
				i++;
				j -= 3;
			}
			else
				insertNumber = 3;
		}


		if(i >= j || insertNumber > 2)
			break;
	}
	

	return insertNumber;
}

void foutFunction(int result)
{
	cout<<"insertNumber : "<<result<<endl;

	if(result < 3)
		fout<<result<<endl;
	else
		fout<<"-1"<<endl;
	return;
}

int main()
{
	string tempString;

	getline(fin,tempString);
	testCase = atoi(tempString.c_str());

	while(testCase)
	{
		cout<<testCase;
		finFunction();
	
		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
