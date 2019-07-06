#include <iostream>
#include <stack>
#include <string>
#include <sstream>
#include <vector>
#include <iterator>

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

template<typename Out>

void split(const string &s, char delim, Out result)
{
	stringstream ss(s);
	string item;

	while(getline(ss, item, delim))
		*(result)++ = item;
}

vector<string> split(const string &s, const char delim)
{
	vector<string> elems;
	split(s, delim, back_inserter(elems));

	return elems;
}

int main()
{
	int num;

	while(1)
	{
		Input_screen();

		cout<<input_string<<endl;
		vector<string> x = split(input_string,' ');

		for(int i=0;i<x.size();i++)
			cout<<x[i]<<endl;
		
		
		/*
		istringstream iss(input_string);
		
		while(iss)
		{
			string test;
			iss >> test;
			cout<<test<<endl;
		}
*/
		break;
	}

	return 0;
}
