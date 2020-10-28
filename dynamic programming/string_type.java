import java.util.*;

public class string_type{

// Leetcode 647 Count all palindromic substrings

    public int countSubstrings(String s) {
    int n=s.length();
    boolean dp[][]=new boolean[n][n];
    palindromicSubstring(s,dp);
        int count=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(dp[i][j]==true)
                count++;
        }
    }
        return count;
    }
    public static void palindromicSubstring(String s,boolean dp[][]){
        int n=s.length();
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;i<n&&j<n;i++,j++){
                if(gap==0)
                    dp[i][j]=true;
                else if(gap==1)
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                else
                    dp[i][j]=s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
            }
        }
    }


}