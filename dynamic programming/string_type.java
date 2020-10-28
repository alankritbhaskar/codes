import java.util.*;

public class string_type{

    public static void print(int[] arr){
        for(int ele: arr)
          System.out.print(ele + " "); 
        
        System.out.println();
    }

    public static void print2D(int[][] arr){
        for(int[] a: arr)
          print(a);

        System.out.println();
    }

    public static void palindromicSubstring(String str,boolean[][] dp){
        int n = str.length();
        for(int gap = 0;gap < n;gap++){
            for(int i=0,j=gap; j < n;i++,j++){
                if(gap == 0) dp[i][j] = true;
                else if(gap == 1) dp[i][j] = str.charAt(i) == str.charAt(j);
                else dp[i][j] = str.charAt(i) == str.charAt(j)  && dp[i+1][j-1];
            }
        }
    } 


    //Leetcode 647
    public int countSubstrings(String s) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0; 
        for(int gap = 0;gap < n;gap++){
            for(int i=0,j=gap; j < n;i++,j++){
                if(gap == 0) dp[i][j] = true;
                else if(gap == 1) dp[i][j] = str.charAt(i) == str.charAt(j);
                else dp[i][j] = str.charAt(i) == str.charAt(j)  && dp[i+1][j-1];
            
                if(dp[i][j]) count++; 
            }
        }
        return count;
    }

// Leetcode 005:- Longest palindromic substring

    public String longestPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        
        int si = 0,ei = 0,length = 0; // starting index, ending index of longest palindromic susbtring.
        
        for(int gap = 0;gap < n;gap++){
            for(int i=0,j=gap; j < n;i++,j++){

                if(gap == 0)
                dp[i][j] = 1;
                else if(gap == 1 && str.charAt(i) == str.charAt(j)) 
                dp[i][j] = 2;
                else if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] > 0)
                dp[i][j] = dp[i+1][j-1] + 2;
            
                if(dp[i][j] > length){
                    length = dp[i][j];
                    si = i;
                    ei = j;
                } 
            }
        }

        return str.substring(si,ei+1);
    }

// Leetcode 516:- Longest Palindromic Subsequence

    public int longestPalindromeSubseq(String s) {
       int n=s.length();
       
       int dp[][]=new int[n][n];
       int ans=lpsDP(s,0,n-1,dp);
       return ans;
    }
    public int lpsDP(String s,int I,int J,int dp[][]){
        int n=s.length();
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;i<n && j<n;i++,j++){
        
        if(i==j)
        {dp[i][j]=(i==j)?1:0;
         continue;
        }
        
        
        int l=0;
        if(s.charAt(i)==s.charAt(j))
            l=dp[i+1][j-1]+2;
        else
            l=Math.max(dp[i+1][j],dp[i][j-1]);
        
        dp[i][j]=l;
            }
        }
        return dp[I][J];
    }
    public int lps(String s,int i,int j,int dp[][]){
        
        if(i>j || i==j)
            return dp[i][j]=(i==j)?1:0;
        
        if(dp[i][j]>0)
            return dp[i][j];
        
        int l=0;
        if(s.charAt(i)==s.charAt(j))
            l=lps(s,i+1,j-1,dp)+2;
        else
            l=Math.max(lps(s,i+1,j,dp),lps(s,i,j-1,dp));
        
        return dp[i][j]=l;
    }







    public static void main(String args[]){


    }

}

