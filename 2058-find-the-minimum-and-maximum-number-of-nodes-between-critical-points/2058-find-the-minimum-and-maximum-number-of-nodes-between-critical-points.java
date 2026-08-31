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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
         int first = -1;
        int prev = -1;
        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;
        int index = 1;

        ListNode a = head;
        ListNode b = head.next;

        while (b != null && b.next != null) {
            if ((b.val > a.val && b.val > b.next.val) ||
                (b.val < a.val && b.val < b.next.val)) {

                if (first == -1) {
                    first = index;
                }

                if (prev != -1) {
                    minDist = Math.min(minDist, index - prev);
                    maxDist = index - first;
                }

                prev = index;
            }

            a = b;
            b = b.next;
            index++;
        }

        if (maxDist == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, maxDist};
    }
}