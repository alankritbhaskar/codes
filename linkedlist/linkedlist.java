public class linkedlistclass{

    public static class LinkedList{
     protected class Node{
         int data=0;
         Node next=null;

         Node(int data){
           this.data=data;
         }
     }
      
      private Node head=null;
      private Node tail=null;
      private int elementCount=0;

     // basic=============

       public int size(){
           return this.elementCount;
       }

       public boolean isEmpty(){
           return this.elementCount==0;
       }

     // add===================

       protected void addFirstNode(Node node){
          if(this.head==null){
             this.head=node;
             this.tail=node;
          }
          else{
            node.next=this
          }

       }

       public void addFirst(int val){
          Node node=new Node(val);
          addFirstNode(node);
       }

       public void addLast(int val){

       }

       public void addAt(int val,int pos){

       }

     // remove================

     // get===================
       
       protected Node getFirstNode(){
           return this.head;
       }

       public int getFirst() throws Exception{
           if(this.elementCount==0){
               throw new Exception("NullPointerException");
           }
           Node node=getFirstNode();
           return node.data;
       }

       protected Node getLastNode(){
          return this.tail;
       }

       public int getLast() throws Exception{
           if(this.elementCount==0)
              throw new Exception("NullPointerException");
           
           Node node=getLastNode();
           return node.data;
       }

    }

    public static void main(String args[]) throws Exception{
    LinkedList ll=new LinkedList();

    }
}