#include <bits/stdc++.h>
using namespace std;


//Next Greater Element to Right ---> returns a vector of indices
// https://practice.geeksforgeeks.org/problems/next-larger-element/0#

vector<int> nger(vector<int> &arr){

int n=arr.size();
vector<int> ans(n,n);// we already initialize the vector with a legitmate default value so that we don't need to 
                      // vacate the remaining elements from the stack

stack<int> st;
for(int i=0;i<n;i++){
while(st.size()!=0 && arr[st.top()]<arr[i])
{
    ans[st.top()]=i;
    st.pop();
}
st.push(i);
}
return ans;
}

//Next Greater Element to Left ---> returns a vector of indices

vector<int> ngel(vector<int> &arr){

int n=arr.size();
vector<int> ans(n,-1);// we already initialize the vector with a legitmate default value so that we don't need to 
                      // vacate the remaining elements from the stack

stack<int> st;
for(int i=n-1;i>=0;i--){
while(st.size()!=0 && arr[st.top()]<arr[i])
{
    ans[st.top()]=i;
    st.pop();
}
st.push(i);
}
return ans;
}

//Next Smaller Element to Right ---> returns a vector of indices

vector<int> nser(vector<int> &arr){

int n=arr.size();
vector<int> ans(n,n);// we already initialize the vector with a legitmate default value so that we don't need to 
                      // vacate the remaining elements from the stack

stack<int> st;
for(int i=0; i<n ; i++){
while(st.size()!=0 && arr[st.top()]>arr[i])
{
    ans[st.top()]=i;
    st.pop();
}
st.push(i);
}
return ans;
}

//Next Smaller Element to Left ---> returns a vector of indices

vector<int> nsel(vector<int> &arr){

int n=arr.size();
vector<int> ans(n,-1);// we already initialize the vector with a legitmate default value so that we don't need to 
                      // vacate the remaining elements from the stack

stack<int> st;
for(int i=n-1;i>=0;i--){
while(st.size()!=0 && arr[st.top()]>arr[i])
{
    ans[st.top()]=i;
    st.pop();
}
st.push(i);
}
return ans;
}

// Leetcode 20:- Valid Parenthesis

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets. Open brackets must be closed in the correct order.
 
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true
*/

    bool isValid(string s) {
        
        stack<char> st;
        
        for(char c: s){
            if(c=='(' || c=='{' || c=='[')
            st.push(c);
            else if(c==')'){
            if(st.size()!=0 && st.top()=='(')
                st.pop();
                else
                    return false;
            }
            else if(c=='}'){
                if(st.size()!=0 && st.top()=='{')
                    st.pop();
                else
                    return false;
            }
            else if(c==']'){
                if(st.size()!=0 && st.top()=='[')
                    st.pop();
                else
                    return false;
            }
            }
            return st.size()==0;
    }

// Leetcode 503:- Next Greater Element II

/*
Given a circular array (the next element of the last element is the first element of the array),
print the Next Greater Number for every element. \
The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. 
If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
*/
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n=nums.size();
        vector<int> ans(n,-1);
        
        stack<int> st;
        for(int i= 0; i< 2*n; i++){
            while(st.size()!=0 && nums[st.top()]<nums[i%n]){
                ans[st.top()]=nums[i%n];
                st.pop();
            }
            
            if(i<n)
                st.push(i);
        }
        return ans;
    }

// Leetcode 946:- Validate Stack Sequences
/*
Given two sequences pushed and popped with distinct values, 
return true if and only if this could have been the result of a sequence of push and pop operations 
on an initially empty stack.

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
*/

    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
       
        int n=pushed.size();
        int idx=0;
        stack<int> st;
        for(int i =0;i< n;i++ ){
            st.push(pushed[i]);
            while(st.size()!=0 && popped[idx]==st.top()){
                st.pop();idx++;
            }
        }
        
        return st.size()==0;
    }

int main(int argc, const char** argv) {
    
    vector<int> ar={2,1,3,4,3,2,1};
    vector<int> ans1=nger(ar);
    vector<int> ans2=ngel(ar);
    vector<int> ans3=nser(ar);
    vector<int> ans4=nsel(ar);
    for(auto i: ans1)
    cout<<i<<" ";
    cout<<"\n";
    for(auto i: ans2)
    cout<<i<<" ";
    cout<<"\n";
        for(auto i: ans3)
    cout<<i<<" ";
    cout<<"\n";
        for(auto i: ans4)
    cout<<i<<" ";
    cout<<"\n";
    return 0;
}