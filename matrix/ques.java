import java.util.*;

public class ques{

// Leetcode- 74: Search in a 2-D matrix

    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        
        int sr=0,sc=n-1;//start from rightmost top corner
        
        //while loop easy padega in comparison to for loop
        
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

// Row with max 1's.......... https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1

// Boundary case:-  I/p- 0 0 0 0 || O/p- -1

	int rowWithMax1s(vector<vector<int> > arr, int n, int m) {
	   
	   int sr=0,sc=m-1;
	   int c=0;int ind=0;
	   
	   while(sr>=0 && sr<n && sc>=0 && sc<m){
	       
	       if(arr[sr][sc]==1)
	       {
	           sc--;c++;ind=sr;
	       }
	       if(arr[sr][sc]==0)
	       {
	           sr++;
	       }
	   }
	   
	   return (c==0)?-1:ind;
	}

// Leetcode-54: Spiral Matrix

// ------------> The same prob. can also be approached using recursion <-------------

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ar=new ArrayList<>();
        
        if(matrix.length==0 || matrix[0].length==0)
            return ar;
        
        int m=matrix.length;int n=matrix[0].length;
        
        int sr=0,sc=0,er=m-1,ec=n-1;
        
        while(sr>=0 && sr<=er && sc>=0 && sc<=ec){
            
            for(int i=sc;i<=ec;i++)
                ar.add(matrix[sr][i]);
            sr++;
            
          for(int i=sr;i<=er;i++)
                ar.add(matrix[i][ec]);
            ec--;
            
        //The only tricky part is that when I traverse left or up I have to check whether the row or col still exists to prevent duplicates. 
            
          if(sr<=er){
          for(int i=ec;i>=sc;i--)
              ar.add(matrix[er][i]);
          er--;
          }
            
           if(sc<=ec){ 
          for(int i=er;i>=sr;i--)
              ar.add(matrix[i][sc]);
            sc++;
        }
        }
        return ar;
    }

// Leetcode-59 : Spiral Matrix-II

// ------------> 1 to n^2 in the matrix 

    public int[][] generateMatrix(int n) {
    
    //Matrix declaration
        
    int matrix[][]=new int[n][n];
    
    int num=1;
        
    int sr=0,sc=0,er=n-1,ec=n-1;
        
    while(sr>=0 && sr<=er && sc>=0 && sc<=ec){
            
       for(int i=sc;i<=ec;i++)
            matrix[sr][i]=num++;
            sr++;
            
       for(int i=sr;i<=er;i++)
            matrix[i][ec]=num++;
            ec--;
            
        //The only tricky part is that when I traverse left or up I have to check whether the row or col still exists to prevent duplicates. 
            
          if(sr<=er){
          for(int i=ec;i>=sc;i--)
              matrix[er][i]=num++;
          er--;
          }
            
           if(sc<=ec){ 
          for(int i=er;i>=sr;i--)
              matrix[i][sc]=num++;
            sc++;
        }
        }
        return matrix;
}




    public static void main(String args[]){
        int a[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int ele=10;
        //
    }
}