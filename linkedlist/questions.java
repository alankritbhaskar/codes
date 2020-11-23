public class questions{

 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode middleNodeHelper(ListNode node) {
    
        if(node==null || node.next==null) //0th pos, 1st pos
            return node;
        
        ListNode slow=node,fast=node;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;    
        }
        return slow;
    }

// Leetcode 876. Middle of linked list--- in case of even nos. of nodes return second of the two

    public ListNode middleNode(ListNode node) {
    
        if(node==null || node.next==null) //0th pos, 1st pos
            return node;
        
        ListNode slow=node,fast=node;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;    
        }
        return slow;
    }

// Leetcode 206. Reverse a Linked List

    public ListNode reverseList(ListNode node) {
        if(node==null || node.next==null)
            return node;
        
        ListNode prev=null;
        ListNode curr=node;
        
        while(curr!=null){
            ListNode fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        return prev;
    }

    public ListNode reverseList(ListNode node) {
        if(node==null || node.next==null)
            return node;
        
        ListNode node1 = reverseList(node.next);
        ListNode head=node1;
        
        while(node1.next!=null)
            node1=node1.next;
        
        node1.next = node; 
        node.next = null; 
    
        return head;
    }

    


}