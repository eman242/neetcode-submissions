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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
		ListNode cur1=list1;
		ListNode cur2=list2;
		
		ListNode tail = head;
		while(cur1 != null && cur2 != null) {
			if (cur1.val<cur2.val) {
				ListNode newNode = new ListNode(cur1.val);
				newNode.next=null;
				if (head==null) {
					head=newNode;
					tail=head;
				}
				else {
					tail.next= newNode;
					tail=newNode; //keep track of tail to add at end
				}
				
				cur1=cur1.next;
				
			}
			else {
				ListNode newNode = new ListNode(cur2.val);
				newNode.next=null;
				if (head==null) {
					head=newNode;
					tail=head;
				}
				else {
					tail.next= newNode;
					tail=newNode;
				}
				cur2=cur2.next;
			}	
		}
		
		if (cur1==null ) {
			if (head==null) {
				head=cur2;
			}
			else {
				tail.next=cur2;
			}
		}
		else {
			if (head==null) {
				head=cur1;
			}
			else {
				tail.next=cur1;
			}
			
		}
        return head;
        
    }
}