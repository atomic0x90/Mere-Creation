#include <stdio.h>

int main()
{
	float a,b,h;

	printf("사다리꼴 밑변, 윗변, 높이를 입력하세요 : ");
	scanf("%f %f %f",&a,&b,&h);

	printf("사다리꼴의 넓이는 %.2f 입니다\n",((a+b)*h)/2.0 );

	return 0;
}
