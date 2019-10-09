#include <iostream>
#include <fstream>

using namespace std;

ifstream fin("tree.inp");
ofstream fout("tree.out");

int nodeNum;
int orderType1, orderType2;
int *finPre, *finIn, *finPost;

void finFunction();
void foutFunction();
void constructionTree();

int main()
{

	fin.close();
	fout.close();

	return 0;
}
