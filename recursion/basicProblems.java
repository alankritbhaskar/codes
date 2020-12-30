import java.util.*;
public class basicProblems{

    public static void main(String[] args){
        solve();
    }

// SET 1............................

    public static int fibbonaci(int n){
    if(n <= 1)
    return 1;
    int f = fibbonaci(n-1)+fibbonaci(n-2);
    return f;
    }

    public static void printIncreasing(int a,int b){
    if(a > b)
    return;

    System.out.print(a+" ");

    printIncreasing(a+1,b);
    }

    public static void printDecreasing(int a,int b){
    if(a < b)
    return;

    System.out.print(a+" ");

    printDecreasing(a-1,b);
    }

// Prints odd nos. from b to a in decreasing order and even nos. in increasing order from a to b

    public static void printOddEven(int a,int b){
         if(a == b+1)
         return;

         if(a%2 == 0)
         System.out.println(a);
         printOddEven(a+1,b);
         if(a%2 != 0)
         System.out.println(a);
    }

    public static int factorial(int n){
     return (n == 0)?1:n*factorial(n-1);
    }

//  Faith:- pow(a,b) = pow(a,b-1)*a

    public static int power(int a,int b){
     return (b==0)?1:power(a,b-1)*a;
    }

// Faith:- pow(a,b)= pow(a,b/2)*pow(a,b/2) if b is even 
//                   pow(a,b/2)*pow(a,b/2)*a if b is odd

    public static int powerLogarithmic(int a,int b){
       if (b==0)
            return 1;
        int smallAns = powerLogarithmic(a,b/2);
        smallAns *= smallAns;
        return (b%2)!= 0?smallAns*a:smallAns;
    }

// SET 2(Array Based).............................

    public static void display(int[] arr, int idx) {
        if (idx == arr.length)
        return;

        System.out.println(arr[idx] + " ");
        display(arr, idx + 1);
    }

    public static int maximumElement(int[] arr,int idx){
        if(idx == arr.length) 
        return -(int)1e9;
        
        return Math.max(arr[idx],maximumEle(arr, idx+1));
    }

    public static int minimumEle(int[] arr,int idx){
        if(idx == arr.length)
        return (int)1e9;

        return Math.min(arr[idx],minimumEle(arr, idx+1));
    }

//  First Index
    
    public static int findData(int[] arr,int idx,int data){
        if(idx == arr.length)
        return -1;
        if(arr[idx] == data)
        return idx;
        return findData(arr,idx+1,data);
    }

// Last Index
    public static int findDataLast(int[] arr,int idx,int data){
        if(idx == arr.length)
        return -1;
        int smallAns = findDataLast(arr,idx+1,data);
        
        if(smallAns != -1) 
        return smallAns;

        return arr[idx] == data?idx:-1;
    }

//  Without using arraylist
//  Count no. of elements while going in depth of recursion, place the indices while coming out of recursion

    public static int[] allIndex(int[] arr,int idx,int count,int data){
        if(idx == arr.length){
            return new int[count];
        }

        if(arr[idx] == data)
        count++;
        int smallAns[] = allIndex(arr,idx+1,count,data);
        if(arr[idx] == data)
        smallAns[count-1]=idx;

        return smallAns;
    }

// SET 3 (Medium Problems on Recursion and Backtracking)

    public static ArrayList<String> subsequence(String str,int idx){
     if(str.length() == idx){
         ArrayList<String> base = new ArrayList<>();
         base.add("");
         return base;
     }

     char ch = str.charAt(idx);
     ArrayList<String> smallAns= subsequence(str,idx+1);
     ArrayList<String> myAns= new ArrayList<>();

     for(String s: smallAns){
         myAns.add(s);
         myAns.add(ch+s);
     }

     return myAns;
    }

// Keypad Combination Problem

    static String[] keypad = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    // public static ArrayList <String> getKPC(String str,int idx) {
    
    // }


    public static void set1(){
        // int f = fibbonaci(6);
        // System.out.print(f);
        // printIncreasing(1,15);
        // System.out.println();
        // printDecreasing(15,1);
        printOddEven(1,15);
    }

    public static void set2(){
     int a[]={1,2,3,4};
     int ans=findData(a,2);
     System.out.print(ans);
    }

    public static void set3(){
         return ;
    }

    public static void print(int n){

        if(n==1 || n==0){
            System.out.println("base: "+n);
            return;
        }

        System.out.println("pre: "+n);
        print(n-1);
         System.out.println("in: "+n);
         print(n-2);
          System.out.println("post: "+n);

    }

    public static void solve(){
        set1();
       // set3();
    }

}