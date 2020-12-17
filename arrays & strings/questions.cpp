#include <iostream>
#include <vector>

using namespace std;

// Array Basic Questions.......

// Seggregate positive and negative numbers in an array

// Approach 1:- Sorting, Approach 2:- Count the positive and then extra space for positive and negative nos.

// Approach 3:- Two pointers

void seggregate(vector <int> &arr)
{

if(arr.size()==0)
return;

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

void segregateZeroOne(vector<int> & arr){

    if(arr.size()==0)
    return;

    int pivot=-1; //pivot partitions my array into two parts
    int idx=0;
    int n=arr.size();

    while(idx < n){
        if(arr[idx]==0)
            swap(arr[++pivot],idx);
        idx++;
    }
}

// Leetcode 75. Sort Colours

// Partition as below:-   (zero) (one) (unexplored) (two)
//                        |      |     |            |
//                        0      p1   idx          p2

    void sortColors(vector<int>& arr) {
    if(arr.size()==0)
    return;

    int p1= -1;
    int idx= 0;
    int n= arr.size();
    int p2= n-1;

    while(idx <= p2){
        if(arr[idx]==0){
            swap(arr[++p1],arr[idx++]);
            }
        else if(arr[idx]==2){
            swap(arr[p2--],arr[idx]);
        }
        else
        idx++;
    }
}

// Leetcode 283. Move Zeroes

void moveZeroes(vector<int>& arr) {

    if(arr.size()==0)
    return;
    
    int n=arr.size();
    int pivot=0; //pivot partitions my array into two parts
    int idx=0;
    

    while(idx < n){
        if(arr[idx]!=0)
            swap(arr[pivot++],arr[idx]);
        idx++;
    }
}




//Smallest window that contains all characters of string itself...... https://www.geeksforgeeks.org/smallest-window-contains-characters-string/

/*
Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

Examples:

Input: aabcbcdbca
Output: dbca
*/

int main()
 {
    int t;
    cin>>t;
    
    while(t--){
	string s;
	cin>>s;
	
	int n=s.length();
	vector<int> freq(128,0);
	int si=0,ei=0,head=0,len=(int)1e8,requirement=0;
	
	for(int i=0;i<n;i++) freq[s[i]]=1;
	
    for(int ele : freq) requirement += ele;

	while(ei<n){
	    
	    if(freq[s[ei++]]-- > 0) requirement--;
	    
	    while(requirement==0){
	        
	        len=(ei-si < len)? ei-(head=si):len;
	        
	        if(freq[s[si++]]++ ==0)
	        requirement++;
	    }
	}
	
	cout<<len<<"\n";
}

int main(){
vector<int>arr = {4,-3,6,7,2,-8,-9,10,11,12,-19};
seggregate(arr);

for(auto ele: arr)
cout<<ele<<" ,";

cout<<"\n";
return 0;
}