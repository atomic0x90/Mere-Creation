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

Node* insertNode(Node* root,int data)
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
int maxPre = 0;
int orderType1, orderType2;
int finPre[10000] = {0,};
int finIn[10000] = {0,};
int finPost[10000] = {0,};

Node* preIn(Node*,int,int,int);

void finFunction();
void foutFunction();
void constructionTree();

void postPrint(Node*);

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
	int tmp;
	if( (orderType1 == -1 && orderType2 == 0) || (orderType1 == 0 && orderType2 == -1) )
	{
		for(int i = 0;i<nodeNum;i++)
		{
			if(finPre[0] == finIn[i])
			{
				tmp = i;
				break;
			}
		}
		//Node,left,middle,right,rrootI//,rrootP
		root = preIn(root,0,tmp,nodeNum);
	}
	else if( (orderType1 == -1 && orderType2 == 1) || (orderType1 == 1 && orderType2 == -1) )
	{}
	else if( (orderType1 == 0 && orderType2 == 1) || (orderType1 == 1 && orderType2 == 0) )
	{}

	return;
}

Node* preIn(Node* root,int le,int mi,int ri)
{
	root = insertNode(root,finIn[mi]);

	int tmp;
	if(mi - le > 0)		//left
	{
		maxPre++;
		for(int i = 0;i<mi;i++)
		{
			if(finPre[maxPre] == finIn[i])
			{
				tmp = i;
				break;
			}
		}
		root->left = preIn(root->left,le,tmp,mi);
	}

	if(ri - mi > 1)		//right
	{
		cout<<root->value<<" "<<le<<" "<<mi<<" "<<ri<<" "<<" "<<maxPre<<endl;
	
		for(int i = mi+1 ;i < ri ;i++)
		{
			if(finIn[i] == finPre[maxPre+1])
			{
				maxPre++;
				tmp = i;
				break;
			}
		}
		cout<<root->value<<" "<<le<<" "<<mi<<" "<<ri<<" "<<" "<<maxPre<<endl;
		root->right = preIn(root->right,mi+1,tmp,ri);
	}

	return root;
}

void postPrint(Node* root)
{
	if(root == NULL)
		return;
	postPrint(root->left);
	postPrint(root->right);
	cout<<root->value<<" ";
	fout<<root->value<<endl;
}

int main()
{
	finFunction();

	constructionTree();

	cout<<endl;
	postPrint(root);

	fin.close();
	fout.close();

	return 0;
}
