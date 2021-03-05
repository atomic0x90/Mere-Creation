#include <iostream>

#include <cstring>
using namespace std;

int main(){
	string s1 = "((int) buttonLength);";
	string s2 = "((int) buttonLength * 2);";
	string s3 = "((int) buttonLength * 3);";
	string s4 = "((int) buttonLength * 4);";
	string s5 = "((int) buttonLength * 5);";
	string s6 = "((int) buttonLength * 6);";
	string s7 = "((int) buttonLength * 7);";
	string s8 = "((int) buttonLength * 8);";
	string s9 = "((int) buttonLength * 9);";

	for(int i = 1;i < 101;i++){
		cout<<"button"<<i<<".setX";
		if(i % 10 == 1)
			cout<<"(0);"<<endl;
		else if(i % 10 == 2)
			cout<<s1<<endl;
		else if(i % 10 == 3)
			cout<<s2<<endl;
		else if(i % 10 == 4)
			cout<<s3<<endl;
		else if(i % 10 == 5)
			cout<<s4<<endl;
		else if(i % 10 == 6)
			cout<<s5<<endl;
		else if(i % 10 == 7)
			cout<<s6<<endl;
		else if(i % 10 == 8)
			cout<<s7<<endl;
		else if(i % 10 == 9)
			cout<<s8<<endl;
		else if(i % 10 == 0)
			cout<<s9<<endl;

		cout<<"button"<<i<<".setY";
		if(i < 11)
			cout<<"(0);"<<endl<<endl;
		else if(i < 21)
			cout<<s1<<endl<<endl;
		else if(i < 31)
			cout<<s2<<endl<<endl;
		else if(i < 41)
			cout<<s3<<endl<<endl;
		else if(i < 51)
			cout<<s4<<endl<<endl;
		else if(i < 61)
			cout<<s5<<endl<<endl;
		else if(i < 71)
			cout<<s6<<endl<<endl;
		else if(i < 81)
			cout<<s7<<endl<<endl;
		else if(i < 91)
			cout<<s8<<endl<<endl;
		else if(i < 101)
			cout<<s9<<endl<<endl;
	}

	return 0;
}
