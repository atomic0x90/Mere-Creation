#include <iostream>
#include <fstream>

using namespace std;

ofstream fout("xml.out");

int main(){
	int c,r;
	for(int i = 0;i < 50;i++){
		if((i+1) % 4 == 1)
			c = 0;
		else if((i+1) % 4 == 2)
			c = 1;
		else if((i+1) % 4 == 3)
			c = 2;
		else if((i+1) % 4 == 0)
			c = 3;

		if(i < 4)
			r = 0;
		else if(i < 8)
			r = 1;
		else if(i < 12)
			r = 2;
		else if(i < 16)
			r = 3;
		else if(i < 20)
			r = 4;
		else if(i < 24)
			r = 5;
		else if(i < 28)
			r = 6;
		else if(i < 32)
			r = 7;
		else if(i < 36)
			r = 8;
		else if(i < 40)
			r = 9;
		else if(i < 44)
			r = 10;
		else if(i < 48)
			r = 11;
		else if(i < 52)
			r = 12;
		fout<<"<Button"<<endl;
		fout<<"\tandroid:id=\"@+id/selection5_5_"<<i+1<<"\""<<endl;
		fout<<"\tandroid:layout_width=\"wrap_content\""<<endl;
		fout<<"\tandroid:layout_height=\"wrap_content\""<<endl;
		fout<<"\tandroid:text=\""<<i+1<<"\""<<endl;
		fout<<"\tapp:layout_column=\""<<c<<"\""<<endl;
		fout<<"\tapp:layout_gravity=\"center\""<<endl;
		fout<<"\tapp:layout_row=\""<<r<<"\" />"<<endl;
	}
	return 0;
}
