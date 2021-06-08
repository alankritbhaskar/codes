import java.util.PriorityQueue;

public class questions{

// Leetcode 251. kth largest element in array

        // O(nlog k)
        
        int findKthLargest(int arr[],int k){
        // In Java, default priority queue is of Min Type
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return a-b;
        }); // Min Priority Queue
        
        for(int ele: nums){
            pq.add(ele);
            if(pq.size() > k)
                pq.remove();
        }
        
        int kthLargest = pq.peek();
        return kthLargest;        
    }

    // int findKthLargest(vector<int>& nums, int k) {
    //     priority_queue<int,vector<int>,greater<int>> pq;
        
    //     for(int ele: nums){
    //         pq.push(ele);
    //         if(pq.size()>k)
    //             pq.pop();
    //     }
    //     return pq.top();
    // }

// O(n) + k*log(n) -> build own pq. k times call downHeapify. Each time it takes log(n) time
// Heap to be built is minHeap

public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void downheapify(int[] arr, int pi, int li) {
        int maxIdx = pi, lci = 2 * pi + 1, rci = 2 * pi + 2;
        if (lci <= li && arr[lci] > arr[maxIdx])
            maxIdx = lci;
        if (rci <= li && arr[rci] > arr[maxIdx])
            maxIdx = rci;
        if (maxIdx != pi) {
            swap(arr, pi, maxIdx);
            downheapify(arr, maxIdx, li);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int li = nums.length - 1;
        for (int i = li; i >= 0; i--)
            downheapify(nums, i, li);

        while (k-- > 1) {
            swap(nums, 0, li--);
            downheapify(nums, 0, li);
        }

        return nums[0];
    }



// Leetcode 703:- kth largest element in a stream

class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>(); // minPQ
    int k = 0;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int ele: nums){
            pq.add(ele);
            if(pq.size() > this.k)
                pq.remove();
        }
    }
    
    public int add(int val) {
        if(pq.size() < this.k)
            pq.add(val);
        else{
            pq.add(val);
            pq.remove();
        }
        return pq.peek();
    }
}

// 378. kth smallest element in a sorted matrix

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
           int r1 = a/m;
           int c1 = a%m;
           int r2 = b/m;
           int c2 = b%m;
            
           return matrix[r1][c1] - matrix[r2][c2]; 
        });// this-other, minPQ -> DEFAULT
        
        for(int i = 0;i < n;i++)
            pq.add(i*m+0); // add the first col. elements in the heap
        
        int ans = 0;
        while(k-- > 0){
            int idx = pq.remove();
            int r = idx/m;
            int c = idx%m;
            
            ans = matrix[r][c];
            
            if(c+1 < m){
                pq.add(r*m+(c+1));
            }
        }
        return ans;
    }

    
}