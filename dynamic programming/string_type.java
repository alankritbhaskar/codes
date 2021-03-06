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

// Leetcode 392:- Is subsequence 

    public boolean isSubsequence(String s, String t) {
        
        int n=s.length();int m=t.length();
        boolean dp[][]=new boolean[n+1][m+1];
        
        for(boolean d[]: dp)
            Arrays.fill(d,false);
        
        boolean ans=isSubseq(s,t,n,m,dp);
        return ans;
    }
    
    public boolean isSubseq(String s,String t,int n,int m,boolean dp[][]){
        
        if(n==0 || m==0)
            return dp[n][m]=(n==0)?true:false;
        
        if(dp[n][m]!=false)
            return dp[n][m];
        
        boolean res=false;
        if(s.charAt(n-1)==t.charAt(m-1)){
            res=isSubseq(s,t,n-1,m-1,dp);
        }
        else
            res=isSubseq(s,t,n,m-1,dp);
        
        return dp[n][m]=res;
    }

// Leetcode 115:- Distinct Subsequences

    public int numDistinct(String s, String t) {
      int n=s.length();
      int m=t.length();
      int dp[][]=new int[n+1][m+1];
      
      for(int d[]: dp)
          Arrays.fill(d,-1);
        
      // int ans=distinctMemo(s,t,n,m,dp);
      int ans=distinctDP(s,t,n,m,dp);
      return ans;
    }
    
     public int distinctDP(String s,String t,int N,int M,int dp[][]){
        
        for(int n=0;n<=s.length();n++){
        
            for(int m=0;m<=t.length();m++){
        
        if(m == 0){
            dp[n][m] = 1;
            continue;
        }

        if(n < m){
            dp[n][m] = 0;
            continue;
        }
        
        
        int count=0,c1=0,c2=0;
        if(s.charAt(n-1)==t.charAt(m-1)){
            
        //count=fn(s,t,n-1,m-1,dp)+fn(s,t,n-1,m)
            
        c1=dp[n-1][m-1];//distinctMemo(s,t,n-1,m-1,dp);
        c2=dp[n-1][m];//distinctMemo(s,t,n-1,m,dp);
            
        count+=c1+c2;
        }
        else{
            
        //count=fn(s,t,n-1,m)
            
        c1=dp[n-1][m];//distinctMemo(s,t,n-1,m,dp);
        count+=c1;
    }
         dp[n][m]=count;
            }
        }
         return dp[N][M];
}
    
    public int distinctMemo(String s,String t,int n,int m,int dp[][]){
        
        if(m == 0){
            return dp[n][m] = 1;
        }

        if(n < m){
            return dp[n][m] = 0;
        }
        
            
        
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        int count=0,c1=0,c2=0;
        if(s.charAt(n-1)==t.charAt(m-1)){
            
        //count=fn(s,t,n-1,m-1,dp)+fn(s,t,n-1,m)
            
        c1=distinctMemo(s,t,n-1,m-1,dp);
        c2=distinctMemo(s,t,n-1,m,dp);
            
        count+=c1+c2;
        }
        else{
            
        //count=fn(s,t,n-1,m)
            
        c1=distinctMemo(s,t,n-1,m,dp);
        count+=c1;
    }
        return dp[n][m]=count;
}

