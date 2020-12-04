import java.util.*;

public class questions{


// Binary Array Sorting........... https://practice.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1#

    static void swap(int a[],int i,int j){
     int t=a[i];
     a[i]=a[j];
     a[j]=t;
    }
    
    static void binSort(int arr[], int n)
    {
    if(arr.length==0)
    return;

    int pivot=-1; //pivot partitions my array into two parts
    int idx=0;

    while(idx < n){
        if(arr[idx]==0)
            swap(arr,++pivot,idx);
        idx++;
    }
    }

// Leetcode 189. Rotate Array

// Method 1:- Using O(n) extra space

    public void rotate(int[] nums, int k) {
        int b[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
        b[(i+k)%nums.length]=nums[i];
        }
        int ind=0;
        for(int e: b)
            nums[ind++]=e;
    }

// Method 2:- Rotate k right= reverse(0 to n-1)----> reverse(0 to k-1) and reverse(k to n-1)

    static void swap(int a[],int i,int j){
     int t=a[i];
     a[i]=a[j];
     a[j]=t;
    }
    
    public void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i++,j--);
        }
    }

    public void rotate(int[] arr, int k) {
        if(arr.length == 0) return;
        
        int n = arr.length;

        k = (k % n + n) % n;// so that even if k is negative then too mod lies in range 0 to n

        
        reverse(arr,0 , n - 1);
        reverse(arr,0, k - 1);
        reverse(arr, k , n - 1);
    }

     public int maSumInRotation(int[] arr){

        int sum = 0,rotatedSum = 0, n = arr.length;
        
        for(int ele : arr) sum += ele;
     
        for(int i = 0;i<arr.length;i++)  rotatedSum += arr[i] * i;

        int maxSum = rotatedSum;
        // for(int i = 0;i<arr.length - 1;i++)
        //     maxSum = Math.max(maxSum, rotatedSum =  rotatedSum - sum + arr[i] * n);

        for(int i = 0;i<arr.length - 1;i++){
            rotatedSum  = rotatedSum - sum + arr[i] * n;
            maxSum = Math.max(maxSum, rotatedSum - sum + arr[i] * n);
        }

        return maxSum;
    }
}