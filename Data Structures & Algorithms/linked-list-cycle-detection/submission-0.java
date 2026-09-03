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
    public boolean hasCycle(ListNode head) {
        ListNode fp = head;
		ListNode sp = head;
		boolean found=false;
		
		while(fp != null) {
			sp=sp.next;
			fp=fp.next;
			if (fp==null) {//to avoid .next on null
				break;
			}
			else {
				fp=fp.next;
			}
			
			if (fp==sp) {
				found=true;
				break;
			}
		}
		return found;
    }
}