// GFG:- Count All Palindromic Subsequences..... https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1

    int countPS(String str)
    {
        int n=str.length();
        int dp[][]=new int[n][n];
        
        for(int d[]: dp)
        Arrays.fill(d,-1);
        
        int ans=countPalindromicSubMemo(0,n-1,dp,str);
        return ans;
    }
    
    
    int countPalindromicSubDP(int SI,int EI,int dp[][],String s){
        
        for(int gap=0;gap<s.length();gap++){
            for(int si=0,ei=gap;ei<s.length();si++,ei++){
                
        if(si==ei)
        {
            dp[si][ei]=1;
            continue;
        }
        
        else if(Math.abs(si-ei)==1)
        {
            if(s.charAt(si)==s.charAt(ei))
            {
                dp[si][ei]=3;
                continue;
            }
            else{
            dp[si][ei]=2;
            continue;
            }
        }
        
        
        int c=0;
        if(s.charAt(si)==s.charAt(ei)){
       
        // count= x+1+y+z-(x)=y+z+1 ...... here, when we check the count then we can see a total of x common terms
        
        // c+=countPalindromicSubMemo(si+1,ei-1,dp,s);
        c+=countPalindromicSubMemo(si,ei-1,dp,s);
        c+=countPalindromicSubMemo(si+1,ei,dp,s);
        c++;
        }
        else{
        // count= y+z-x ...... x terms are common in y and z calls
        
        c+=countPalindromicSubMemo(si,ei-1,dp,s);
        c+=countPalindromicSubMemo(si+1,ei,dp,s);
        c-=countPalindromicSubMemo(si+1,ei-1,dp,s);
        }
        
        dp[si][ei]=c;
         }
        }
        return dp[SI][EI];
    }
    
    int countPalindromicSubMemo(int si,int ei,int dp[][],String s){
        
        if(si==ei)
        return dp[si][ei]=1;
        
        else if(Math.abs(si-ei)==1)
        {
            if(s.charAt(si)==s.charAt(ei))
            return dp[si][ei]=3;
            else
            return dp[si][ei]=2;
        }
        
        if(dp[si][ei]!=-1)
        return dp[si][ei];
        
        int c=0;
        if(s.charAt(si)==s.charAt(ei)){
       
        // count= x+1+y+z-(x)=y+z+1 ...... here, when we check the count then we can see a total of x common terms
        
        // c+=countPalindromicSubMemo(si+1,ei-1,dp,s);
        c+=countPalindromicSubMemo(si,ei-1,dp,s);
        c+=countPalindromicSubMemo(si+1,ei,dp,s);
        c++;
        }
        else{
        // count= y+z-x ...... x terms are common in y and z calls
        
        c+=countPalindromicSubMemo(si,ei-1,dp,s);
        c+=countPalindromicSubMemo(si+1,ei,dp,s);
        c-=countPalindromicSubMemo(si+1,ei-1,dp,s);
        }
        
        return dp[si][ei]=c;
    }


// Leetcode 1143:- Longest Common Subsequence

    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();int n=text2.length();
        int dp[][]=new int[m+1][n+1];
        
        for(int d[]: dp)
            Arrays.fill(d,-1);
        
        // int ans=lcsMemo(text1,text2,m,n,dp);
       // int ans=lcsDP(text1,text2,m,n,dp);
        //print2D(dp);
        int ans=lcsOpti(text1,text2);
        return ans;
    }
    
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

// lcs() knows how to return the length  of longest common subseq in the strings passed

    public int lcsMemo(String s,String t,int m,int n,int dp[][])     {
        

        if(m==0 || n==0)
            return dp[m][n]=0;// since, length in either case will be 0
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        int c=0,c1=0,c2=0;
        if(s.charAt(m-1)==t.charAt(n-1))
            c+=1+lcsMemo(s,t,m-1,n-1,dp);
        else{
            c1=lcsMemo(s,t,m-1,n,dp);
            c2=lcsMemo(s,t,m,n-1,dp);
            c+=Math.max(c1,c2);
    }
        return dp[m][n]=c;
}
    
public int lcsDP(String s,String t,int M,int N,int dp[][]){
        
        for(int m=0;m<=s.length();m++){
            for(int n=0;n<=t.length();n++){
               
        if(m==0 || n==0)
        {
            dp[m][n]=0;
            continue;
        }
        
        
        int c=0,c1=0,c2=0;
        if(s.charAt(m-1)==t.charAt(n-1))
            c+=1+lcsMemo(s,t,m-1,n-1,dp);
        else{
            c1=lcsMemo(s,t,m-1,n,dp);
            c2=lcsMemo(s,t,m,n-1,dp);
            c+=Math.max(c1,c2);
            }
         dp[m][n]=c;
              }    
            }
        return dp[M][N];
        }
    
public int lcsOpti(String s,String t){
    
        // Find lengths of two strings 
        int m = s.length(), n = t.length(); 
      
        int dp[][] = new int[2][n+1]; 
 
        int ind=0; 
      
        for (int i = 0; i <= m; i++) 
        { 
            if(ind%2==0)
                ind=1;
            else
                ind=0; 
            for (int j = 0; j <= n; j++) 
            { 
                if (i == 0 || j == 0) 
                    dp[ind][j] = 0; 
      
                else if (s.charAt(i - 1) ==  
                         t.charAt(j - 1)) 
                    dp[ind][j] = dp[1-ind][j - 1]+ 1; 
      
                else
                    dp[ind][j] = Math.max(dp[1 -ind][j],  
                                        dp[ind][j - 1]); 
            } 
        } 
        
        return dp[ind][n]; 
    }

