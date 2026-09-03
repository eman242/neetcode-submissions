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
    public ListNode reverseList(ListNode head) {
        if (head==null) {
	    		return head;
	    	}
	    	else {
	    		ListNode cur = head.next;
	    		ListNode prev = head;
	    		
	    		head.next=null;
	    		while(cur!=null) {
	    			ListNode nextCur =cur.next ;
	    			cur.next=prev;
	    			
	    			prev=cur;
	    			cur=nextCur;	
	    		}
	    		head=prev;
	    		return head;
	    	}
    }
}
