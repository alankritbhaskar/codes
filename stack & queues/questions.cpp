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