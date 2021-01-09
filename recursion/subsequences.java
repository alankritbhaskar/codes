import java.util.*;
public class subsequences{


// Here, at each level of the recvursive tree we have two choices for the element whether we may choose it to be a part o our answer
// or we may not choose this element to be a part of our answer.

// We explore both these possibilities and move deeper into the tree. Thus, we get our answers finally when our base case gets hitted



    public static int subsequence1(int arr[],int idx,String ans){
        if(idx == arr.length)
        {
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;

        count += subsequence1(arr,idx+1,ans); // exclude the element
        count += subsequence1(arr,idx+1,ans+arr[idx]); // include the element
        
        return count;
    }


    public static int subsequence2(int arr[],int idx,String ans){

    System.out.println(ans);

    int count = 0;
   
    for (int i = idx; i < arr.length; i++)
    {
            count += subsequence2(arr, i + 1, ans + arr[i]);
    }

    return count+1;
}

    public static int subsequence3(int arr[])
    {
        int count = 0;
        int N = arr.length;

        for(int i = 0;i < (1 << N); ++i)
        {
            count++;
            for(int j = 0;j < N;++j){
                if((i & (1 << j)) != 0)
                System.out.print(arr[j]);
            }
            System.out.println();
    }
    return count;
    }


    public static void solve(){
        int arr[] = {1,2,3};
        int ans1 = subsequence2(arr,0,"");
       // int ans3 = subsequence3(arr);
        System.out.println(ans1);
    }
    public static void main(String args[]){
        solve();
    }
}