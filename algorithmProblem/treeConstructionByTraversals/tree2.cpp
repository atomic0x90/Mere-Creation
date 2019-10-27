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
int tmpPost = 0;
int orderType1, orderType2;
int finPre[10000] = {0,};
int finIn[10000] = {0,};
int finPost[10000] = {0,};

Node* preIn(Node*,int,int,int);
Node* inPost(Node*,int,int,int);
Node* prePost();

void finFunction();
void foutFunction(Node*,int);
int constructionTree();

void prePrint(Node*);
void inPrint(Node*);
void postPrint(Node*);

void foutFunction(Node* root,int t)
{
	if(t == 1)
		postPrint(root);
	else if(t == 2)
		inPrint(root);
	else if(t == 3)
		prePrint(root);
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

int constructionTree()
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

		return 1;
	}
	else if( (orderType1 == -1 && orderType2 == 1) || (orderType1 == 1 && orderType2 == -1) )
	{
	
		return 2;
	}
	else if( (orderType1 == 0 && orderType2 == 1) || (orderType1 == 1 && orderType2 == 0) )
	{
		tmpPost = nodeNum-1;
		for(int i = 0;i<nodeNum;i++)
		{
			if(finIn[i] == finPost[nodeNum-1])
			{
				tmp = i;
				break;
			}
		}

		root = inPost(root,0,tmp,nodeNum-1);
		return 3;
	}
	
	return 0;
}

Node* inPost(Node* root,int le,int mi,int ri)
{
	root = insertNode(root,finIn[mi]);

//	cout<<root->value<<" "<<le<<" "<<mi<<" "<<ri<<" "<<tmpPost<<endl;

	int tmp;
	if(ri - mi > 0)		//right
	{
		tmpPost--;
		for(int i = mi;i <= ri;i++)
		{
			if(finPost[tmpPost] == finIn[i])
			{
				tmp = i;
				break;
			}
		}

		root->right = inPost(root->right,mi+1,tmp,ri);
	}

	if(mi - le > 0)		//left
	{
		cout<<root->value<<" "<<le<<" "<<mi<<" "<<ri<<" "<<tmpPost<<endl;
		for(int i = 0;i < ri;i++)
		{
			if(finPost[tmpPost-1] == finIn[i])
			{
				tmpPost--;
				tmp = i;
				break;
			}
		}
		root->left = inPost(root->left,le,tmp,mi-1);
	}

	return root;
}

Node* preIn(Node* root,int le,int mi,int ri)
{
	root = insertNode(root,finIn[mi]);

	int tmp;
	if(mi - le > 0)		//left
	{
		maxPre++;
		for(int i = 0;i < mi;i++)
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

void prePrint(Node* root)
{
	if(root == NULL)
		return;
	fout<<root->value<<endl;
	cout<<root->value<<" ";
	prePrint(root->left);
	prePrint(root->right);
}

void inPrint(Node* root)
{
	if(root == NULL)
		return;
	inPrint(root->left);
	fout<<root->value<<endl;
	cout<<root->value<<" ";
	inPrint(root->right);
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
	int checkFout = 0;
	finFunction();

	checkFout = constructionTree();

	cout<<endl;

	foutFunction(root,checkFout);

	fin.close();
	fout.close();

	return 0;
}
