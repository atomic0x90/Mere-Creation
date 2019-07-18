#include <iostream>
#include <stack>
#include <string>
#include <vector>
using namespace std;

string input_string;	//Save input values
stack <char> temp_stack;
vector <char> temp_char;	//Save input by char
vector <int> formula;	//Save formula using a postfix notation
vector <int> digits_formula;	//Distinguish between digits

void Input_screen();
void split();
int valid_formula_check();
void infix_notation_change_to_postfix_notaion();
void distinguish_the_number_of_a_digit();


/*
 * cin infix notation
*/
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


/*
 * Divide a string into char
*/
void split()
{
	for(int i = 0; i < input_string.size(); i++)
		temp_char.push_back(input_string.at(i));
	
	return;
}


/*
 * Check list
 *
 * Parentheses paired -> ((1+2)*3
 * Duplicated operator -> 1 +/ 3
 * Using four aritimetical operations or number
*/
int valid_formula_check()
{
	int num = 0, check_duplicate_symbol = 0;	
/*
 * If 'check_duplicate_symbol >= 2' -> error 
 * Example duplicate symbol -> 1 + * 2,  1 / - 2, etc.
*/
	for(int i = 0; i < temp_char.size(); i++)
	{
		if(i == 0)
		{
			if(temp_char[i] == '*' || temp_char[i] == '/')	//Example -> * 3 - (4 + 5)
				return 0;
			else if(temp_char[i] == ' ')
			{
				int j = i;
				while(temp_char[j] == ' ')
					j++;
			
				if(temp_char[j] == '*' || temp_char[j] == '/')
					return 0;
			}
		}

		if(temp_char[i] == '(')
		{
			if(temp_char[i+1] == '*' || temp_char[i+1] == '/')	//Example -> 1 + (*2 - 3)
				return 0;
	
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


/*
 * 1. If number, push postfix notation
 * 
 * 2. If left parenthesis, stack push
 * 
 * 3. If right parenthesis, stack pop until left parenthesis comes out
 *  -> Push back the stack pop to the postfix notation
 * 
 * 4. If four aritimetical operator, stack pop until this is a higher priority than top of stack
 *  -> Push back the stack pop to the postfix notation
 *
 * 5. Once you have read the entire input formula, push the operator remaining in the stack to postfix notation
 *
 *
 * Priority
 * '(' < '+','-' < '*','/'
*/
void infix_notation_change_to_postfix_notaion()
{
	for(int i = 0; i < temp_char.size(); i++)
	{
		if(formula.empty() && temp_char[i] == '+')
			continue;
		
		else if(formula.empty() && temp_char[i] == '-')
			formula.push_back(-2);

		else if(temp_char[i] == ' ')	//Ignore space
			continue;
		else if(temp_char[i] == '(')	//(2) Push into stack if left parenthesis
		{
			int j = i + 1;
			
			while(temp_char[j] == ' ')
				j++;
			
			if(temp_char[j] == '-')		//Example -> 1*(-2)-3/4
				formula.push_back(-1);
			
			else if(temp_char[j] == '*' || temp_char[j] == '/')	//Example -> 1*(*2)
				return;

			temp_stack.push(temp_char[i]);

			i = j;
		}
		else if(temp_char[i] == ')')	//(3) Pop stack until the left parenthesis comes out
		{
			while(1)
			{
				if(temp_stack.top() == '(')
				{
					temp_stack.pop();
					break;
				}
				formula.push_back(temp_stack.top());
	
				temp_stack.pop();
			}
		}
		else if(temp_char[i] == '+' || temp_char[i] == '-')	//(4)
		{
			formula.push_back(' ');
			/*
			 * Blank push to distinguish the number of digits
			*/
			if(temp_stack.top() == '(' || temp_stack.top() == 'b')
				temp_stack.push(temp_char[i]);
			
			else
			{
				while(!(temp_stack.top() == '(' || temp_stack.top() == 'b'))
				{
					formula.push_back(temp_stack.top());
					temp_stack.pop();
				}
				temp_stack.push(temp_char[i]);
			}
		}
		else if(temp_char[i] == '*' || temp_char[i] == '/')	//(4)
		{
			formula.push_back(' ');
			/*
			 * Blank push to distinguish the number of digits
			*/
			if(temp_stack.top() == '+' || temp_stack.top() == '-')
				temp_stack.push(temp_char[i]);
			else
			{
				while(temp_stack.top() == '*' || temp_stack.top() == '/')
				{
					formula.push_back(temp_stack.top());
					temp_stack.pop();
				}
				temp_stack.push(temp_char[i]);
			}
		}
		else
		{	//(0) Number(ASCII code)
			formula.push_back(temp_char[i]);
		}
	}

	while(temp_stack.top() != 'b')		//(5)
	{
		formula.push_back(temp_stack.top());
		temp_stack.pop();
	}

	distinguish_the_number_of_a_digit();
	return;
}


/*
 * Increase the number of digits until the next operator appears when the number(formula)
 * 
 * Precautions
 * If there is a space between numbers, it is recognized as a single number
 * (Example) infix notation(input) 1  2 * 3 -4  -> postfix notation 12 3 * 4 -
*/
void distinguish_the_number_of_a_digit()
{
	cout<<endl<<"Postfix Notation"<<endl;
	for(int i = 0; i < formula.size(); i++)
	{
		if(formula[i] >= 48 && formula[i] <= 57)
		{
			digits_formula.push_back(formula[i]-48);
			while(formula[i+1] >= 48 && formula[i+1] <= 57)
			{
				int temp_num = 10 * digits_formula.back();
				temp_num += formula[i+1] - 48;

				digits_formula.pop_back();
				digits_formula.push_back(temp_num);
                		i++;
			}
		}
		else if(formula[i] == 42)	//ASCII code 42 -> '*'
			digits_formula.push_back(-10001);
		else if(formula[i] == 43)	//ASCII code 43 -> '+'
			digits_formula.push_back(-10003);
		else if(formula[i] == 45)	//ASCII code 45 -> '-'
			digits_formula.push_back(-10004);
		else if(formula[i] == 47)	//ASCII code 47 -> '/'
			digits_formula.push_back(-10007);
		else if(formula[i] == -1)
		{
			digits_formula.push_back(0);
			while(formula[i+1] >= 48 && formula[i+1] <= 57)
			{
				int temp_num = 10 * digits_formula.back();
				temp_num += formula[i+1] - 48;

				digits_formula.pop_back();
				digits_formula.push_back(temp_num);
				i++;
			}
			int change = digits_formula.back();
			digits_formula.pop_back();
			digits_formula.push_back((-1) * change);
		}
		else if(formula[i] == -2)
		{
			cout<<"test"<<endl;
			while(formula[i+1] == ' ')
				i++;

			digits_formula.push_back(0);
			while(formula[i+1] >= 48 && formula[i+1] <= 57)
			{
				int temp_num = 10 * digits_formula.back();
				temp_num += formula[i+1] - 48;

				digits_formula.pop_back();
				digits_formula.push_back(temp_num);
				i++;
			}
			int change = digits_formula.back();
			digits_formula.pop_back();
			digits_formula.push_back((-1) * change);

			cout<<"change"<<change<<endl;
		}
	}

	for(int i = 0; i < digits_formula.size(); i++)
	{
		if(digits_formula[i] == -10001)
			cout<<"* ";
		else if(digits_formula[i] == -10003)
			cout<<"+ ";
		else if(digits_formula[i] == -10004)
			cout<<"- ";
		else if(digits_formula[i] == -10007)
			cout<<"/ ";
		else if(digits_formula[i] !=  0)
			cout<<digits_formula[i]<<" ";
	}
	cout<<endl;

	return;
}


int main()
{
	int num;
	temp_stack.push('b');
/*
 * Why push 'b' into the stack?
 *  -> Express the bottom of a stack
*/

	while(1)
	{
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
