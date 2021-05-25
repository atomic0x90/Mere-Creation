#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    sort(participant.begin(),participant.end());
    sort(completion.begin(),completion.end());
    int flag = 0;
    for(int i = 0;i < completion.size();i++){
        if(participant[i] != completion[i]){
            answer = participant[i];
            flag = 1;
            break;
        }
    }
    if(flag == 0)
        answer = participant.back();
    
    return answer;
}
