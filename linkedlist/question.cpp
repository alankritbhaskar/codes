#include <iostream>
using namespace std;

 // Definition for singly-linked list.
 
  struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };

// Leetcode 876- Middle of LinkedList

    ListNode* middleHelper(ListNode* node){
        
        // For 0 and 1 nodes
        if(node == nullptr || node->next == nullptr)
            return node;
        
        ListNode* slow = node;
        ListNode* fast = node;
        
        while(fast->next != nullptr && fast->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow;
    }
    ListNode* middleNode(ListNode* node) {
        
        // For 0 and 1 nodes
        if(node == nullptr || node->next == nullptr)
            return node;
        
        ListNode* slow = node;
        ListNode* fast = node;
        
        while(fast != nullptr && fast->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow;
    }

// Leetcode 206. Reverse Linked List

// Recursive Approach

     ListNode* reverseList(ListNode* head) {
        // for 0 and 1 nodes
         if(head == nullptr || head->next == nullptr)
             return head;
         
         ListNode* nextHead = head->next;
         head->next = nullptr;
         
         ListNode* reversedList = reverseList(nextHead);
         
         nextHead->next = head;
         return reversedList;
     }

// Iterative Approach

    ListNode* reverse(ListNode* head) {
        // for 0 and 1 nodes
        if(head == nullptr || head->next == nullptr)
            return head;
        
        ListNode* prev = nullptr;
        ListNode* curr = head;
        
        while(curr != nullptr){
            ListNode* fwd = curr->next;
            curr->next = prev;
            prev = curr;
            curr = fwd;
        }
        
        return prev;
    }

// Leetcode 234. Palindrome Linked List

    bool isPalindrome(ListNode* head) {
        // 0 or 1 nodes only
        if(head == nullptr || head->next == nullptr)
            return true;
        
        ListNode* mid = middleHelper(head);
        ListNode* newHead = mid->next;        
        mid->next = nullptr;
        newHead = reverse(newHead);
        
        ListNode* p1 = head;
        ListNode* p2 = newHead;
        
        bool res = true;
        
        while(p1 != nullptr && p2 != nullptr){
            if(p1->val != p2->val){
                res = false;
                break;
            }
            
            p1 = p1->next;
            p2 = p2->next;
        }
            
        // Restore the original linked list
        newHead = reverse(newHead);
        mid->next = newHead;
        
        return res;
    }

// Just reverse the data in linked list

    void dataReverse(ListNode* node){

        if(node == nullptr || node->next == nullptr)    return;

        ListNode* head = node;
        ListNode* mid = middleHelper(head);
        ListNode* newHead = mid->next;
        mid->next = nullptr;
        newHead = reverse(newHead);

        ListNode* curr1 = head;
        ListNode* curr2 = newHead;

        while(curr1 != nullptr && curr2 != nullptr){
            
            // Swap data 
            int temp = curr1->val;
            curr1->val = curr2->val;
            curr2->val = temp;

            curr1 = curr1->next;
            curr2 = curr2->next;
        }

        newHead = reverse(newHead);
        mid->next = newHead;
    }













// Leetcode 148. Sort List

    ListNode* middleHelper(ListNode* node){
        if(node == nullptr || node->next == nullptr)    return node;
        ListNode* slow = node; ListNode* fast= node;
        
        while(fast->next != nullptr && fast->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow;
    }
    
    ListNode* mergeTwoSortedLists(ListNode *l1, ListNode *l2){
    if (l1 == nullptr || l2 == nullptr)
        return l1 != nullptr ? l1 : l2;

    ListNode *dummy = new ListNode(-1);
    ListNode *prev = dummy;

    ListNode *c1 = l1;
    ListNode *c2 = l2;

    while (c1 != nullptr && c2 != nullptr)
    {
        if (c1->val <= c2->val)
        {
            prev->next = c1;
            c1 = c1->next;
        }
        else
        {
            prev->next = c2;
            c2 = c2->next;
        }

        prev = prev->next;
    }

    prev->next = c1 != nullptr ? c1 : c2;

    ListNode *h = dummy->next;
    dummy->next = nullptr;
    delete dummy;   
    return h;
    }
    
    ListNode* sortList(ListNode* head) {
      if(head == nullptr || head->next == nullptr)  return head;
        
        ListNode* mid = middleHelper(head);
        ListNode* nextHead = mid->next;
        mid->next = nullptr;
        
        return mergeTwoSortedLists(sortList(head),sortList(nextHead));
    }

// Leetcode 141. LinkedList Cycle-1

    bool hasCycle(ListNode *head) {
        
        if(head == nullptr || head->next == nullptr)
            return false;
        
        ListNode* slow = head;
        ListNode* fast = head;
        
// Pointers can be moved at any speed such that speed of one is greater than another

        while(fast != nullptr && fast->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next->next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;        
    }

// Leetcode 143. Linked List Cycle-2

    ListNode *detectCycle(ListNode *head) {
        if(head == nullptr || head->next == nullptr)
            return nullptr;
        
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast != nullptr && fast->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
            
            if(slow == fast){
                break;
            } 
        }
        
        if(slow != fast) // not a loop present
           return nullptr;
                            
        slow = head;
        while (slow != fast){
            slow = slow->next;
            fast = fast->next;
        }
        
        return slow;
    }





int main(){

    return 0;
}