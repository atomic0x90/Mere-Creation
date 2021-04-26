#include <iostream>
#include <fstream>

using namespace std;

ofstream fout("buttonSet.out");
int main(){
	for(int i = 2;i < 26;i++)
	{
		fout<<"ViewGroup.LayoutParams param"<<i<<" = button"<<i<<".getLayoutParams();"<<endl;
		fout<<"param"<<i<<".width = (int) buttonLength;"<<endl;
		fout<<"param"<<i<<".height = (int) buttonLength;"<<endl;
		fout<<"button"<<i<<".setLayoutParams(param"<<i<<");"<<endl<<endl;
	}

	return 0;
}
