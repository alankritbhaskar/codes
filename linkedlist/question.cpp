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







int main(){

    return 0;
}