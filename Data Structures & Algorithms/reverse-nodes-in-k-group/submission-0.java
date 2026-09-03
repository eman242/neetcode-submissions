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
    public ListNode reverseKGroup(ListNode head, int k) {
        
		ListNode end,start,nextStart,tail;
		tail= null;
		start = head;
		int count;
		ListNode cur = start;
		
		while(start != null) {
			count=1;
			while(count != k && cur !=null) {
				cur=cur.next;
				count++;
			}
		
			if (cur != null) {
				end=cur;
		
				ListNode nextCur,prev;
				int reversals=0;
				cur=start.next;
				prev=start;
			
				while(reversals != k-1) {
					nextCur=cur.next;
					cur.next = prev;
					prev=cur;
					cur=nextCur;
					reversals++;
				}
				
				start.next=cur;
				
				if (start==head) {
					head=end;
				}
				
				if (tail != null) {
					tail.next=end;
				}
				
				tail=start;
				start=cur;
			}
            else {
                return head;
            }
			
		}	
		return head;
        
    }
}
