  import java.util.*;

  public class coinChange{

   public static int coinChangePermutationInfiSubSeq(int arr[],int tar, String ans)
{
        if (tar == 0)
        {
          System.out.println(ans);
            return 1;
        }

    int count = 0;

    for(int ele: arr){
    if (tar - ele >= 0)
        count += coinChangePermutationInfiSubSeq(arr, tar - ele, ans + ele);
    //count += coinChangePermutationInfiSubSeq(arr,tar,ans);
    }
    return count;
}

    public static void main(String args[]){
     int ar [] = {2,3,5,7};
     int tar = 10;

     coinChangePermutationInfiSubSeq(ar,tar,"");     
       // set3();
    }
  }