#include <iostream>
#include <unistd.h>
#include <string>
#include <cstdlib>
/*
 * int access(const char *path, int amode);
 *  - Header file(unistd.h)
 *
 *
*/

using namespace std;


string a;
int main()
{
	getline(cin,a);
	const char *path = a.c_str();

	int num = access(path,0);

	cout<<num<<endl;
	
	getline(cin,a);
	path = a.c_str();
	num = access(path,0);

	cout<<num<<endl;
	return 0;
}
