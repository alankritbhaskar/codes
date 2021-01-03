import java.util.PriorityQueue;

public class questions{

// Leetcode 251. kth largest element in array

    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq=new PriorityQueue<>();//min heap
    
    for(int ele: nums){
            pq.add(ele);
        if(pq.size()>k)
            pq.remove();
        }
        
        return pq.peek();
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

// Leetcode 703:- kth largest element in a stream

class KthLargest {
    
    PriorityQueue<Integer> pq=new PriorityQueue<>();// minHeap
    int K=0;
    
    public KthLargest(int k, int[] nums) {
     this.K=k;
        for(int ele: nums){
            pq.add(ele);
            if(pq.size()>k){
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < this.K)
            pq.add(val);
        else{
            pq.add(val);
            pq.remove();
        }
        return pq.peek();
    }
}


}