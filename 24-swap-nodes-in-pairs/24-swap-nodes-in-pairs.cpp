/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(head==NULL || head->next== NULL)
            return head;
        ListNode* curr=head;
        ListNode* prev=NULL;
        head=head->next;
        while(curr && curr->next!=NULL)
        {
            ListNode* node=curr->next;
            ListNode* tem=node->next;
            node->next=curr;
            curr->next=NULL;
            if(prev)
            {
                if(node)
                    prev->next=node;
            }
            prev=curr;
            curr=tem;
        }
        if(curr && curr->next==NULL)
        {
            prev->next=curr;
        }
        return head;
    }
};