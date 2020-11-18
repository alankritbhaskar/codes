#include <iostream>
#include <vector>
#include <stack>
#include <map>
#include <algorithm>

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

// Leetcode 1021: Remove Outermost Parenthesis

/*
Input: "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
*/

// Using O(1) space
    
    string removeOuterParentheses(string s) {
        
        string ans="";
        int count=0;
        
        for(char c: s){
            if(c=='(' && count++>0)
            ans+=c;
            if(c==')' && count-->1)
            ans+=c;
        } 
        return ans;
    }
    
// Using O(n) space
    string removeOuterParentheses(string s) {
      string ans="";
      stack<char> st;
      
      for(char c: s){
          if(c=='(' && st.size()>0){
              st.push(c);
              ans+=c;
          }
          else if(c=='(' && st.size()==0){
              st.push(c);
          }
          else if(c==')' && st.size()==1){
              st.pop();
          }
          if(c==')' && st.size()>1){
              st.pop();
              ans+=c;
          }
      }
     return ans;
    }

// Leetcode 1249:- Minimum Remove to Make Valid Parenthesis
/*
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
*/

    string minRemoveToMakeValid(string s) {
        
        string ans="";
        stack<int> st;
        
        for(int i=0;i<s.length();i++){
            char c=s[i];
            if(c==')'){
              if(st.size()!=0)
                st.pop();
              else
                  s[i]='#';                
            }
            if(c=='(')
                st.push(i);
        }

        // only opening brackets left in stack
        while(st.size()!=0){
            s[st.top()]='#';
            st.pop();
        }
        
        for(char c: s){
            if(c!='#')
                ans+=c;
        }
        
        return ans;
    }

// Leetcode 1027:- Remove All Adjacent Duplicates in a String
/*
Eg:-
I/P:- abbaca
O/P:- ca
*/

    string removeDuplicates(string s) {
        string ans="";
        stack<char> st;
        
        for(char c: s){
          
            if(st.size()==0)
                st.push(c);
            else if(st.top()==c)
                st.pop();
            else if(st.top()!=c)
                st.push(c);
        }
        
        while(st.size()!=0)
        {
            ans+=st.top();
            st.pop();
        }
    
        reverse(ans.begin(),ans.end());
        return ans;
    }

// Leetcode 496:- Next Greater Element-1
/*
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
*/

    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        map<int,int> mp;
        stack<int> st;
        int n=nums2.size();
        int m=nums1.size();
        vector<int> ans(m,-1);
        
        for (int i=0;i<n;i++) {
            while (st.size() && st.top()<nums2[i]) {
                mp[st.top()]=nums2[i];
                st.pop();
            }
            st.push(nums2[i]);
        }
        
        for(int i=0;i<m;i++){
            int e=nums1[i];
            if(mp.find(e)!=mp.end()){
                ans[i]=mp.find(e)->second;
            }
        }
        return ans;
    }

// Leetcode 32:- Longest Valid Parenthesis
/*
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
*/

    int longestValidParentheses(string s) {
       stack<int> st;
       st.push(-1);
       
       int len=0;
       for(int i=0;i<s.length();i++){
           if(st.top()!=-1 && s[st.top()]=='(' && s[i]==')'){
            st.pop();
            len=max(len,i-st.top());
           }
          else
            st.push(i);
       }
        return len;
    }

// 901. Online Stock Span

/*
Write a class StockSpanner which collects daily price quotes for some stock, 
and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days 
(starting from today and going backwards) for which the price of the stock was less than 
or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], 
then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
*/

class StockSpanner {
public:
    stack<pair<int,int>> st;
    int idx=0;
    StockSpanner() {
       st.push({-1,-1}); 
    }
    
