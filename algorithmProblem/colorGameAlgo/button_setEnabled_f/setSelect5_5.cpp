#include <iostream>
#include <fstream>

using namespace std;

ofstream fout("set5_5.out");

int main(){
	for(int i = 1;i < 51;i++)
		fout<<"button"<<i<<".setEnabled(false);"<<endl;
	return 0;
}
