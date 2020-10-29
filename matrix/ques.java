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

    public static void main(String args[]){
        int a[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int ele=10;
        //
    }
}