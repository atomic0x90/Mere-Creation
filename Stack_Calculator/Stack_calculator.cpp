#include <iostream>
#include <stack>
#include <string>
#include <sstream>
#include <vector>

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
		
		vector<char> temp_char;

		for(int i = 0;i<input_string.size();i++)
			temp_char.push_back(input_string.at(i));

		for(int i = 0;i<temp_char.size();i++)
			cout<<temp_char[i]<<endl;

		break;
	}

	return 0;
}
