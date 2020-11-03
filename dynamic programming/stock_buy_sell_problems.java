import java.util.*;

public class stock_buy_sell_problems{

// Leetcode 121:- Best Time to Buy and Sell Stock(single transaction allowed)

public int maxProfit(int[] prices) {
   if(prices.length==0)
      return 0;
        
   int Ti0=0;// initially when no stock is to be bought
   int Ti1=-(int)1e9;
        
   for(int ele: prices){
       Ti0=Math.max(Ti0,Ti1+ele);
       Ti1=Math.max(Ti1,0-ele);
    }
       
    return Ti0;
}

// Leetcode 123:- Best Time to Buy and Sell Stock-III(only 2 transactions allowed)

    public int maxProfit(int[] prices) {
      
    if(prices.length==0)
        return 0;
        
    int Ti10= 0;
    int Ti11= -(int)1e9;
    
    int Ti20= 0;
    int Ti21= -(int)1e9;
        
    for(int price: prices){
        
        Ti20=Math.max(Ti20,Ti21+price);
        Ti21=Math.max(Ti21,Ti10-price);
        
        Ti10=Math.max(Ti10,Ti11+price);
        Ti11=Math.max(Ti11,0 - price);
    }
    return Ti20;
    }

// Leetcode 122:- Best Time to buy and sell stock II (infinite transactions allowed)

    public int maxProfit(int[] prices) {
    
    if(prices.length==0)
      return 0;
        
    int Ti0=0;// initially when no stock is to be bought
    int Ti1=-(int)1e9;
        
    for(int price: prices){
       Ti0=Math.max(Ti0,Ti1 + price);
       Ti1=Math.max(Ti1,Ti0 - price);
    }
       
    return Ti0;
    }

// Leetcode 714:- Best Time to Buy and Sell Stock with Transaction Fee(each time I complete one transaction)

    public int maxProfit(int[] prices, int fee) {
        
        if(prices.length==0)
            return 0;
        
        int Ti0=0;
        int Ti1= -(int)1e9;
        
        for(int price: prices){

            Ti0=Math.max(Ti0,Ti1+price-fee);// I consider buying as a completion of one transaction for me
            
            Ti1=Math.max(Ti1,Ti0-price);
        }
        
        return Ti0;
    }

/* Leetcode 309:- Best Time to Buy and Sell Stock with Cooldown(After you sell your stock,
                you cannot buy stock on next day. (ie, cooldown 1 day))
*/

    public int maxProfit(int[] prices) {
        
        int Ti0= 0;
        int Ti1= -(int)1e9;
        int Ti2= 0;
        
        for(int price: prices){
            
            int temp=Ti0;
            Ti0=Math.max(Ti0,Ti1+price);
            Ti1=Math.max(Ti1,Ti2-price);
            Ti2=temp;
        }
        
        return Ti0;
    }

// Leetcode 188:- Best Time to Buy and Sell Stock IV(at most k transactions allowed)

/*
A profitable transaction takes at least two days (buy at one day and sell at the other, 
provided the buying price is less than the selling price). 
If the length of the prices array is n, the maximum number of profitable transactions is n/2 (integer division).
After that no profitable transaction is possible, which implies the maximum profit will stay the same. 
Therefore the critical value of k is n/2. If the given k is no less than this value, 
i.e., k >= n/2, we can extend k to positive infinity and the problem is equivalent to Case II.

The following is the O(kn) time and O(k) space solution. Without the optimization, 
the code will be met with TLE for large k values.
*/

    public int maxProfit(int k, int[] prices) {
        
        if(prices.length==0)
        return 0;

        if(k>=prices.length/2){

        int Ti0= 0;// initially when no stock is to be bought
        int Ti1= -(int)1e9;
        
        for(int price: prices){
          Ti0=Math.max(Ti0,Ti1 + price);
          Ti1=Math.max(Ti1,Ti0 - price);
        }
        
        return Ti0;
        }

        else{

        int Tik0[]=new int[k+1];
        int Tik1[]=new int[k+1];
        Arrays.fill(Tik1,-(int)1e9);

        for(int price: prices){
            for(int j=k;j>=0;j--){

                Tik0[j]=Math.max(Tik0[j],Tik1[j]+price);
                Tik1[j]=Math.max(Tik1[j],Tik0[j-1]-price);
            }
        }
        
        return Tik0[k];
        }
    }



public static void main(){

int prices[]={3,2,6,5,0,3};
int fee=100;
int k=2;

}

}