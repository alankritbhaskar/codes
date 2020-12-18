#include <iostream>
#include <bits/stdc++.h>
#include <vector>

using namespace std;


// This File contains a set of questions belonging to sliding window technique..............
// There is a standard template of how this type of problems can be approached. Check it with attention


// Leetcode 003:- Longest Substring Without Repeating Characters
/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
*/

    int lengthOfLongestSubstring(string s) {
        
        int n=s.length();
        if(n <= 1)
            return n;
        
        vector<int> map(128,0);
        int si = 0;// window ki length minimize krta hai
        int ei = 0;// window ki size increase krta till all characters are included in it
        int count = 0;// kitne excess mein characters repeated hai
        int len = 0;
        int maxsi = 0; int maxei=0; // in case we have to return that substring
        
        while (ei < n){
            
            if(map[s[ei++]]++ > 0){ // = 1
                count++; // count increase by 1 means ki koi character repeat ho chuka hai
                   }
            
                // jaise hi count == 1 reduce it to zero by reducing the size using si
                while(count > 0){
                    if(map[s[si++]]-- > 1){
                        count--;
                    }
                }
                
                if(ei-si > len){
                    len = ei-si;
                    maxei=ei;
                    maxsi=si;
                }
            }
        return len;
    }

 // Leetcode 76. Min. Sliding Window

     string minWindow(string s, string t) {
    
        int n = s.length();
        int m = t.length();
        
        vector<int> map(128,0);// it contains freq of elements in t string to be mapped with s
        for(int i=0;i<m;i++){
            map[t[i]]++;
        }
        
        int si=0, ei=0, required=m;// required is the total no. of elements in string left to be mapped in string s
        
        int len=(int)1e8;// for min finding
        int head=0;// for returning string
        
        while(ei < n){
           
            if(map[s[ei++]]-- > 0)
                required--;
            
            while(required == 0)
            {
                if(ei-si < len){
                    len = ei-si;
                    head=si;
                }
                
                if(map[s[si++]]++ == 0) //agar in the process of reducing length using si, map mein freq ke accross value 0 ho jaye then we will be in requirement of that character
                    required++;
            } 
        }
        return len == (int)1e8 ? "" : s.substr(head,len);
    }

// Smallest window that contains all characters of itself..... https://practice.geeksforgeeks.org/problems/smallest-distant-window/0#

int main()
 {
    int t;
    cin>>t;
    
    while(t--){
	string s;
	cin>>s;
	
	int n=s.length();
	vector<int> map(128,0);
	int si=0,ei=0,len=(int)1e8,required=0;// no. of distinct characters in string to be mapped
	
	for(int i=0;i<n;i++) 
	map[s[i]]=1;
	
    for(int ele : map) 
    {
        if(ele == 1)
        required++;
    }

	while(ei<n){
	    
	    if(map[s[ei++]]-- > 0) 
	    required--;
	    
	    while(required==0){
	        
	        len=min(ei-si,len);
	        
	        if(map[s[si++]]++ ==0)
	        required++;
	    }
	}
	
	cout<<len<<"\n";
}
}







