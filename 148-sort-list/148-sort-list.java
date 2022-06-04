/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }`
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
    public ListNode sortList(ListNode head) {
        //base case
        if(head==null || head.next==null)
            return head;
        
        ListNode middle = GetMiddle(head);
        ListNode nH=middle.next;
        middle.next=null;
        head=sortList(head);
        nH=sortList(nH);
        
        return mergeTwoLists(head,nH);
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null)
            return null;
        else if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        ListNode head=new ListNode(-1);
        ListNode prev=head;
        ListNode c1=list1;
        ListNode c2=list2;
        while(c1!=null && c2!=null)
        {
            if(c1.val<=c2.val)
            {
                prev.next=c1;
                prev=c1;
                c1=c1.next;
            }
            else
            {
                prev.next=c2;
                prev=c2;
                c2=c2.next;
            }
        }
        if(c1 !=null)
        {
            prev.next=c1;
        }
        else
        {
            prev.next=c2;
        }
        
        return head.next;
        
    }
}