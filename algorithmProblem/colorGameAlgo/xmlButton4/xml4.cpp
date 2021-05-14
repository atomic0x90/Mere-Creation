#include <iostream>
#include <fstream>

using namespace std;

ofstream fout("xml.out");

int main(){
	int c,r;
	int check = 0;
	for(int i = 0;i < 50;i++){
		if((i+1) % 2 == 1)
			c = 0;
		else if((i+1) % 2 == 0)
			c = 1;
		r = i / 2;
		
		fout<<"<Button"<<endl;
		fout<<"\tandroid:id=\"@+id/selection4_4_"<<i+1<<"\""<<endl;
		fout<<"\tandroid:layout_width=\"wrap_content\""<<endl;
		fout<<"\tandroid:layout_height=\"wrap_content\""<<endl;
		fout<<"\tandroid:text=\""<<i+1<<"\""<<endl;
		fout<<"\tapp:layout_column=\""<<c<<"\""<<endl;
		fout<<"\tapp:layout_gravity=\"center\""<<endl;
		fout<<"\tapp:layout_row=\""<<r<<"\" />"<<endl;
	}
	return 0;
}
