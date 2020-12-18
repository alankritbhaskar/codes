#include <bits/stdc++.h>

using namespace std;

// Leetcode 74. Search in a 2D matrix

// O(m+n)
    bool searchMatrix1(vector<vector<int>>& matrix, int target) {
    
        if(matrix.size()==0 || matrix[0].size()==0)
            return false;
        
        int m=matrix.size();
        int n=matrix[0].size();
        
        
        int sr=0,sc=n-1;
        while(sr>=0 && sr<m && sc>=0 && sc<n){
            if(matrix[sr][sc]==target)
                return true;
            else if(matrix[sr][sc]<target)
            {
                sr++;
            }
            else{
                sc--;
            }
        }
        return false;   
    }

// O(log(m*n))

// Can be applied on completely sorted matrix
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
    
// Cant' be applied on row wise and column wise sorted matrix
 
     bool searchMatrix(vector<vector<int>>& matrix, int target) {
    
        if(matrix.size()==0 || matrix[0].size()==0)
            return false;
        
        int n=matrix.size();
        int m=matrix[0].size();
        
        
        int si=0,ei=n*m-1;
        
         while(si<=ei){
         
             int mid=(si+ei)/2;
             int val=matrix[mid/m][mid%m];
             
             if(val==target)
                 return true;
             else if(val<target)
                 si=mid+1;
             else
                 ei=mid-1;
         }
         
        return false;   
    }