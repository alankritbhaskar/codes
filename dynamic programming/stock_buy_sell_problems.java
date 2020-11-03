import java.util.*;

public class stock_buy_sell_problems{

// Leetcode 121:- Best Time to Buy and Sell Stock

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

// Leetcode 123:- Best Time to Buy and Sell Stock-III

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




public static void main(){

int prices[]={3,2,6,5,0,3};
int fee=100;
int k=2;

}

}