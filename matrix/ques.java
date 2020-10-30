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

//Leetcode-48: Rotate Matrix

    // Using extra space----
    
    public void rotateExtra(int[][] matrix) {
        int m=matrix.length;int n=matrix[0].length;
        
        int mat[][]=new int[m][n];
        
        for(int j=n-1;j>=0;j--){
            for(int i=0;i<m;i++){
                mat[i][j]=matrix[n-j-1][i];
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=mat[i][j];
            }
        }
    }
    
// Without using extra space----
    
/* clockwise rotate
* first reverse up to down, then swap the symmetry 
* 1 2 3     7 8 9     7 4 1
* 4 5 6  => 4 5 6  => 8 5 2
* 7 8 9     1 2 3     9 6 3
*/
    
/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
    
//CPP:-

// void rotate(vector<vector<int> > &matrix) {
//     reverse(matrix.begin(), matrix.end());
//     for (int i = 0; i < matrix.size(); ++i) {
//         for (int j = i + 1; j < matrix[i].size(); ++j)
//             swap(matrix[i][j], matrix[j][i]);
//     }
// }


// void anti_rotate(vector<vector<int> > &matrix) {
//     for (auto vi : matrix) reverse(vi.begin(), vi.end());
//     for (int i = 0; i < matrix.size(); ++i) {
//         for (int j = i + 1; j < matrix[i].size(); ++j)
//             swap(matrix[i][j], matrix[j][i]);
//     }
// }
    
    void rotate(int matrix[][]){
    
    int sr=0,er=matrix.length-1;
        
    while(sr<er){
        int[] temp = matrix[sr];
        matrix[sr] = matrix[er];
        matrix[er] = temp;
        sr++; 
        er--;
    }

    for(int i = 0; i< matrix.length ; i++){
        for(int j = 0;j < i; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }        
    }

    


    public static void main(String args[]){
        int a[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int ele=10;
        //
    }
}