#include <iostream>
#include <fstream>

using namespace std;

ifstream fin("tree.inp");
ofstream fout("tree.out");

int nodeNum;
int orderType1, orderType2;
int finPre[10000] = {0,};
int finIn[10000] = {0,};
int finPost[10000] = {0,};

void finFunction();
void foutFunction();
void constructionTree();

void preorderPrint();
void inorderPrint();
void postorderPrint();

typedef struct NodeStruct
{
	int value;
	struct NodeStruct* left;
	struct NodeStruct* right;
}Node;

Node *root = NULL;

Node* insertNumber(Node* root,int data)
{
	root = (Node*)malloc(sizeof(Node));
	root->left = NULL;
	root->right = NULL;
	root->value = data;

	return root;
}

void finFunction()
{
	fin>>nodeNum;

	fin>>orderType1;

	cout<<orderType1<<endl;
	if(orderType1 == -1)
	{
		for(int i = 0;i < nodeNum;i++)
			fin>>finPre[i];
	}
	else if(orderType1 == 0)
	{
		for(int i = 0;i < nodeNum;i++)
			fin>>finIn[i];
	}
	else if(orderType1 == 1)
	{
		for(int i = 0;i < nodeNum;i++)
			fin>>finPost[i];
	}

	return;
}

int main()
{
	finFunction();

	fin.close();
	fout.close();

	return 0;
}