// Longest Repeated Subsequences... https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence/0#


int lcs(string &s,string &t,int m,int n,vector<vector<int>> &dp){
    if(m==0 || n==0)
    return dp[m][n]=0;
    
    if(dp[m][n]!=-1)
    return dp[m][n];
    
    int l=0;
    if(s[m-1]==t[n-1] && m != n)
    l=lcs(s,t,m-1,n-1,dp)+1;
    else
    l= max(lcs(s,t,m-1,n,dp),lcs(s,t,m,n-1,dp));
    
    return dp[m][n]=l;
}
int main()
 {
		int t;cin>>t;
	    while(t-->0){
	        int m;
	        cin>>m;
	        string str1;
	        cin>>str1;
	        vector<vector<int>> dp(m+1,vector<int>(m+1,-1));
	        int ans=lcs(str1,str1,m,m,dp);
	        cout<<ans<<"\n";
	    }
	return 0;
}

// Leetcode 1035:- Uncrossed Lines

public int maxUncrossedLines(int[] A, int[] B) {
    
    int m=A.length;int n=B.length;
    int dp[][]=new int[m+1][n+1];
    for(int d[]: dp)
        Arrays.fill(d,-1);
        
    // int ans=uncrossedMemo(A,B,m,n,dp);
        int ans=uncrossedDP(A,B,m,n,dp);
    return ans;
    }
    public int uncrossedDP(int a[],int b[],int M,int N,int dp[][]){
       
        for(int m=0;m<=a.length;m++){
            for(int n=0;n<=b.length;n++){
                
        if(m==0 || n==0)
        {dp[m][n]=0;
         continue;
        }
                

        int c=0;
        if(a[m-1]==b[n-1])
            c+=1+dp[m-1][n-1];//uncrossedMemo(a,b,m-1,n-1,dp);
        else{
            c+=Math.max(dp[m-1][n],dp[m][n-1]);
        }
        dp[m][n]=c;        
                }
        }
        return dp[M][N];
        }

    public int uncrossedMemo(int a[],int b[],int m,int n,int dp[][]){
        
       if(m==0 || n==0)
            return dp[m][n]=0;
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        int c=0;
        if(a[m-1]==b[n-1])
            c+=1+uncrossedMemo(a,b,m-1,n-1,dp);
        else{
            c+=Math.max(uncrossedMemo(a,b,m,n-1,dp ),uncrossedMemo(a,b,m-1,n,dp));
        }
        return dp[m][n]=c;
        
    }

// Leetcode 1458. Max Dot Product of Two Subsequences

    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        
        vector<vector<int>> dp(m+1,vector<int>(n+1,-(int)1e8));
            // since, dp we need to find max dot product so fill dp with -Inf
            
        int ans = maxDot(nums1,nums2,m,n,dp);
        return ans;
    }
    
    int maxDot(vector<int> &a,vector<int> &b,int m,int n,vector<vector<int>> &dp){
        if(m == 0 || n == 0)
            return dp[m][n] = -(int)1e7;// agar koi vector empty ho jata hai then return a extreme negative value which can't be the part of ans Note : can't return 0 bcoz 0 too can become a max. value.It can't be -(int)1e8 bcoz other it wise it will consider it to be default dp, so it can be any value between -(int)1e6 (constraint) and less than -(int)1e8.
        
        if(dp[m][n] != -(int)1e8)
            return dp[m][n];
        
        // total 4 scenerios bnte hai, max. of all 4 is the reqd. answer ......
        // 1. bas dono arrays mein se last ke dono numbers ko prouct krke max dot product milta hai
        // 2. dono elements ko include krke max product bnta hai
        // 3. first array ke last element ko exclude kr aur second array ke last element ko include krke max bnta hai
        // 4. second array ke last element ko exclude krke and first array ke last element ko include krke max bnta hai
        
        int prodLast = a[m-1]*b[n-1];
        int bothInclude = maxDot(a,b,m-1,n-1,dp)+ prodLast;// the two numbers are producted and rest is passed to faith
        int firstExclude = maxDot(a,b,m-1,n,dp);
        int secondExclude = maxDot(a,b,m,n-1,dp);
        
        return dp[m][n] = max({prodLast,bothInclude,firstExclude,secondExclude});
        
    }

