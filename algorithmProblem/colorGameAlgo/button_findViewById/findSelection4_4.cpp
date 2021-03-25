#include <iostream>

using namespace std;

int main(){
	for(int i = 1;i < 51;i++)
		cout<<"Button button"<<i<<" = (Button) findViewById(R.id.selection4_4_"<<i<<");"<<endl;

	cout<<endl;
	for(int i = 1;i < 51;i++)
		cout<<"button"<<i<<".setWidth(standardSize_X/4);"<<endl;

	cout<<endl;
        for(int i = 1;i < 51;i++)
                cout<<"button"<<i<<".setHeight(standardSize_X/4);"<<endl;
	return 0;
}
