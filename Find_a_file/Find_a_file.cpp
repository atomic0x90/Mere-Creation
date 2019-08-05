#include <iostream>
#include <unistd.h>	//Using 'access(const char*, int)'
#include <string>
#include <cstdlib>	//Using 'c_str()'
/*
 * int access(const char *path, int amode);
 *  - Header file(unistd.h)
 *  - Ability to check if a file exists
 *  - path : Path to file
 *  - amode : Type of inspection
 *    - 0 : Check the existence of a file
 *    - 1 : Running a file
 *    - 2 : Check if file can be written
 *    - 4 : Check if file can be read
 *    - 6 : Check if file can be written and read
 *  - Return value
 *    - true : 0
 *    - false(error) : -1
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
