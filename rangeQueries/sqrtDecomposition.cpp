#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

vector<int> blocks,arr;
int blockSize = 0;

// O(1)
void update(int idx,int newVal){
    int oldValue = arr[idx];
    arr[idx] = newVal;

    int block = idx/blockSize;
    blocks[block] = blocks[block]-oldValue+newVal;
}

// O(sqrt(n))
int query(int l,int r){
    int sum = 0;

    while(l%blockSize != 0 && l <= r) // leftExtraElements
        sum += arr[l++];
    
    while(l+blockSize <= r){ // complete blocks to be picked up
        sum += blocks[l/blockSize];
        l += blockSize;
    }

    while(l <= r) // rightExtraElements
        sum += arr[l++];

    return sum;
}

void solve(){
    int n;
    cin >> n;

    blockSize = (int)sqrt(n);
    blocks.resize(blockSize+1,0); // so that block size is present as an index int it
    arr.resize(n,0);

    for(int i = 0;i < n;i++){
        cin >> arr[i]; // create array
        blocks[i/blockSize] += arr[i]; // extra space array for sqrtDecomposition
    }

    int q;
    cin >> q;

    while(q--){
        int c;
        cin >> c;
        if(c == 1){
            // query
            int l,r;
            cin>>l>>r;
            cout<<query(l,r)<<"\n";
        }
        else{
            // update
            int idx,val;
            cin>>idx>>val;
            update(idx,val);
        }
    }
}

// 303. Range Sum Query - Immutable

// class NumArray {
    
//     public int arr[];
//     public int prefixSum[];
    
//     public NumArray(int[] nums) {
//         int n = nums.length;
//         arr = new int[n];
//         prefixSum = new int[n];
        
//         for(int i = 0;i < n;i++)
//             arr[i] = nums[i];
        
//         prefixSum[0] = arr[0];
//         for(int i = 1;i < n;i++)
//             prefixSum[i] = prefixSum[i-1] + arr[i];
//     }
    
//     public int sumRange(int left, int right) {
//         int sum = 0;
//         if(left > 0)
//             sum = (prefixSum[right]-prefixSum[left-1]);
//         else
//             sum = prefixSum[right];
//         return sum;
//     }
// }

// 308. Range Sum Query- Immutable

// class NumArray {
// // Sqrt Decomposition -> Query-> O(sqrt(n)), Update-> O(1)
    
//     public int arr[];
//     public int blocks[];
//     public int blockSize = 0;
    
//     public NumArray(int[] nums) {
//         int n = nums.length;
//         blockSize = (int)Math.sqrt(n);
//         //System.out.print(blockSize+",");
//         blocks = new int[(n/blockSize)+1];
//         arr = new int[n];
        
//         for(int i = 0;i < n;i++){
//             arr[i] = nums[i];
//             blocks[i/blockSize] += arr[i];// blocks[i/blockSize] += arr[i]; // extra space array for sqrtDecomposition  
//         }
//     }
    
//     public void update(int index, int newVal) {
//         int oldValue = arr[index];
//         arr[index] = newVal;

//         int block = index/blockSize;
//         blocks[block] = blocks[block]-oldValue+newVal;
//     }
    
//     public int sumRange(int left, int right) {
//         int sum = 0;
        
//         while(left%blockSize != 0 && left<=right) // leftExtraElements
//             sum += arr[left++];
//         while(left+blockSize <= right){ // direct block elements
//             sum += blocks[left/blockSize];
//             left += blockSize;
//         }
//         while(left <= right)
//             sum += arr[left++];
        
//         return sum;
//     }
// }

// Segment Trees

// Query -> O(logn), Update -> O(1)

    // Segment Trees
//     public int st[];
//     public int arr[];
//     public int diff = 0;
    
//     public int constructST(int si,int l,int r){// si- current idx in st[]
//         if(l == r){
//             // leaf nodes
//             st[si] = arr[l];
//             return arr[l];
//         }
//         int mid = (l+r)/2;
//         st[si] = constructST(2*si+1,l,mid)+constructST(2*si+2,mid+1,r);
//         return st[si];
//     }
    
//     public NumArray(int[] nums) {
//         int n = nums.length;
//         int ht = (int)Math.ceil(Math.log(n+1)/Math.log(2)); // ht = log2(n+1)
//         int maxSize = (2 * (int)Math.pow(2,ht)) -1; // 2^h+1 - 1
//         st = new int[maxSize]; // memoryAllocation
//         arr = new int[n];
        
//         for(int i = 0;i < n;i++)
//             arr[i] = nums[i];
            
//         constructST(0,0,n-1);
//     }
    
//     public void updateTree(int si,int sl,int sr,int idx,int diff){
//         if(sl > idx || sr < idx)
//             return;
        
//         st[si] += diff;
        
//         if(sl != sr){
//             int mid = (sl+sr)/2;
//             updateTree(2*si+1,sl,mid,idx,diff);
//             updateTree(2*si+2,mid+1,sr,idx,diff);
//         }
//     }
    
//     public void update(int index, int val) { // O(log n)
//         if(index < 0 || index >= arr.length)
//             return;
        
//         int diff = val - arr[index];
//         arr[index] = val; // O(1) -> orig. array update
        
//         // update the seg Tree
//         updateTree(0,0,arr.length-1,index,diff);
//     }
    
//     public int getSum(int si,int sl,int sr,int l,int r){ //O(log n)
//         if(l <= sl && r >= sr)
//             return st[si];
//         if(sr < l || sl > r)
//             return 0;
        
//         int mid = (sl+sr)/2;
//         return getSum(2*si+1,sl,mid,l,r)+getSum(2*si+2,mid+1,sr,l,r);
//     }
    
//     public int sumRange(int left, int right) {
//         // 3 cases
//         // Total overlap -> l <= sl && r >= sr -> return st[si]
//         // No overlap -> sr < l || sl > r -> return 0
//         // Partial overlap -> pass calls to both childs
        
//         int sum = getSum(0,0,arr.length-1,left,right);
//         return sum;
//     }
// }

// Range Min. Query or Range Max. Query


int main(){
    int t;
    cin >> t;

    while (t--)
    {
        solve();
    }
    return 0;
}
