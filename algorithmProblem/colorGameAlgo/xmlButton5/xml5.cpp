#include <iostream>
#include <fstream>

using namespace std;

ofstream fou("xml5.out");

int main(){

	for(int i = 1;i < 51;i++){
		fout<<"<Button"<<endl;
		fout<<"\tandroid:id=\"@+id/selection5_5_"<<i<<"\""<<endl;
		fout<<"\tandroid:layout_width=\"wrap_content\""<<endl;
		fout<<"\tandroid:layout_height=\"wrap_content\""<<endl;
		fout<<"\tandroid:text=\""<<i<<"\""<<endl;
		fout<<"app:layout_constrainStart_toStartOf=\"parent\""<<endl;
		fout<<"app:layout_constrainTop_toTopOf=\"parent\" />"<<endl;
		fout<<endl;
	}

	return 0;
}
