#include <iostream>
#include <fstream>
using namespace std;

ofstream fout("find5_5.out");
int main(){
	for(int i = 1;i <51;i++)
		fout<<"final Button button"<<i<<" = (Button) findViewById(R.id.selection5_5_"<<i<<");"<<endl;

	fout<<endl;
	for(int i = 1;i < 51;i++)
		fout<<"button"<<i<<".setEnabled(false);"<<endl;

	fout<<endl;
	for(int i = 1;i < 51;i++)
		fout<<"button"<<i<<".setEnabled(true);"<<endl;

	return 0;
}
