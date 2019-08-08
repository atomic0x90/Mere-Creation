#include <iostream>
#include <unistd.h>	//Using 'access(const char*, int)'
#include <string>

#include <cstdlib>	//Using 'c_str()'
#include <errno.h>	//Using 'stderr(errno)'
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

string inputString;

void errorSet();

void errorSet()
{
	if(errno == 2)	//ENOENT
		cout<<"No such file or directory"<<endl;
	else if(errno == 13)	//EACCES
		cout<<"Permission denied"<<endl;
	else if(errno == 21)	//EISDIR
		cout<<"Is a directory"<<endl;
	else
		cout<<"Error"<<endl;

	return;
}

int main()
{
	getline(cin,inputString);
	const char *path = inputString.c_str();

	int num = access(path,0);

	cout<<num<<endl;
	
	getline(cin,inputString);
	path = inputString.c_str();
	num = access(path,0);

	cout<<num<<endl;

	getline(cin,inputString);
	path = inputString.c_str();
	num = unlink(path);

	if(num == -1)
		cerr<<EACCES<<"A "<<ENOENT<<" "<<errno<<" B "<<endl;
	cout<<num<<" "<<inputString<<endl;

	errorSet();
	return 0;
}
