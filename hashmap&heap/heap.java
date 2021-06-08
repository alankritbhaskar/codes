import java.util.ArrayList;

public class heap{

    private ArrayList<Integer> arr;
    private boolean isMaxHeap = true;

    void defaultValue(boolean isMaxHeap){
        this.arr = new ArrayList<>();
        this.isMaxHeap = isMaxHeap;
    }
    
// Constructors

    // Jo heap bnegi wo maxHeap hogi and usme user ko authority hogi ki wo ek ek krke elements enter kre
    heap(){
        defaultValue(true);
    }

    // Jo heap bnegi wo user decided hogi and usme user ko authority hogi ki wo ek ek krke elements enter kre
    heap(boolean isMaxHeap){
        defaultValue(isMaxHeap);
    }

    // Jo heap bnegi wo user decided heap hogi and usme user ko authority hogi ki wo complete array enter kr ske
    heap(int arr[],boolean isMaxHeap){
        defaultValue(isMaxHeap);
        for(int ele: arr)
            this.arr.add(ele); //I want the changes to be reflected in my arraylist, not of the user
        constructHeap();
    }

    private void swap(int i,int j){
        int temp = this.arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    private void constructHeap(){ // Seems to be O(nlogn) but actually it is O(n)
        for(int i = this.arr.size()-1;i >= 0;i--)
            downHeapify(i); // jao is index ko heap me convert krke lao
    }

// this,other
    private boolean compareTo(int i,int j){
        if(isMaxHeap)
            return this.arr.get(i) > this.arr.get(j);
        else
            return this.arr.get(i) < this.arr.get(j);
    }

    public int size(){
        return this.arr.size();
    }

    public boolean isEmpty(){
        return this.arr.size() == 0;
    }

    private void upHeapify(int ci){
        int pi = (ci - 1)/2;

        if(pi >= 0 && compareTo(ci,pi)){
            swap(pi,ci);
            upHeapify(pi);
        }
    }

// O(log n)
    public void add(int data){
        this.arr.add(data);
        int n = this.arr.size();

        upHeapify(n-1);
    }

    public int top(){
        return this.arr.get(0); // return the first element
    }

    private void downHeapify(int pi) { // O(logn)
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci < arr.size() && compareTo(lci,maxIdx))
            maxIdx = lci;

        if (rci < arr.size() && compareTo(rci,maxIdx))
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(pi, maxIdx);
            downHeapify(maxIdx);
        }
    }

// O(log n)
    public int remove(){
        int removedElement = this.arr.get(0);
        int n = this.arr.size();
        swap(0,n-1);

        this.arr.remove(n-1);
        downHeapify(0);
        return removedElement;
    }

// 380. Insert, delete and getRandom in O(1)

class RandomizedSet {
    
    HashMap<Integer,Integer> hm;
    ArrayList<Integer> arr ;
    
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val))
            return false;
        arr.add(val);
        int idx = arr.size()-1; // 0 or greater 
        hm.put(val,idx);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hm.containsKey(val))
            return false;
        
        int cidx=hm.get(val);
        int lidx=arr.size()-1;
        
        hm.put(arr.get(lidx),cidx);
        hm.remove(val);
        arr.set(cidx,arr.get(lidx));
        arr.remove(lidx);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // define the range
        int max = arr.size()-1;
        int min = 0;
        int range = max - min + 1;
  
        // generate random indices
        int rand = (int)(Math.random() * range) + min;
        return arr.get(rand);
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

 
}