#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> nums) {
    int answer = -1;
    
    vector <int> check;
    int nums_len = nums.size();
    int flag;
    int result = 0;
    for(int i = 0;i < nums_len-2;i++){
        for(int j = i+1;j < nums_len-1;j++){
            for(int k = j+1;k < nums_len;k++){
                check.push_back(nums[i]+nums[j]+nums[k]);
            }
        }
    }
    
    for(int i = 0;i < check.size();i++){
        flag = 0;
        for(int j = 2;j < check[i]/2;j++){
            if(check[i]%j == 0){
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            result++;
    }
    answer = result;
    return answer;
}
