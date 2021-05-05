#include <iostream>
#include <fstream>

using namespace std;

ofstream fout("s5_5.out");

int main(){
	for(int i = 1;i < 51;i++)
		fout<<"button"<<i<<".setWidth(standardSize_X/4);"<<endl;
	fout<<endl;
	for(int i = 1;i < 51;i++)
		fout<<"button"<<i<<".setHeight(standardSize_X/4);"<<endl;

	return 0;
}
