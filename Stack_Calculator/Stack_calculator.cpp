#include <iostream>
#include <stack>
#include <string>
#include <sstream>

using namespace std;

string input_string;

void Input_screen()
{
	cout<<"----------------------------------------------------------"<<endl;
	cout<<"\t"<<"\t"<<"-------------------------"<<endl;
	cout<<"\t"<<"\t"<<"     Stack Calculator"<<endl;
	cout<<"\t"<<"\t"<<"-------------------------"<<"\n"<<endl;
	cout<<"\t"<<"   Please enter expression to calculator"<<endl;
	cout<<"\t"<<"     --Please enter Prefix Notation--"<<endl;
	cout<<"----------------------------------------------------------"<<endl;

	getline(cin,input_string);

	return;
}



int main()
{
	int num;

	while(1)
	{
		Input_screen();

		cout<<input_string<<endl;

		istringstream iss(input_string);
		
		while(iss)
		{
			string test;
			iss >> test;
			cout<<test<<endl;
		}

		break;
	}

	return 0;
}
