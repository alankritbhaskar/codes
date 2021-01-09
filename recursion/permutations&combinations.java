import java.util.*;

public class permutations&combinations{


// Leetcode 39. Combination Sum

    static List<List<Integer>> myAns;
    static List<Integer> smallAns = new ArrayList<>();
    
    public void combination(int arr[],int idx,int tar){
        
        if(tar == 0 || idx == arr.length){
            if (tar == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                myAns.add(base);
            }
            return;
          }
        
        if(tar-arr[idx] >= 0){
            smallAns.add(arr[idx]);
            combination(arr,idx,tar-arr[idx]); // not idx+1 bcoz same element can be used multiple times
            smallAns.remove(smallAns.size()-1);
        }
        combination(arr,idx+1,tar);
    }
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {
         myAns=new ArrayList<>();
         combination(arr,0,target);
         return myAns;        
    }

// Leetcode 40. Combination Sum II

    vector<int> smallAns;
    vector<vector<int>> myAns;
    
    void combinationUniqueWithDuplicates(vector<int> &arr,int idx,int tar){
    
        if(tar == 0){
            myAns.push_back(smallAns);
            return;
        }
        
        int prev = -1;
        
        for(int i=idx;i<arr.size();i++){
            
            if(prev != -1 && arr[prev]==arr[i])
                continue;
            
            if(tar-arr[i] >= 0){
                smallAns.push_back(arr[i]);
                combinationUniqueWithDuplicates(arr,i+1,tar-arr[i]);
                smallAns.pop_back();
            }
            
            prev = i;
        }
    }
    
    vector<vector<int>> combinationSum2(vector<int>& arr, int target) {
    
        sort(arr.begin(),arr.end());
        combinationUniqueWithDuplicates(arr,0,target);
        return myAns;
        
    }

    
}