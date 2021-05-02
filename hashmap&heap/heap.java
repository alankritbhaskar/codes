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

}