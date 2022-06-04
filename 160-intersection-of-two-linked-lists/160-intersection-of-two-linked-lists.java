/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int getCount(ListNode head)
    {
        ListNode temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //base cases
        
        ListNode A=headA;
        ListNode B=headB;
        int sizeA=getCount(headA);
        int sizeB=getCount(headB);
        int diff;
        if(sizeA>sizeB)
        {
            diff=sizeA-sizeB;
            for(int i=0;i<diff;i++)
                A=A.next;
        }
        else if(sizeA<sizeB)
        {
            diff=sizeB-sizeA;
            for(int i=0;i<diff;i++)
                B=B.next;
        }
        
        while(A!=null)
        {
            if(A==B)
                return A;
            A=A.next;
            B=B.next;
        }
        return null;
        
    }
}