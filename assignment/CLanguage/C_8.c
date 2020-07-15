#include <stdio.h>

int main()
{
	int input;

	printf("----------------------------\n");
	printf("초 입력: ");
	scanf("%d",&input);
	printf("%d초는 %d시간 %d분 %d초 입니다.\n",input,(input/3600),(input%3600)/60,(input%60));
	printf("----------------------------\n");

	return 0;
}
