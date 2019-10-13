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
		root->value = data;

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

int checkRoot;

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
		checkRoot = finPre[0];
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
	root = insertNumber(root,checkCenter);

	int saveC = 0;

	int tmpIn,tmpPre,tmpCenter = 0;
	cout<<checkCenter<<" "<<root->value<<" "<<checkPreNum<<" "<<nodeNum<<endl;

	for(int i = checkPreNum;i < nodeNum;i++)
	{
		if(in[i] == checkCenter)
		{
			cout<<"in[i] "<<in[i]<<" "<<checkCenter<<" "<<i<<endl;
			tmpIn = i;
			break;
		}
	}
	for(int i = checkPreNum;i < nodeNum;i++)
	{
		cout<<"TTTTTT"<<endl;
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
			cout<<"SSSSSS "<<i<<" "<<tmpIn<<endl;
			if(pre[i] == in[tmpIn])
			{
				cout<<"EEEEEEE"<<endl;
				tmpPre = i+1;
				break;
			}
		}
	}

	cout<<tmpIn<<" "<<tmpPre<<endl;
	
	if(checkPreNum == 0)
	{		//제일 위 root 제외
		for(int i = 0;i < tmpIn;i++)
		{
			if(pre[tmpPre+1] == in[i])
			{
				tmpCenter = in[i];
				saveC = i;
				break;
			}
		}
	}
	else
	{		//root 이후
		for(int i = 0;i < tmpIn;i++)
		{
			if(pre[tmpPre] == in[i])
			{
				tmpCenter = in[i];
				saveC = i;
				break;
			}
		}
	}

	cout<<endl<<" "<<checkCenter<<" "<<in[tmpIn+1]<<" "<<checkPreNum<<endl;
	cout<<"tmpCenter "<<tmpCenter<<" "<<pre[tmpPre]<<endl;

	if(tmpCenter == 0)
		return root;

	cout<<"In "<<tmpCenter<<endl;
	
	root->left = preIn(tmpCenter,0,in,pre,root->left);
	
	cout<<"Out ";
	
	inorderPrint(root);
	cout<<endl<<"TEST "<<tmpIn<<" "<<in[tmpIn]<<" "<<tmpPre<<" "<<tmpCenter<<" "<<root->value<<" "<<checkCenter<<endl;
	cout<<in[tmpIn+1]<<" "<<saveC<<endl;


	int checkInsert = 0;
	for(int i = tmpPre;i < nodeNum;i++)
	{
	
		if(pre[i] == in[tmpIn+1])
		{
			checkInsert++;
			break;
		}
	}
	cout<<"checkInsert "<<checkInsert<<" "<<in[tmpIn+1]<<endl;

	if(checkCenter == checkRoot)
	{
		root->right = preIn(pre[tmpIn+1],tmpIn+1,in,pre,root->right);
	}
	else if(checkInsert)
	{
		int tmpNum = 0;
		for(int i = 0;i<nodeNum;i++)
		{
			if(pre[tmpPre-1] == in[i])
			{
				tmpNum = i;
				break;
			}
		}
		cout<<"EEEE "<<tmpNum<<endl;

		root->right = preIn(pre[tmpNum],tmpIn+1,in,pre,root->right);
	}


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

	cout<<endl;
	inorderPrint(root);

	fin.close();
	fout.close();

	return 0;
}
