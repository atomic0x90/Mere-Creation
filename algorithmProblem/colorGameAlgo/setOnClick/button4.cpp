#include <iostream>
#include <fstream>
using namespace std;

ofstream fout("button4.out");

int main(){
	int start,end;
	cout<<"start"<<endl;
	cin>>start;
	cout<<"end"<<endl;
	cin>>end;

	for(int i = start;i <= end;i++){
		fout<<"button"<<i<<".setOnClickListener(new View.OnClickListener() {"<<endl;
		fout<<"\t@Override"<<endl;
		fout<<"\tpublic void onClick(View view) {"<<endl;
		fout<<"\t\tif(lock"<<i<<" == 1){"<<endl;
		fout<<"\t\t\tToast.makeText(Selection4_4.this,\"이전 단계를 먼저 성공하세요!\",Toast.LENGTH_SHORT).show();"<<endl;
		fout<<"\t\t}"<<endl;
		fout<<"\t\telse if(lock"<<i<<" == 0){"<<endl;
		fout<<"\t\t\tIntent intent = new Intent(Selection4_4.this,Game_4_4.class);"<<endl;
		fout<<"\t\t\tintent.putExtra(\"LV\","<<i<<");"<<endl;
		fout<<"\t\t\tstartActivity(intent);"<<endl;
		fout<<"\t\t}"<<endl;
		fout<<"\t}"<<endl;
		fout<<"});"<<endl;
	}
	return 0;
}
