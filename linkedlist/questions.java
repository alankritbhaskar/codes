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

// Using recursion

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode temp = head.next;
        head.next = null;
        ListNode reversedList = reverseList(temp);
        temp.next = head;
        return reversedList;
    }

// Reverse Data in a LinkedList
    
    void dataReverse(ListNode head){
    if (head == null || head.next == null)
        return;

    ListNode mid = midNode(head);
    ListNode nhead = mid.next;
    mid.next = null;

    nhead = reverseList(nhead);

    ListNode curr1 = head;
    ListNode curr2 = nhead;

    while (curr1 != null && curr2 != null)
    {

        int temp = curr1.val;
        curr1.val = curr2.val;
        curr2.val = temp;

        curr1 = curr1.next;
        curr2 = curr2.next;
    }

    nhead = reverseList(nhead);
    mid.next = nhead;
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

// Seggregate even and odd nodes..... https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1

    Node divide(int N, Node head){
        Node dummyOdd = new Node(-1);
        Node dummyEven = new Node(-1);
        Node odd = dummyOdd;
        Node even = dummyEven;

        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 != 0) {
                odd.next = curr;
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }

            curr = curr.next;
        }

        even.next = dummyOdd.next;
        odd.next = null;

        return dummyEven.next;
    }

// Unfold a folded linked list
/
A linked list L0 . L1 . L2 . ….. . LN can be folded as L0 . LN . L1 . LN – 1 . L2 . ….. 
Given a folded linked list, the task is to unfold and print the original linked list

Examples:  

Input: 1 . 6 . 2 . 5 . 3 . 4 
Output: 1 2 3 4 5 6

Input: 1 . 5 . 2 . 4 . 3 
Output: 1 2 3 4 5 
/

// Using Recursion


// Using Iteration

    void againReorderList(ListNode head){
        if (head == null || head.next == null)
           return;

    ListNode h1 = head;
    ListNode h2 = head.next;

    ListNode c1 = h1;
    ListNode c2 = h2;

    while (c2 != null && c2.next != null)
    {
        ListNode f = c2.next; // Backup

        c1.next = f; // links
        c2.next = f.next;

        c1 = c1.next;
        c2 = c2.next;
    }

    // c1.next = null;
    h2 = reverseList(h2);
    c1.next = h2;
    }


// Leetcode 19. Remove nth from end of list

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)
            return null;
        
        ListNode c1=head,c2=head;
        
        while(n-.0)
            c2=c2.next;
        
        if(c2==null)
            return head.next;
        
        while(c2.next!=null)
        {
            c1=c1.next;
            c2=c2.next;
        }
        
        ListNode rnode=c1.next;
        c1.next=rnode.next;
        rnode=null;
        
        return head;
}

// Leetcode 21. Merge two sorted lists

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
        if(l1==null || l2==null)
            return l1==null?l2:l1;
        
        ListNode head=new ListNode(-1); // dummy node for head
        ListNode prev=head;
        
        ListNode c1=l1, c2=l2;
        
        while(c1!=null && c2!=null){
            if(c1.val<=c2.val){
                prev.next=c1;
                prev=c1;
                c1=c1.next;
            }
            else{
                prev.next=c2;
                prev=c2;
                c2=c2.next;
            }
        }
        
        if(c1==null)
            prev.next=c2;
        else
            prev.next=c1;
        
        return head.next;
        
    }

// Leetcode 148. Sort List ----. nlog(n)

    public ListNode middle(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        ListNode slow=head,fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
    if(l1==null || l2==null)
        return l1==null?l2:l1;
        
    ListNode head=new ListNode(-1); // dummy
    ListNode prev=head;
        
    ListNode c1=l1,c2=l2;
    while(c1!=null && c2!=null){
        if(c1.val<=c2.val){
            prev.next=c1;
            prev=c1;
            c1=c1.next;
        }
        else{
            prev.next=c2;
            prev=c2;
            c2=c2.next;
        }
    }
        
        if(c1==null)
            prev.next=c2;
        else
            prev.next=c1;
        
        return head.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode mid=middle(head);
        ListNode nhead=mid.next;
        mid.next=null;
        
        return mergeTwoSortedLists(sortList(head),sortList(nhead));           
    }

// Leetcode 23. Merge k sorted lists

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
        if(l1==null || l2==null)
            return l1==null?l2:l1;
        
        ListNode head=new ListNode(-1); // dummy node for head
        ListNode prev=head;
        
        ListNode c1=l1, c2=l2;
        
        while(c1!=null && c2!=null){
            if(c1.val<=c2.val){
                prev.next=c1;
                prev=c1;
                c1=c1.next;
            }
            else{
                prev.next=c2;
                prev=c2;
                c2=c2.next;
            }
        }
        
        if(c1==null)
            prev.next=c2;
        else
            prev.next=c1;
        
        return head.next;
        
    }
    
// O(kN) time complexity--. approach 1
    
    public ListNode mergeKLists(ListNode[] lists) {
    
     if(lists.length==0)
         return null;
     if(lists.length==1)
         return lists[0];
        
     ArrayList<ListNode> list=new ArrayList<>();
     
    for(int i=0;i<lists.length;i++)
        list.add(lists[i]);
        
    while(list.size()!=1){
        ListNode l1=list.remove(list.size()-1);
        ListNode l2=list.remove(list.size()-1);
        
        ListNode l3=mergeTwoLists(l1,l2);
        list.add(l3);
    }
        return list.get(0);
    }

// O(k2*N)
// where, n = avg. nodes in each linked list || k = length of lists array

    public ListNode mergek(ListNode lists[]){
        if(lists.length == 0)
            return null;
        
        ListNode ref = null;
        for(int i = 0;i < lists.length;i++)
            ref = merge2(ref,lists[i]);

        return ref;
    }

// Divide and Conquer approach--- O(n log k)..... approach 2

 public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        
        return mergeKLists(lists,0,lists.length-1);
        
    }
    public ListNode mergeKLists(ListNode []lists,int li,int ri){
        if(li==ri)
            return lists[li];
        
        int mid=(li+ri)/2;
        
        ListNode l1=mergeKLists(lists,li,mid);
        ListNode l2=mergeKLists(lists,mid+1,ri);
        
        ListNode l3=mergeTwoLists(l1,l2);
        
        return l3;
    }

// Using Priority Queue ---> O(k*N*logk)

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return a.val - b.val; // this - other, default behaviour
        });
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        // k logk
        for(ListNode l: lists){
            if(l != null)
                pq.add(l);
        }
        
        //k*N logk
        while(pq.size() != 0){
            ListNode node = pq.remove();
            prev.next = node;
            prev = node;
            node = node.next;
            
            if(node != null)
                pq.add(node);
        }
        
        return dummy.next;
    }



}