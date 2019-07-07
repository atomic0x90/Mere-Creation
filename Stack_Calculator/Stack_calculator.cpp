#include <iostream>
#include <stack>
#include <string>
#include <vector>
#include <utility>	//Use pair
using namespace std;

string input_string;	//Save input values
stack <char> stack;
vector <char> temp_char;	//Save input by letter
vector <pair<int,char>> postfix;


void Input_screen()
{
	cout<<"----------------------------------------------------------"<<endl;
	cout<<"\t"<<"\t"<<"-------------------------"<<endl;
	cout<<"\t"<<"\t"<<"     Stack Calculator"<<endl;
	cout<<"\t"<<"\t"<<"-------------------------"<<"\n"<<endl;
	cout<<"\t"<<"   Please enter expression to calculator"<<endl;
	cout<<"\t"<<"     --Please enter Infix Notation--"<<endl;
	cout<<"----------------------------------------------------------"<<endl;

	getline(cin,input_string);

	return;
}

void split()
{
	for(int i = 0; i < input_string.size(); i++)
		temp_char.push_back(input_string.at(i));
	
	for(int i = 0; i < input_string.size(); i++)
		cout<<temp_char[i]<<endl;

	return;
}

void infix_notation_change_to_postfix_notaion()
{
	for(int i = 0; i < temp_char.size(); i++)
	{
		if(temp_char[i] >= 48 && temp_char[i] <= 57)
		{
		//	if(postfix.back
		}
	}

	return;
}

int main()
{
	int num;

	while(1)
	{
		postfix.push_back(make_pair(0,'N'));
		Input_screen();

		split();



		break;
	}

	return 0;
}
