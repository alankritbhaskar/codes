// This is a basic industry level implementation of stack ds.
// Keeping in mind the basic concepts of OOPs.
// To ensure modularity, data hiding, encapsulation, polymorphism, inheritance and reusability of code. 

public class stack{

    private int arr[];
    private int tos; // top of stack
    private int elementCount;

    protected initializeValues(int size){
        this.arr=new int[size];
        this.tos=-1;
        this.elementCount=0;
    }
    
    public stack(){
        initializeValues(10);
    }
    
    public stack(int size){
        initializeValues(size);
    }

    public int size(){
        return this.elementCount;
    }
    
    private int capacity(){
        return this.arr.length;
    }

    public boolean isEmpty(){
        return this.elementCount==0;
    }

    public int peek() throws Exception{
        if(isEmpty())
        throw new Exception("Stack is Empty: Stack Underflow");

        return this.arr[this.tos];
    }

    public int pop() throws Exception{
        if(isEmpty())
        throw new Exception("Stack is Empty: Stack Underflow");

        int rv=this.arr[this.tos];
        this.arr[this.tos--]=0;
        this.elementCount--;
        return rv;
    }

    public void push(int data) throws Exception{
        if(this.size()==this.capacity()){
            throw new Exception("Stack is full: Stack Overflow")
        }

        this.arr[++this.tos]=data;
        this.elementCount++;
    }

}