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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // ListNode dummy = new ListNode(-1);
        // dummy.next = head;

        ListNode l = head;

        int count = 0;
        while(l != null){

            l=l.next;
            count++;
        }

        if(count == n) return head.next;
        ListNode slow = head;

        int pos = count-n;

        for(int i = 1; i< pos; i++){

            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
        
    }
}