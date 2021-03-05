#include <iostream>

using namespace std;

int main(){
	for(int i = 1;i < 101;i++){
		cout<<"if (button"<<i<<".getX() == buttonLayoutX["<<i<<"] && button"<<i;
		cout<<".getY() == buttonLayoutY["<<i<<"])"<<endl;
		cout<<"checkAnswer++;"<<endl;
	}
	return 0;
}
