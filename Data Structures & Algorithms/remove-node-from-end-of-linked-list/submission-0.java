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
        int length=0;
		ListNode cur = head;
		
		while (cur != null) {
			length++;
			cur=cur.next;
		}
		
		if (n>length) {
			return head;
			}
		else if (n==length) {//delete first node so shift head
			head=head.next;
			return head;
		}
		int prevIndex = length - n - 1;
		
		
		cur = head;
		while (prevIndex !=0) {
			prevIndex--;	
			cur=cur.next;
		}
		
		cur.next=cur.next.next;
		return head;

    }
}
