#include <vector>
using namespace std;

int solution(vector<int> nums)
{
    int N = nums.size();
    int num[200001] = {0,};
    int check = 0;
    for(int i = 0;i < nums.size();i++)
        num[nums[i]]++;
    for(int i = 1;i < 200001;i++){
        if(num[i] != 0)
            check++;
    }
    
    int answer = 0;
    if(check >= N/2)
        answer = N/2;
    else
        answer = check;
    
    return answer;
}
