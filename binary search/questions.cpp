#include <iostream>
#include <vector>

using namespace std;

// 34. First and last index of element in sorted array

    int firstIndex(vector<int> &arr,int tar){
        int si = 0, ei = arr.size()-1;
        
        while(si <= ei){
            int mid = (si+ei)/2;
            
            if(arr[mid] == tar){
                if(mid-1 >= 0 && arr[mid-1] == tar)
                    ei = mid-1;
                else
                    return mid;
            }
            else if(arr[mid] < tar)
                si = mid+1;
            else
                ei = mid-1;
        }
        return -1;
    }
    
    int lastIndex(vector<int> &arr,int tar){
        int si = 0, ei = arr.size()-1;
        
        while(si <= ei){
            int mid = (si+ei)/2;
            
            if(arr[mid] == tar){
                if(mid+1 < arr.size() && arr[mid+1] == tar)
                    si = mid+1;
                else
                    return mid;
            }
            else if(arr[mid] < tar)
                si = mid+1;
            else
                ei = mid-1;
        }
        return -1;
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0)
            return {-1,-1};
        
        vector<int> ans;
        int fi = firstIndex(nums,target);
        int li = lastIndex(nums,target);
        
        ans.push_back(fi);
        ans.push_back(li);
        
        return ans;
    }