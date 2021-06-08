#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// Array Basic Questions.......

// Array Rotate

void swap(vector<int> &arr,int i,int j){
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
}

void reverse(vector<int> &arr,int si,int ei){
    while (si < ei){
        swap(arr,si++,ei--);
    }
}

void rotatebyK(vector<int> &arr,int k){
    int n = arr.size();
    
    int r = k;
    // r = r % n;

    // if(r < 0)
    //     r += n;

    r = (r % n + n)%n;
    reverse(arr,0,n-1); // rotate complete array
    reverse(arr,n-r,n-1);
    reverse(arr,0,n-r-1);    
}

// Seggregate positive and negative numbers in an array

// Approach 1:- Sorting, Approach 2:- Count the positive and then extra space for positive and negative nos.

// Approach 3:- Two pointers

void seggregate(vector <int> &arr)
{

if(arr.size()==0)
return;

int si = 0;// positive no. index pointer
int ei = arr.size()-1;// negative no. index pointer

while(si < ei){
    if(arr[si] > 0 && arr[ei] < 0){
        si++;
        ei--;
    }
    else if(arr[si]>0 && arr[ei] >= 0){
        swap(arr[si],arr[ei]);
        si++;
    }
    else if(arr[si] < 0 && arr[ei] < 0){
        swap(arr[si],arr[ei]);
        ei--;
    }
    else{
        swap(arr[si],arr[ei]);
        si++;
        ei--;
    }
}
}

void segregateZeroOne(vector<int> & arr){

    if(arr.size() == 0)
    return;

    int pivot = -1; //pivot partitions my array into two parts
    int idx = 0;
    int n = arr.size();

    while(idx < n){
        if(arr[idx] == 0)
            swap(arr[++pivot],idx);
        idx++;
    }
}

// Leetcode 75. Sort Colours

// Partition as below:-   (zero) (one) (unexplored) (two)
//                        |      |     |            |
//                        0      p1   idx          p2

void sortColors(vector<int>& arr) {
    if(arr.size() == 0)
    return;

    int p1 = -1;
    int idx = 0;
    int n = arr.size();
    int p2 = n-1;

    while(idx <= p2){
        if(arr[idx] == 0)
            swap(arr[++p1],arr[idx++]);  
        else if(arr[idx] == 2)
            swap(arr[p2--],arr[idx]);
        else
        idx++;
    }
}

// Leetcode 283. Move Zeroes

void moveZeroes(vector<int>& arr) {

    if(arr.size()==0)
    return;
    
    int n = arr.size();
    int pivot  = 0; //pivot partitions my array into two parts
    int idx = 0;
    

    while(idx < n){
        if(arr[idx] != 0)
            swap(arr[pivot++],arr[idx]);
        idx++;
    }
}

// https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1#

int max_sum(int arr[],int n){
        int sum = 0, sumWithIndex = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            sumWithIndex += arr[i] * i;
        }

        int maxSum = sumWithIndex;
        for (int i = 1; i < n; i++) {
            sumWithIndex = sumWithIndex - sum + arr[i - 1] * n;
            maxSum = max(maxSum, sumWithIndex);
        }

        return maxSum;
    }

// Leetcode 11. Container with most water

// Two pointer approach
    int maxArea(vector<int>& height) {
        int maxArea = 0;
        int n = height.size();
        int i = 0,j = n-1;
        
        while(i < j){
            int width = j - i;
            int currArea = min(height[i],height[j]) * width;
            if(height[i] < height[j])
                i++;
            else
                j--;
            maxArea = max(maxArea,currArea);
        }
        return maxArea;
    }




//Smallest window that contains all characters of string itself...... https://www.geeksforgeeks.org/smallest-window-contains-characters-string/

/*
Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

Examples:

Input: aabcbcdbca
Output: dbca
*/

// int main()
//  {
//     int t;
//     cin>>t;
    
//     while(t--){
// 	string s;
// 	cin>>s;
	
// 	int n=s.length();
// 	vector<int> freq(128,0);
// 	int si=0,ei=0,head=0,len=(int)1e8,requirement=0;
	
// 	for(int i=0;i<n;i++) freq[s[i]]=1;
	
//     for(int ele : freq) requirement += ele;

// 	while(ei<n){
	    
// 	    if(freq[s[ei++]]-- > 0) requirement--;
	    
// 	    while(requirement==0){
	        
// 	        len=(ei-si < len)? ei-(head=si):len;
	        
// 	        if(freq[s[si++]]++ ==0)
// 	        requirement++;
// 	    }
// 	}
	
// 	cout<<len<<"\n";
// }

int main(){
// vector<int>arr = {4,-3,6,7,2,-8,-9,10,11,12,-19};

vector<int> arr = {9,7,2,8,6,3};
int k = +3;
int k1 = -3;
int k2 = +7;

rotatebyK(arr,k);
// seggregate(arr);

for(auto ele: arr)
cout<<ele<<" ,";

rotatebyK(arr,k1);
// seggregate(arr);

for(auto ele: arr)
cout<<ele<<" ,";
cout<<"\n";

rotatebyK(arr,k2);
// seggregate(arr);

for(auto ele: arr)
cout<<ele<<" ,";

return 0;
}