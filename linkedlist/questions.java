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

// Leetcode 234:- Palindrome Linked List

    public ListNode midNode(ListNode node){
        if(node==null || node.next==null)
            return node;
        
        ListNode slow=node,fast=node;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode node){
    if(node==null || node.next==null)
        return node;
        
    ListNode prev=null,curr=node;
    while(curr!=null){
        ListNode fwd=curr.next;
        curr.next=prev;
        prev=curr;
        curr=fwd;
    }
        return prev;
    }
    
    public boolean isPalindrome(ListNode node) {
    if(node==null || node.next==null) // 0/1 nodes in list
        return true;
    
    ListNode mid=midNode(node);
    ListNode newHead=mid.next;
    mid.next=null;
    
    newHead=reverse(newHead);
    ListNode c1=node,c2=newHead;
    
    boolean res=true;
    while(c1!=null && c2!=null){
        if(c1.val!=c2.val)
        {
            res=false;
            break;
        }
        c1=c1.next;
        c2=c2.next;
    }
        
    newHead=reverse(newHead);
    mid.next=newHead;
    
    return res;
    }

// Leetcode 143. Reorder List

 public void reorderList(ListNode head) {
    if(head==null || head.next==null)
            return;
        
    ListNode mid = midNode(head);
    ListNode nhead = mid.next;
    mid.next = null;
    nhead = reverse(nhead);
    
    ListNode c1 = head,c2 = nhead;
    while(c1 != null && c2 != null){
        ListNode f1 = c1.next; // backup
        ListNode f2 = c2.next;
        
        c1.next = c2;
        c2.next = f1;
        
        c1 = f1;
        c2 = f2;
    }
    }

    


}