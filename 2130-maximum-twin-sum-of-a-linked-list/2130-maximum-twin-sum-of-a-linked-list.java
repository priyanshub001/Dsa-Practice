/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {

        // find middle..

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse half node of right side..

        ListNode prv = null;

        while (slow != null){

            ListNode next = slow.next;
            slow.next = prv;
            prv = slow;
            slow = next; 
        }
 
 // prv is head of reversed second half..

        int count = 0;

        ListNode first = head;
        ListNode second = prv;

        while (second != null){

            count = Math.max(count,first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return count;


        
    }
}