    int next(int price) {
        while(st.top().first!=-1 && st.top().second<=price)
            st.pop();
        int span=idx-st.top().first;
        st.push({idx++,price});
        return span;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */


// Leetcode 84:- Largest Area Histogram/Rectangle

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Example:

Input: [2,1,5,6,2,3]
Output: 10
*/
    
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
    
    
int largestRectangleArea(vector<int>& heights) {
    vector<int> left=nsel(heights);
    vector<int> right=nser(heights);
    int curr=0;
    int mx=0;
    for(int i=0;i<left.size();i++){
        curr=(right[i]-left[i]-1)*heights[i];// width=right-left-1(exclusive boundaries)
        // height=heights[i]
        mx=max(mx,curr);
    }
    
    return mx;
    }

int largestRectangleArea(vector<int> &heights)
{
    int n = heights.size();
    stack<int> st;
    st.push(-1);

    int area = 0;
    for (int i = 0; i < n; i++)
    {
        while (st.top() != -1 && heights[st.top()] >= heights[i])
        {
            int h = heights[st.top()];
            st.pop();

            int w = i - st.top() - 1;
            area = max(area, h * w);
        }
        st.push(i);
    }

    while (st.size() != 1)
    {
        int h = heights[st.top()];
        st.pop();

        int w = n - st.top() - 1;
        area = max(area, h * w);
    }

    return area;
}

// Leetcode 85:- Maximal Rectangle

/*
Given a rows x cols binary matrix filled with 0's and 1's, 
find the largest rectangle containing only 1's and return its area.

Example:-

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
*/

    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.size()==0 || matrix[0].size()==0)
            return 0;
        int n=matrix.size();int m=matrix[0].size();
        
        vector<int> arr(m,0);
        int area=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[j]=matrix[i][j]=='1'?arr[j]+1:0;
            }
            area=max(area,largestRectangleArea(arr));
        }
        return area;
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
    
    
int largestRectangleArea(vector<int>& heights) {
    vector<int> left=nsel(heights);
    vector<int> right=nser(heights);
    int curr=0;
    int mx=0;
    for(int i=0;i<left.size();i++){
        curr=(right[i]-left[i]-1)*heights[i];// width=right-left-1(exclusive boundaries)
        // height=heights[i]
        mx=max(mx,curr);
    }
    
    return mx;
    }

// Leetcode 155. Min Stack

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]
*/

// Method 1:- Using 2n space---> using pair of stack

class MinStack {
public:
    /** initialize your data structure here. */
    stack<pair<long,long>> st;
    
    MinStack() {
       
    }
    
    void push(int x) {
     if(st.size()==0)
         st.push({x,x});
      else if(x>=st.top().second)
          st.push({x,st.top().second});
        else
            st.push({x,x});
    }
    
    void pop() {
        if(st.size()!=0)
            st.pop();
    }
    
    int top() {
        return st.top().first;
    }
    
    int getMin() {
            return st.top().second;
    }
};

// Method 2:- Using exact n space i.e. using encoding

class MinStack {
public:
    /** initialize your data structure here. */
    stack<long> st;
    long minEle=0;// global variable for minimum
    
    MinStack() {
       
    }
    
    void push(int x) {
     if(st.size()==0){
         st.push(x);
         minEle=x;
         return;
     }
        
     if(x>=minEle)
         st.push(x);
     else{
         st.push((x-minEle)+x);
         minEle=x;
     }
    }
    
    void pop() {
    
    long ele=st.top(); 
    if(ele<minEle){
            minEle =(minEle-ele)+minEle;
    }
        st.pop();
    }
    
    int top() {
        
       if(st.top()<minEle)
           return (int)minEle;
        
       return (int)st.top(); 
    }
    
