#include <iostream>
#include <unistd.h>	//Using 'access(const char*, int)'
#include <string>

#include <cstdlib>	//Using 'c_str()'
#include <errno.h>	//Using 'stderr(errno)'

//#include <dirent.h>
#include <stdio.h>
#include <io.h>
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
const char *path;

void errorSet();
void inputScreen();
void findFile();

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

void inputScreen()
{
	cout<<"----------------------------------------------------------"<<endl;
	cout<<"\t\t"<<"-------------------------"<<endl;
	cout<<"\t\t"<<"       Find a file"<<endl;
	cout<<"\t\t"<<"-------------------------"<<"\n"<<endl;
//	cout<<"\t\t"<<"Please select an activity"<<endl;
//	cout<<"\t\t"<<"--Please enter a number--"<<endl;
	cout<<"\t"<<"       --Please enter a file name--"<<endl;
	cout<<"----------------------------------------------------------"<<endl;


	getline(cin,inputString);
	
	findFile();

	path = inputString.c_str();

	return;
}

void findFile()
{
/*
	path = inputString.c_str();
	int num = findfirst(path,,);
*/
	struct _finddata_t fd;

	return;
}

int main()
{
	
	inputScreen();

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
