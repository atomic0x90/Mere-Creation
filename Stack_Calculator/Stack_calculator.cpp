#include <iostream>
#include <stack>
#include <string>
#include <vector>
#include <utility>	//Use pair
using namespace std;

string input_string;	//Save input values
stack <char> temp_stack;
vector <char> temp_char;	//Save input by letter
vector <pair<int,char>> postfix;

vector <char> formula;

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
	
/*	for(int i = 0; i < input_string.size(); i++)
		cout<<temp_char[i]<<endl;
*/
	return;
}

int valid_formula_check()
{
	int num = 0, check_duplicate_symbol = 0;	
/*
  If 'check_duplicate_symbol >= 2' -> error 

   Example duplicate symbol -> 1 + * 2,  1 / - 2, etc.
*/
	for(int i = 0; i < temp_char.size(); i++)
	{
		if(temp_char[i] == '(')
		{
			num++;
			if(check_duplicate_symbol == 1)		//Example -> 3 + (-4)
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
		if(temp_char[i] == ' ')
			continue;
		else if(temp_char[i] == '(')
		{
			temp_stack.push(temp_char[i]);
		}
		else if(temp_char[i] == ')')
		{
			while(1)
			{
				if(temp_stack.top() != '(')
				{
					temp_stack.pop();
					break;
				}
				formula.push_back(temp_stack.top());
	
				temp_stack.pop();
			}
		}
		else if(temp_char[i] == '+' || temp_char[i] == '-')
		{
			if(temp_stack.top() == '(')
				temp_stack.push(temp_char[i]);
			else
				formula.push_back(temp_char[i]);
		}
		else if(temp_char[i] == '*' || temp_char[i] == '/')
		{
			if(temp_stack.top() == '+' || temp_stack.top() == '-')
				temp_stack.push(temp_char[i]);
			else
				formula.push_back(temp_char[i]);
		}
		else
		{	//number(ASCII code)
			formula.push_back(temp_char[i]);
		}
	}

	for(int i = 0; i < formula.size(); i++)
	{
		cout<<formula[i]<<endl;
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