    int getMin() {
            return (int)minEle;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */



// Leetcode 402:- Remove k digits
/*
Given a non-negative integer num represented as a string, remove k digits from the number 
so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
*/

string removeKdigits(string num, int k) {
        string ans="";
        stack<char> st;
        for(char c: num){
            while(st.size()>0 && (int)(st.top()-'0')>(int)(c-'0') && k>0){
                st.pop();k--;
            }
            if(st.size()==0 && c=='0')
                continue;
            
            st.push(c);
            }
        while(k-->0 && st.size()>0)
            st.pop();
        
        while(st.size()>0){
            char e=st.top();
            ans+=e;
            st.pop();
        }
        reverse(ans.begin(),ans.end());
        return (ans.length()==0)?"0":ans;
    }

// Leetcode 316:- Remove Duplicate Letters

 string removeDuplicateLetters(string s)
{
    if (s.length() == 0)
        return s;

    int n = s.length();
    vector<int> freq(26, 0);
    vector<bool> vis(26, false);

    for (char ch : s)
        freq[ch - 'a']++;

    string st = ""; // could be alternatively done using stack, linkedlist, vector, StringBuilder in Java
    for (char ch : s)
    {

        freq[ch - 'a']--;

        if (vis[ch - 'a'])
            continue;

        while (st.length() != 0 && st.back() > ch && freq[st.back() - 'a'] > 0)
        {
            vis[st.back() - 'a'] = false;
            st.pop_back();
        }

        vis[ch - 'a'] = true;
        st += ch;
    }

    return st;
}

// Leetcode 1081- 1081. Smallest Subsequence of Distinct Characters
/*
Return the lexicographically smallest subsequence of s that contains all the distinct characters of s 
exactly once.

Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/

Example 1:

Input: s = "bcabc"
Output: "abc"
*/

        string smallestSubsequence(string s) {
        if(s.length()==0)
        return s;

        vector<int> freq(26,0);
        vector<bool> vis(26,false);
        stack<char> st;

        for(char ch: s)
        freq[ch-'a']++;

        for(char ch: s){
            freq[ch-'a']--;

            if(vis[ch-'a'])
            continue;

            while(st.size()!=0 && st.top()>ch && freq[st.top()-'a']>0){
                vis[st.top()-'a']=false;
                st.pop();
            }

            vis[ch-'a']=true;
            st.push(ch);
        }
        
        string ans="";
        while(st.size()>0){
            ans+=st.top();
            st.pop();
        }

        reverse(ans.begin(),ans.end());
        return ans;
    }

// Leetcode 1441:- Build an Array With Stack Operations
/*
Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

Push: Read a new element from the beginning list, and push it in the array.
Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.

Return the operations to build the target array.

Example 1:

Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
*/

    vector<string> buildArray(vector<int>& target, int n) {
      vector<string > operations;
      int ind=0;
      
      for(int e=1;e<=n;e++){
          if(ind==target.size())break;
          if(target[ind]==e){
             
              operations.push_back("Push");
              ind++;
          }
          else if(target[ind]!=e){
              operations.push_back("Push");
              operations.push_back("Pop");
          }
      }
        return operations;
    }

// Leetcode 921:- Minimum Add to Make Parenthesis Valid
/*
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', 
and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses 
we must add to make the resulting string valid.

Example 1:

Input: "())"
Output: 1
*/
    
    int minAddToMakeValid(string s) {
    stack<char> st;
    for(char ch: s){
        if(st.size()!=0 && st.top()=='(' && ch==')')
        st.pop();
        else
        st.push(ch);
    }
        return st.size();
    }

// Leetcode 753:- Asteroid Collision
/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, 
and the sign represents its direction (positive meaning right, negative meaning left). 
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
*/

    vector<int> asteroidCollision(vector<int>& asteroids) {
    vector<int> st;
    int f=0;
    for(int e: asteroids){
        if(e>0)
            st.push_back(e);
        else{
            while(st.size()!=0 && st.back()>0 && st.back()<-e)
                st.pop_back();
            
            if(st.size()!=0 && st.back()==-e)
                st.pop_back();
            
            else if(st.size()==0 || st.back()<0)
                st.push_back(e);
            
            else{
                // don't push in stack the negative no. i.e. the asteroid gets destroyed
            }
        }
    }
        return st;
    }

// Leetcode 42:- Trapping Rainwater

// Thought:- Mere(i.e. block) upar kitna water store ho sakta hai, i need to find out that
                     //  ----->  = min(max. greater to me in left, max. greater to me in right) - my height 

int trap01(vector<int>& height) {
        if(height.size()==0)
            return 0;
        int n=height.size();
        vector<int> leftMax(n,height[0]);
        vector<int> rightMax(n,height[n-1]);
        
        int left=height[0];
        for(int i=1;i<n;i++){
            if(left>height[i])
                leftMax[i]=left;
            else{
                leftMax[i]=height[i];
                left=height[i];
            }
        }
        
        int right=height[n-1];
        for(int i=n-1;i>=0;i--){
            if(right>height[i])
                rightMax[i]=right;
            else{
                rightMax[i]=height[i];
                right=height[i];
            }   
        }
        
        int totalWater=0;
        for(int i=0;i<n;i++){
            totalWater+=min(leftMax[i],rightMax[i])-height[i];
        }
        return totalWater;   
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