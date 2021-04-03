#include <iostream>
#include <fstream>

using namespace std;

ofstream fout("fout.out");

int main(){
	int tmp = 0;
	for(int i = 2;i < 51;i++){
		int check = 0;
		fout<<"else if(LV == "<<i<<") {"<<endl;
		for(int j = 1;j <= 16;j++){
			if(j % 4 == 1)
				check++;
				
			if(j%4 == 1)
				tmp = 1;
			else if(j%4 == 2)
				tmp = 2;
			else if(j%4 == 3)
				tmp = 3;
			else if(j%4 == 0)
				tmp = 4;
			fout<<"\tbutton"<<j<<".setBackgroundColor(getResources().getColor(R.color.c4_4_";
			fout<<i<<"_"<<check<<"_"<<tmp<<"));"<<endl;
		}
		fout<<"}"<<endl;
	}

	return 0;
}
