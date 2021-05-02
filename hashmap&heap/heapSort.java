public class heapSort{

// Time:- O(n) + O(nlogn)
// Space:- O(1) (exclude recursive space)

    private static boolean compareTo(int arr[],boolean isIncreasing,int i,int j){
        if(isIncreasing)
            return arr[i] > arr[j];
        else
            return arr[i] < arr[j];
    }

    private static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void downHeapify(int arr[],int pi,boolean isIncreasing,int li){
        int maxIdx = pi;
        int lci = 2*pi + 1;
        int rci = 2*pi + 2;

        if(lci <= li && compareTo(arr,isIncreasing,lci,maxIdx))
            maxIdx = lci;
        if(rci <= li && compareTo(arr,isIncreasing,rci,maxIdx))
            maxIdx = rci;

        if(pi != maxIdx){
            swap(arr,pi,maxIdx);
            downHeapify(arr,maxIdx,isIncreasing,li);
        }
    }

    public static void heapSortt(int arr[],boolean isIncreasing){
        int li = arr.length-1;

        // create a heap
        for(int i = li;i>=0;i--)
            downHeapify(arr,i,isIncreasing,li);
        
        while(li >= 0){
            swap(arr,0,li--);
            downHeapify(arr,0,isIncreasing,li);
        }
    }

    public static void main(String args[]){
        int arr[] = {10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};
        heapSortt(arr,false);

        for(int ele: arr)
            System.out.println(ele);
    }
}