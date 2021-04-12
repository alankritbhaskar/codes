import java.util.*;

public class linkedList{

// node should be protected that is it should not be accessible to anything outside
    private class Node{
        private int data = 0;
        private Node next = null;

        Node(int data){
            this.data = data;
        }
    }

// Requirements for head, tail, number of Nodes
    private Node head = null;
    private Node tail = null;
    private int numberOfNodes = 0;

// Functions available to user..... should be public

    public int size(){
        return this.numberOfNodes;
    }

    public boolean isEmpty(){
        return (this.size() == 0);
    }

// initially no node is in linked list
    protected void handleZeroSize(Node node){
        this.head = node;
        this.tail = node;
    }

    protected Node getNodeAt(int idx){
        Node temp = this.head;
        while(idx-- > 0){
            temp = temp.next;
        }
        return temp;
    }

// add functions

    protected void addFirstNode(Node node){
        if(this.size() == 0)
            handleZeroSize(node);
        else{
            node.next = this.head;
            this.head = node;
        }
        this.numberOfNodes++;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    protected void addLastNode(Node node){
        if(this.size() == 0)
            handleZeroSize(node);
        else{
            this.tail.next = node;
            this.tail = node;
        }
        this.numberOfNodes++;
    }

    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    protected void addNodeAt(Node node,int idx){
        if(idx == 0)
            addFirstNode(node);
        else if(idx == size()-1)
            return addLastNode(node);
        else{
            Node nodeAt = getNodeAt(idx-1);
            Node fwd = nodeAt.next;
            nodeAt.next = node;
            node.next = fwd;
        }
        this.numberOfNodes++;
    }

    public void addAt(int data,int idx) throws Exception{
        if(idx < 0 || idx > this.size())
            throw new Exception("Invalid Index!");
        
        Node node = new Node(data);
        addNodeAt(node,idx);
    }

    protected void handleSize1(){
        this.head = null;
        this.tail = null;
    }

// remove functions

    protected Node removeFirstNode(){
        Node temp = head;
        if(this.size() == 1)
            handleSize1();
        else{
            this.head = this.head.next;
        }
        temp.next = null;
        this.numberOfNodes--;
        return temp;
    }

    protected Node removeLastNode(){
        if(this.size() == 1)
            handleSize1();
        else{
            Node prevNode = getNodeAt(this.size()-2);
            //Node node = getNodeAt(this.size()-1); -- last node
            prevNode.next = null;
            this.tail = prevNode;
        }
        this.numberOfNodes--;
        temp.next = null;
        return temp;
    }

    public int removeFirst() throws Exception{
        if(this.size() == 0){
            throw new Exception("LinkedList Empty!");
        }

        Node node = removeFirstNode();
        return node.data;
    }

    public int removeLast() throws Exception{
        if(this.size() == 0)
            throw new Exception("LinkedList Empty!");
        Node node = removeLastNode();
        return node.data;
    }

    public Node removeAtNode(int idx){
        if(idx == 0)
            return removeFirstNode();
        else if(idx == size()-1)
            return removeLastNode();
        else{
            Node prevNode = getNodeAt(idx-1);
            Node removeNode = prevNode.next;
            Node fwd = removeNode.next;

            prevNode.next = fwd;
            removeNode.next = null;
        }
        this.numberOfNodes--;
        return removeNode;
    }

    public int removeAt(int idx) throws Exception{
        if(this.size() == 0)
            throw new Exception("LinkedList Empty!");
        else if(idx < 0 || idx >= this.size())
            throw new Exception("Invalid Index");

        Node node = removeAtNode(idx);
        return node.data;
    }

}