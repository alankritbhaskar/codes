// This is a basic industry level implementation of queue ds.
// Keeping in mind the basic concepts of OOPs.
// To ensure modularity, data hiding, encapsulation, polymorphism, inheritance and reusability of code. 

public class queue{

    private int arr[];
    private int elementCount; // nos. of element in the queue
    private int front; // front/start pointer to the queue
    private int back; // back/end pointer to the queue

    protected void initializeValues(int size){
        this.arr=new int[size];
        this.elementCount=0;
        this.front=0;
        this.back=0;
    }

    public queue(){
        initializeValues(10);
    }

    public queue(int size){
        initializeValues(size);
    }

    public int size(){
    return this.elementCount;
    }

    public int capacity(){
    return this.arr.length;
    }

    public boolean isEmpty(){
    return this.elementCount==0;
    }

    // front, remove ---> from start of the queue


    public int front() throws Exception{
    
        if(this.isEmpty()){
            throw new Exception("Queue is Empty");
        }

        return this.arr[this.front];
    }

    public int remove(){

        if(this.isEmpty()){
            throw new Exception("Queue is Empty");
        }

        
        int rv=this.arr[this.front];
        this.arr[this.front]=0;
        this.front=(this.front+1)%this.capacity();
        this.elementCount--;
        return rv;
    }

    // insert(int data) ---> at the end of the queue

    public void insert(int data) throws Exception{
         
        if(this.capacity()==this.size())
        {
            throw new Exception("Queue is full");
        }

        this.arr[this.back]=data;
        this.back=(this.back+1)%this.capacity();
        this.elementCount++;
    }

}