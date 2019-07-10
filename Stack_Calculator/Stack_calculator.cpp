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

int valid_formula_check()
{
	int num = 0, check_duplicate_symbol = 0;	//Example duplicate symbol -> 1 + * 2,  1 / - 2, etc.
	

	for(int i = 0; i < temp_char.size(); i++)
	{
		if(temp_char[i] == '(')
		{
			num++;
			if(check_duplicate_symbol == 1)
				check_duplicate_symbol--;
		}
		else if(temp_char[i] == ')')
		{
			num--;
			if(check_duplicate_symbol == 1)
				return 0;
		}
		
		else if((temp_char[i] >= 48 && temp_char[i] <= 57) || temp_char[i] == ' ')
		{	//A blank space and number(ASCII code)
			if(temp_char[i] >= 48 && temp_char[i] <= 57 && check_duplicate_symbol == 1)
				check_duplicate_symbol--;

			continue;
		}

		else if(temp_char[i] == '+' || temp_char[i] == '-' || temp_char[i] == '/' || temp_char[i] == '*')
		{	//Four arithmetical operations
			check_duplicate_symbol++;

			if(check_duplicate_symbol == 2)
				return 0;
		}

		else	//Not the four aritimetical operations or number
			return 0;
	}

	if(num == 0)	//Parentheses are paired
		return 1;
	if(num != 0)	//Parentheses are not paired
		return 0;
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
		else	//When the input value is the four arithmetical operations
		{	
			if(temp_char[i] != ' ' && temp_char[i] != '(' && temp_char[i] != ')')
			{
				postfix.push_back(make_pair(0,temp_char[i]));
			}

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

		num = valid_formula_check();

		if(num == 1)
			infix_notation_change_to_postfix_notaion();
		else if(num == 0)
			printf("Parentheses do not match or are not math formula\n");

		break;
	}

	return 0;
}
