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
    public ListNode oddEvenList(ListNode head) {
        //base cases
        if(head==null || head.next==null)
            return head;
        //code
        ListNode eH=head.next;
        ListNode c1=head;
        ListNode c2=eH;
        while(c1.next!=null && c1.next.next!=null)
        {
            c1.next=c2.next;
            c2.next=c2.next.next;
            c1=c1.next;
            c2=c2.next;
        }
        c1.next=eH;
        return head;
    }
}