#include<iostream>
#include<fstream>
#include<stdio.h>


using namespace std;

int main(){

    string num;
    ofstream files[10];
    char name[6] = "0.txt";

    for (int i=0;i<10;i++){    
        name[0] = char(i+'0');
        files[i].open(name, ios_base::out);
    }

    while(1){ 
        cin>>num;
        if (num.compare("0000000000")==0) break;
        files[num[0]-'0']<<num<<endl;
        files[num[0]-'0'].flush();
    }
    for (int i=0;i<10;i++){
        files[i].close();
    }
    
}
