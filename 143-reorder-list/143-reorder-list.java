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
        private ListNode GetMiddle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode middle=GetMiddle(head);
        ListNode nH=reverseList(middle.next);
        middle.next=null;
        ListNode curr=head;
        while(curr != null && nH !=null)
        {
            ListNode tmp1=curr.next;
            ListNode tmp2=nH.next;
            curr.next=nH;
            nH.next=tmp1;
            nH=tmp2;
            curr=tmp1;
        }
        
    }
}