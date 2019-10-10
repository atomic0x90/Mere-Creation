#include <iostream>
#include <fstream>

using namespace std;

typedef struct NodeStruct
{
	int value;
	struct NodeStruct* left;
	struct NodeStruct* right;
}Node;

Node* root = NULL;

Node* insertNumber(Node* root,int data)
{
	root = (Node*)malloc(sizeof(Node));
	root->left = NULL;
	root->right = NULL;
	root->value = data;

	return root;
}

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

//*root, int *,int fNum1,int sNum1,int *,Num
void preIn(int,int,int *,int *,Node *);
void prePost();
void inPost();

void preorderPrint();
void inorderPrint();
void postorderPrint();

/*
Node* insertNumber(Node* root,int data)
{
	root = (Node*)malloc(sizeof(Node));
	root->left = NULL;
	root->right = NULL;
	root->value = data;

	return root;
}
*/
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

	fin>>orderType2;

	cout<<orderType2<<endl;
	if(orderType2 == -1)
	{
		for(int i = 0;i < nodeNum;i++)
			fin>>finPre[i];
	}
	else if(orderType2 == 0)
	{
		for(int i = 0;i < nodeNum;i++)
			fin>>finIn[i];
	}
	else if(orderType2 == 1)
	{
		for(int i = 0;i < nodeNum;i++)
			fin>>finPost[i];
	}

	return;
}

void constructionTree()
{
	if( (orderType1 == -1 && orderType2 == 0) || (orderType1 == 0 && orderType2 == -1) )
	{
		preIn(finPre[0],1,finIn,finPre,root);
	}
	else if( (orderType1 == -1 && orderType2 == 1) || (orderType1 == 1 && orderType2 == -1) )
	{}
	else if( (orderType1 == 0 && orderType2 == 1) || (orderType1 == 1 && orderType2 == 0) )
	{}

	return;
}

void preIn(int checkCenter,int checkPreNum,int *in,int *pre,Node *root)
{
	if(root == NULL)
		cout<<"NULL"<<endl;
	cout<<checkCenter<<" "<<checkPreNum<<" "<<in[3]<<" "<<pre[2]<<endl;

	return;
}

int main()
{
	finFunction();

	constructionTree();

	fin.close();
	fout.close();

	return 0;
}
