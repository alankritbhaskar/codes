// Implementation of Linked List Class

public class linkedlistclass{

    public static class LinkedList{
      
     private class Node{
         private int data=0;
         private Node next=null;

         Node(int data){
           this.data=data;
         }
     }
      
      private Node head = null;
      private Node tail = null;
      private int elementCount = 0;

      public int size(){
        return this.elementCount;
      }

      public boolean isEmpty(){
        return this.size()==0;
      }

      private void handleZeroSize(Node node){
        this.head = node;
        this.tail = node;
      }

      private void addFirstNode(Node node){
        if(this.size() == 0){
          handleZeroSize(node);
          else{
            node.next = this.head;
            this.head = node;
          }
        }
      }

      public void addFirst(){
        Node node = new Node(data);
        addFirstNode(node);
      }

      public void addLast(){

      }

      public void removeFirst(){

      }

      public  void removeLast(){

      }






}