// Leetcode 72:- Edit Distance

    public int minDistance(String word1, String word2) {
      
        int m=word1.length();int n=word2.length();
        
        int dp[][]=new int[m+1][n+1];
        
        for(int d[]: dp)
            Arrays.fill(d,-1);
        
        // int ans=minDistanceMemo(word1,word2,m,n,dp);
        int ans=minDistanceDP(word1,word2,m,n,dp);
        return ans;
    }
    
    public int minDistanceMemo(String s,String t,int m,int n,int dp[][]){
        if(m==0 || n==0){
            return dp[m][n] = m!=0 ? m : n;
        }

    //    if(m == 0 || n == 0){
    //         if(n == 0)
    //             return dp[m][n] = m;
    //         else 
    //             return dp[m][n] = n;
    //         return dp[m][n] = 0;
    //     }
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        int dis=0;
        if(s.charAt(m-1)==t.charAt(n-1)){
            dis=minDistanceMemo(s,t,m-1,n-1,dp);
        }
        else{
            int insert=minDistanceMemo(s,t,m,n-1,dp);
            int remove=minDistanceMemo(s,t,m-1,n,dp);
            int replace=minDistanceMemo(s,t,m-1,n-1,dp);
            dis=1+Math.min(Math.min(insert,remove),replace);
        }
        return dp[m][n]=dis;
    }
    
        public int minDistanceDP(String s,String t,int M,int N,int dp[][]){

        for(int m=0;m<=s.length();m++){
            for(int n=0;n<=t.length();n++){
            
        if(m==0 || n==0){
            dp[m][n] = m!=0 ? m : n;
            continue;
        }
        
       
        int dis=0;
        if(s.charAt(m-1)==t.charAt(n-1)){
            dis=dp[m-1][n-1];//minDistanceMemo(s,t,m-1,n-1,dp);
        }
        else{
            int insert=dp[m][n-1];//minDistanceMemo(s,t,m,n-1,dp);
            int remove=dp[m-1][n];//minDistanceMemo(s,t,m-1,n,dp);
            int replace=dp[m-1][n-1];//minDistanceMemo(s,t,m-1,n-1,dp);
            dis=1+Math.min(Math.min(insert,remove),replace);
             }
     dp[m][n]=dis;
               }
            }
        return dp[M][N];
        }
        
// Leetcode 44:- Wildcard Pattern Matching

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
*/

    public String generateSequence(String s){
        if(s.length()==0)
            return "";
        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(0));
        int i=1;
        
        while(i<s.length()){
            while(i<s.length() && s.charAt(i-1)=='*' &&
                 s.charAt(i)=='*')
                i++;
            if(i<s.length())
                sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
    
    public int wildcard(String s,String p,int m,int n,int dp[][]){
        if(m==0 || n==0){
            if(m==0 && n==0)
                return dp[m][n]=1;
            else if(n==1 && p.charAt(n-1)=='*')
                return dp[m][n]=1;
            return dp[m][n]=0;
        }
    
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        int val=-1;
        
        if(s.charAt(m-1)==p.charAt(n-1) || p.charAt(n-1)=='?')
            val=wildcard(s,p,m-1,n-1,dp);
        else if(p.charAt(n-1)=='*'){
                boolean res=false;
                res=res || (wildcard(s,p,m-1,n,dp)==1);// match a char
                res=res || (wildcard(s,p,m,n-1,dp)==1);// match a empty string
                val=res?1:0;
            }
            else
                val=0;
        return dp[m][n]=val;
    }
    
    public boolean isMatch(String s, String p) {
        p=generateSequence(p);
        int m=s.length();
        int n=p.length();
        
        int dp[][]=new int[m+1][n+1];
        for(int d[]: dp)
            Arrays.fill(d,-1);
        
        boolean ans=(wildcard(s,p,m,n,dp)==1)?true:false;
        return ans;
    }


    public static void main(String args[]){


    }

}

