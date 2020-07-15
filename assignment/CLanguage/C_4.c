#include <stdio.h>

int main()
{
	int k,e,m;

	printf("국어, 영어, 수학 점수를 입력하세요 : ");
	scanf("%d %d %d,",&k,&e,&m);

	printf("총합은 %d 이고\n",k+e+m);
	printf("평균은 %d 입니다\n",(k+e+m)/3);

	return 0;
}
