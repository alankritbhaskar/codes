import java.util.*;

public class questions{

// Leetcode 349. Intersection of Arrays - I

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{0};
        
        HashMap<Integer,Integer> h = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int ele: nums1)
            h.put(ele,1);
        
        for(int ele: nums2){
            if(h.containsKey(ele)){
                arr.add(ele);
                h.remove(ele); // to ensure no duplicates, remove from hashmap
            }
        }
        
        int arr1[] = new int[arr.size()];
        int idx = 0;
        
        for(int i = 0;i < arr.size(); i++)
            arr1[idx++] = arr.get(i);
        
        return arr1;  
    }

// Leetcode 350. Intersection of Arrays - II

// Maintain a freq map, from a particular array
// For each element in another array, check whether it exists in the second array or not. If yes then decrease its freq and add in the array. If freq is 1 then finally remove it from HashMap.
    
    public int[] intersect(int[] nums1, int[] nums2) {
     if(nums1.length == 0 || nums2.length == 0)
            return new int[]{0};
        
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int ele: nums1)
            h.put(ele,h.getOrDefault(ele,0)+1);
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int ele: nums2){
            if(h.containsKey(ele)){
                arr.add(ele);
                if(h.get(ele) > 1)
                h.put(ele,h.get(ele)-1);
                else
                h.remove(ele);
            }
        }
        
        int arr1[] = new int[arr.size()];
        int idx = 0;
        
        for(int i = 0;i < arr.size(); i++)
            arr1[idx++] = arr.get(i);
        
        return arr1;        
    }

// Leetcode 128. Longest Consecutive Sequence

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int ele: nums)
            hm.put(ele,1);
        
        int len = 0;
        for(int ele: nums){
            int leftPossibleElement = ele-1;
            int rightPossibleElement = ele+1;
            
            if(!hm.containsKey(ele)){
                // do nothing
            }
            else{
                hm.remove(ele); // to shorten the size of hashmap for efficient searching
                
                while(hm.containsKey(leftPossibleElement)){
                    hm.remove(leftPossibleElement);
                    leftPossibleElement = leftPossibleElement - 1;
                }
                while(hm.containsKey(rightPossibleElement)){
                    hm.remove(rightPossibleElement);
                    rightPossibleElement = rightPossibleElement + 1;
                }
            len = Math.max(len,rightPossibleElement-leftPossibleElement-1);// boundaries are exclusive
            }
        }
        return len;
    }

//

}