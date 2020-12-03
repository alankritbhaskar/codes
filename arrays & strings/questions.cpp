#include <iostream>
#include <vector>

using namespace std;

// Array Basic Questions.......

// Seggregate positive and negative numbers in an array

// Approach 1:- Sorting, Approach 2:- Count the positive and then extra space for positive and negative nos.

// Approach 3:- Two pointers

void seggregate(vector <int> &arr)
{
int p = 0;// positive index pointer
int n = arr.size()-1;// negative no. index pointer

while(p<n){
    if(arr[p]>0 && arr[n]<0){
        p++;
        n--;
    }
    else if(arr[p]>0 && arr[n]>=0){
    swap(arr[p],arr[n]);
    p++;
    }
    else if(arr[p]<0 && arr[n]<0){
        swap(arr[p],arr[n]);
        n--;
    }
    else{
        swap(arr[p],arr[n]);
        p++;
        n--;
    }
}
}

int main(){
vector<int>arr = {4,-3,6,7,2,-8,-9,10,11,12,-19};
seggregate(arr);

for(auto ele: arr)
cout<<ele<<" ,";

cout<<"\n";
return 0;
}