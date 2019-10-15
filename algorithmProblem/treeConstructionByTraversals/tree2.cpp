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

int checkRoot;

int maxPre = 0;
int checkPre = 0;

void finFunction();
void foutFunction();
void constructionTree();


//*root, int *,int fNum1,int sNum1,int *,Num
Node* preIn(int,int,int,int *,int *,Node *,int);
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
		for(int i = 0;i<nodeNum;i++)
		{
			if(finPre[0] == finIn[i])
			{
				checkPre = i;
				break;
			}
		}
		checkRoot = finPre[0];
		maxPre = 0;
		root = preIn(checkRoot,0,nodeNum,finIn,finPre,root,0);
	}
	else if( (orderType1 == -1 && orderType2 == 1) || (orderType1 == 1 && orderType2 == -1) )
	{}
	else if( (orderType1 == 0 && orderType2 == 1) || (orderType1 == 1 && orderType2 == 0) )
	{}

	return;
}

Node* preIn(int checkCenter,int checkF,int checkL,int *in,int *pre,Node *root,int rootData)
{
	root = insertNumber(root,checkCenter);

	cout<<"checkCenter "<<checkCenter<<" checkF "<<checkF<<" checkL "<<checkL;
	cout<<" rootData "<<rootData<<" root->value "<<root->value<<endl;
	if(checkF == checkL)
		return root;

	int tmpIn,tmpPre,tmpCenter = 0;
	tmpIn = tmpPre = 0;

	for(int i = checkF;i < checkL;i++)
	{
		if(in[i] == checkCenter)
		{
			tmpIn = i;
			break;
		}
	}
	for(int i = 0;i < nodeNum;i++)
	{
		if(pre[i] == in[tmpIn])
		{
			tmpPre = i + 1;
			break;
		}
	}
	for(int i = checkF;i < checkL;i++)
	{
		if(pre[tmpPre] == in[i])
		{
			tmpCenter = i;
			break;
		}
	}

	cout<<"tmpIn "<<in[tmpIn]<<" "<<tmpIn<<" tmpPre "<<pre[tmpPre]<<" ";
	cout<<tmpPre<<" tmpCenter "<<in[tmpCenter]<<" "<<tmpCenter<<endl<<endl;

	if(maxPre < tmpPre)
		maxPre = tmpPre;

	if(tmpCenter == 0)
	{
		root->left = insertNumber(root->left,in[tmpCenter]);
	}
/*	else if(tmpCenter == 0 && tmpIn != 1)
	{
		return root;
	}
*/	else
	{
		int checkMin = 0;
		for(int i = 0;i<nodeNum;i++)
		{
			if(pre[tmpPre] == in[i])
			{
				checkMin = i;
				break;
			}
		}
		cout<<"checkMin "<<checkMin<<endl;	
		if(checkMin < tmpIn)
			root->left = preIn(in[tmpCenter],0,tmpIn,in,pre,root->left,checkCenter);
		else
			root->left = preIn(in[tmpCenter],checkMin,tmpIn,in,pre,root->left,checkCenter);
		cout<<"outIn"<<endl<<endl;
	}
	inorderPrint(root);
	cout<<endl<<"tmpIn "<<in[tmpIn]<<" "<<tmpIn<<" tmpPre "<<pre[tmpPre]<<" ";
	cout<<tmpPre<<" tmpCenter "<<in[tmpCenter]<<" "<<tmpCenter<<endl;
	int tmp = 0;
	for(int i = 0;i<nodeNum;i++)
	{
		if(in[tmpIn+1] == pre[i])
		{
			tmp = i;
			break;
		}
	}
	cout<<"tmp "<<tmp<<" maxPre "<<maxPre<<endl<<endl;
	if(tmp >= maxPre)
	{
		cout<<"right "<<maxPre;
		cout<<endl<<"tmpIn "<<in[tmpIn]<<" "<<tmpIn<<" tmpPre "<<pre[tmpPre]<<" ";
		cout<<tmpPre<<" tmpCenter "<<in[tmpCenter]<<" "<<tmpCenter<<endl;
		cout<<"-----------"<<endl;
		
		int tmp1;
		for(int i = 0;i<nodeNum;i++)
		{
			if(in[i] == rootData)
			{
				tmp1 = i;
				break;
			}
		}
		if(checkPre != tmpIn && tmp != maxPre)
			root->right = preIn(pre[maxPre+1],tmpIn+1,tmp1,in,pre,root->right,checkCenter);
		else if(checkPre != tmpIn && tmp == maxPre)
			root->right = preIn(pre[maxPre],tmpIn+1,tmp1,in,pre,root->right,checkCenter);
		else
			root->right = preIn(pre[maxPre],tmpIn+1,nodeNum,in,pre,root->right,checkCenter);
	}	

//	root->right = preIn(,,in,pre,root->right,checkCenter);

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
