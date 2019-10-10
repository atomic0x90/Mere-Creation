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
	if(root == NULL)
	{
		root = (Node*)malloc(sizeof(Node));
		root->left = NULL;
		root->right = NULL;
		root->value = 0;

		return root;
	}

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
Node* preIn(int,int,int *,int *,Node *);
void prePost();
void inPost();

void preorderPrint();
void inorderPrint(Node*);
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
//		root = insertNumber(root,finPre[0]);
		root = preIn(finPre[0],0,finIn,finPre,root);
	}
	else if( (orderType1 == -1 && orderType2 == 1) || (orderType1 == 1 && orderType2 == -1) )
	{}
	else if( (orderType1 == 0 && orderType2 == 1) || (orderType1 == 1 && orderType2 == 0) )
	{}

	return;
}

Node* preIn(int checkCenter,int checkPreNum,int *in,int *pre,Node *root)
{
//	root = insertNumber(root,checkCenter);

	cout<<"inorderPrint"<<endl;
	inorderPrint(root);
	cout<<"end"<<endl;

	if(root == NULL)
		cout<<"root is NULL "<<checkCenter<<" "<<checkPreNum<<endl;
	else
		cout<<root->value<<endl;
	int tmpIn,tmpPre;
	cout<<checkCenter<<" "<<checkPreNum<<" "<<in[3]<<" "<<pre[2]<<endl;

	for(int i = checkPreNum;i < nodeNum;i++)
	{
		if(in[i] == checkCenter)
		{
			tmpIn = i;
			break;
		}
	}

	for(int i = checkPreNum;i < nodeNum;i++)
	{
		if(checkPreNum == 0)
		{
			if(pre[i] == in[tmpIn])
			{
				tmpPre = i;
				break;
			}
		}
		else
		{
			if(pre[i] == in[tmpIn-1])
			{
				tmpPre = i;
				break;
			}
		}
	}

	cout<<tmpIn<<" "<<in[tmpIn]<<" "<<tmpPre<<" "<<pre[tmpPre]<<endl;
	
	if(!(tmpIn+1 == tmpPre))
	{
		cout<<"In"<<endl;
		if(root != NULL)
			root = preIn(in[tmpIn-1],0,in,pre,root->left);
		else if(root == NULL)
		{
			root = insertNumber(root,checkCenter);
			root = preIn(in[tmpIn-1],0,in,pre,root->left);
		}
		cout<<"Out"<<endl;
	}
	inorderPrint(root);

	cout<<"inserta "<<checkCenter<<" "<<endl;
	root = insertNumber(root,checkCenter);
	cout<<"insertb"<<endl;

	inorderPrint(root);

	return root;
}

void inorderPrint(Node* root)
{
	if(root == NULL)
		return;
	inorderPrint(root->left);
	cout<<root->value<<" ";
	inorderPrint(root->right);
}

int main()
{
	finFunction();

	constructionTree();

//	inorderPrint(root);

	fin.close();
	fout.close();

	return 0;
}
