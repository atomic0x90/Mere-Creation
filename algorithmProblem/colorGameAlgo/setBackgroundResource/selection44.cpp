#include <iostream>
#include <fstream>

using namespace std;

ofstream fout("44.out");
int main(){
	for(int i = 1;i< 51;i++)
		fout<<"button"<<i<<".setBackgroundResource(R.drawable.selection4_4_"<<i<<");"<<endl;



	return 0;
}
