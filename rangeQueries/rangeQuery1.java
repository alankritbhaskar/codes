import java.util.*;

public class rangeQuery1{

// ......... Sqrt decomposition ...........

// indices- 0 1 2  3 4 5 6  7 8
// arr[] = {2,3,1,-1,5,6,8,-3,3}
// n = 9

// blockSize = sqrt(n) = 3
// blocks[] = {6, 10, 8}
// block       0   1  2

// sum(2,7) = 1+10+5 = 16

// Here, update -> O(1)
//       sum    -> O(sqrt(n))

    public int arr[];
    public int blockSize = 0;
    public int blocks[];

// O(1)
    public static void update(int idx,int val){
        // in orig. array
        int delta = val - arr[idx];
        arr[idx] = val;

        blocks[idx/blockSize] += delta;
    }

// O(sqrt(n))
    public static int sum(int l,int r){
        int sum = 0;
        while(l % blockSize != 0 && l <= r) // leftExtraElements
            sum += arr[l++];
        
        while(l+blockSize <= r){ // complete blocks to be picked up
            sum += blocks[l/blockSize];
            l += blockSize;
        }

        while(l <= r) // rightExtraElements
            sum += arr[l++];
    return sum;
    }
    public static void solve(){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    arr = new int[n];
    blockSize = (int)(Math.sqrt(n));
    blocks = new int[(int)(n/blockSize)+1]; // memory Allocation

    for(int i = 0;i < n;i++){
        arr[i] = nums[i];
        blocks[i/blockSize] += arr[i];
    }

    int q = sc.nextInt();

    while(q-- > 0){
        int c = sc.nextInt();
        if(c == 1){
            // query for sum
            int l,r;
            l = sc.nextInt(); r = sc.nextInt();
            System.out.println(sum(l,r));
        }
        else{
            // update
            int idx,val;
            idx = sc.nextInt(); val = sc.nextInt();
            update(idx,val);
        }
    }
    }

// Range Min Query ----> https://practice.geeksforgeeks.org/problems/range-minimum-query/1

class GfG
{
    
    public static int constructST(int arr[],int st[],int si,int l,int r){ 
    if (l == r) // leaf node 
    { 
        st[si] = arr[l]; 
        return arr[l]; 
    } 
  
    int mid = (l+r)/2; 
    st[si] = Math.min(constructST(arr,st,2*si+1,l,mid),constructST(arr,st,2*si+2,mid+1,r)); 
    return st[si]; 
    } 
  
    public static int[] constructST(int arr[], int n)
    {   
        int ht = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        int maxSize = (2*(int)Math.pow(2,ht)) - 1;
        int st[] = new int[maxSize]; // memory allocation to segment tree
        constructST(arr,st,0,0,n-1);
        return st;
    }
    
    
    /* The functions returns the
      min element in the range
      from l and r */
      public static int getMin(int st[],int si,int sl,int sr,int l,int r){
          if(l <= sl && r >= sr)
             return st[si];
          if(sr < l || sl > r)
            return (int)1e8;
          
          int mid = (sl+sr)/2;
          return Math.min(getMin(st,2*si+1,sl,mid,l,r),getMin(st,2*si+2,mid+1,sr,l,r));
      }

     public static int RMQ(int st[], int n, int l, int r){
       if (l < 0 || r > n - 1 || l > r) {
            System.out.println("Invalid Input");
            return -1;
        }
        
       int minVal = getMin(st,0,0,n-1,l,r);
       return minVal;
     }   
}


    public static void main(String args[]){
        solve();
    }

}