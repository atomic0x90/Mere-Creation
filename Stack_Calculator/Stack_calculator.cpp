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
		if(temp_char[i] >= 48 && temp_char[i] <= 57)	//When the input value is numeric
		{
			cout<<"infix\t"<<temp_char[i]<<endl;
			if(postfix[postfix.size()-1].first != 0)	//
			{
				int temp;

				temp = postfix[postfix.size()-1].first;
				postfix.pop_back();
				postfix.push_back(make_pair((temp*10)+(temp_char[i]-48),'N'));
			}
			else
			{
				postfix.push_back(make_pair(temp_char[i]-48,'N'));
			}
		}
		else if(temp_char[i] == '+' || temp_char[i] == '-' || temp_char[i] == '*' || temp_char[i] == '/' || temp_char[i] == ' ' || temp_char[i] == '(' || temp_char[i] == ')')
		{	//When the input value is the four arithmetical operations
			
			if(temp_char[i] != ' ' && temp_char[i] != '(' && temp_char[i] != ')')
			{
				postfix.push_back(make_pair(0,temp_char[i]));
			}
		}
		else	//Not the four arithmetical operations or number
		{
		
			break;
		}
	}

	for(int i = 0; i < postfix.size(); i++)
	{
		if(postfix[i].first != 0)
			cout<<postfix[i].first<<endl;
		else
			cout<<postfix[i].second<<endl;
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

		infix_notation_change_to_postfix_notaion();

		break;
	}

	return 0;
}
