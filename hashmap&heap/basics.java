import java.util.*;
public class basics{
    // Complete Binary Tree

    public static int heightOfTree(int arr[],int idx){
        if(idx >= arr.length)
            return -1; // height in number of edges

        int lh = heightOfTree(arr,2*idx+1); // idx of left child
        int rh = heightOfTree(arr,2*idx+2); // idx of right child

        int mine = Math.max(lh,rh)+1; // for mine sake
        return mine;
    }

    public static void main(String args[]){

    }
}