import java.util.*;

public class cutStrategy{

    public static void print(int ar[]){
        for(int ele: ar)
            System.out.print(ele+" ");
        System.out.println();
    }

    public static void print2D(int arr[][]){
        for(int ar[]: arr)
            print(ar);
        System.out.println();
    }

// GFG:- Matrix Chain Multiplication(MCM) https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

    public static int mcm_memo(int arr[],int si,int ei,int dp[][]){
        if(si+1 == ei) // for single left matrix cost of multiplication is 0
            return dp[si][ei] = 0;

        if(dp[si][ei] != -1)
            return dp[si][ei];
        
        int minCost = (int)1e9;
        for(int cut = si+1; cut < ei; cut++){
            int leftAns = mcm_memo(arr,si,cut,dp);
            int rightAns = mcm_memo(arr,cut,ei,dp);

            int myAns = leftAns+ (arr[si]*arr[cut]*arr[ei]) + rightAns;
            minCost = Math.min(minCost,myAns);
        }

        return dp[si][ei] = minCost;
    }

    public static int mcm_dp(int arr[],int SI,int EI,int dp[][]){
        int n = arr.length;

        // loop similar to the one in palindrome questions 
        for(int gap = 1;gap < n; gap++){
            for(int si = 0,ei = gap;ei < n;si++,ei++){
                if(si+1 == ei){ // for single left matrix cost of multiplication is 0
                 dp[si][ei] = 0;
                 continue;
                }
       
        int minCost = (int)1e9;
        for(int cut = si+1; cut < ei; cut++){
            int leftAns = dp[si][cut];//mcm_memo(arr,si,cut,dp);
            int rightAns = dp[cut][ei];//mcm_memo(arr,cut,ei,dp);

            int myAns = leftAns+ (arr[si]*arr[cut]*arr[ei]) + rightAns;
            minCost = Math.min(minCost,myAns);
        }

        dp[si][ei] = minCost;
        }
        }

        return dp[SI][EI];
    }

// MCM follow up, suppose the cost of each multiplication is 5 rs. & cost of each addition is 8 rs.
// Total cost for matrix creation = (5*q+8(q-1))*p*r
// Assumed total number of multiplications is q and thus no. of addition is one less

    public static int mcm_memo1(int arr[],int si,int ei,int dp[][]){
        if(si+1 == ei) // for single left matrix cost of multiplication is 0
            return dp[si][ei] = 0;

        if(dp[si][ei] != -1)
            return dp[si][ei];
        
        int minCost = (int)1e9;
        for(int cut = si+1; cut < ei; cut++){
            int leftAns = mcm_memo1(arr,si,cut,dp);
            int rightAns = mcm_memo1(arr,cut,ei,dp);

            // q = arr[cut]
            int myAns = leftAns+ (arr[si]*(5*arr[cut]+8*(arr[cut]-1))*arr[ei]) + rightAns;
            minCost = Math.min(minCost,myAns);
        }

        return dp[si][ei] = minCost;
    }

 // https://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/

    public static 


// https://www.geeksforgeeks.org/minimum-maximum-values-expression/

// Faith: - hr cut point pe divide hokar apni min and max values return krdo   
    public static class minMaxPair{
        int minValue = (int)1e9;
        int maxValue = -(int)1e9;

        minMaxPair(){

        }

        minMaxPair(int minValue,int maxValue){
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public static int evaluate(int a,int b,char ch){
        if(ch == '+')
            return a+b;
        else
            return a*b;
    }

// here all the elements are positive constraint(else we would have to do multiple comparisons)

    public static minMaxPair minMaxEvaluation(String str,int si,int ei,minMaxPair dp[][]){
        if(si == ei){
            int val = str.charAt(si) - '0';
            return dp[si][ei] = new minMaxPair(val,val);
        }

        if(dp[si][ei] != null)
            return dp[si][ei];

        minMaxPair myAns = new minMaxPair();
        for(int cut = 1; cut < ei; cut = cut+2){
            minMaxPair leftAns = minMaxEvaluation(str,si,cut-1,dp);
            minMaxPair rightAns = minMaxEvaluation(str,cut+1,ei,dp);

// for both * & +, minValue = minValueLeft (operand) minValueRight
            int minValue = evaluate(leftAns.minValue,rightAns.minValue,str.charAt(cut));
            int maxValue = evaluate(leftAns.maxValue,rightAns.maxValue,str.charAt(cut));

            myAns.minValue = Math.min(myAns.minValue,minValue);
            myAns.maxValue = Math.max(myAns.maxValue,maxValue);
        }

        return dp[si][ei] = myAns;
    }

    public static void MCM(){

        int[] arr = {40,20,30,10,30};
        int n = arr.length;
        int[][] dp = new int[n][n];
        // int  ans = MCM_DP_String(arr,0,n-1,dp);
        for(int d[]: dp)
            Arrays.fill(d,-1);

        int ans = mcm_memo1(arr,0,n-1,dp);
        //int ans=MCM_DP_String(arr,0,n-1,dp);

        print2D(dp);

        System.out.println(ans);
    }

    public static void main(String[] args){
        MCM();
    }

// Boolean Parenthesization




}