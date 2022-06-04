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
    public boolean isPalindrome(ListNode head) {
        //edge cases
        if(head==null ||
          (head!=null && head.next==null))
            return true;
        //code
        ListNode curr=head;
        ListNode middle=GetMiddle(head);
        ListNode RevHeadSecondHalf=reverseList(middle.next);
        ListNode currSecondHalf=RevHeadSecondHalf;
        while(currSecondHalf!=null)
        {
            if(curr.val!=currSecondHalf.val)
            {
                middle.next=reverseList(RevHeadSecondHalf);
                return false;
            }
            curr=curr.next;
            currSecondHalf=currSecondHalf.next;
        }
        middle.next=reverseList(RevHeadSecondHalf);
        return true;
    }
}