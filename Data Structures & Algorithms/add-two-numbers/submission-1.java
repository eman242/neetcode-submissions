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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		
		int n1,n2,sum,carry,res;
		carry=0;
		
		ListNode head=null;
		ListNode tail=null;
		
		while (cur1 != null || cur2 != null) {
			
			
			if (cur1==null) {
				n1=0;
			}
			else {
				n1 = cur1.val;
			}
			
			if (cur2==null) {
				n2=0;
			}
			else {
				n2 = cur2.val;
			}
			
			sum= n1+n2 + carry;
			res = sum % 10;
			carry = sum / 10;
			
			ListNode newNode = new ListNode(res); 
			if(head==null) {
				head=newNode;
				tail=newNode;
			}
			else {
				tail.next=newNode;
				tail=newNode;
			}
			if (cur1 !=null) {
				cur1=cur1.next;
			}
			if (cur2 !=null) {
				cur2=cur2.next;
			}
		}
		
		//add node at end if carry is not 0
		if (carry!=0) {
			ListNode newNode = new ListNode(carry); 
			if(head==null) {
				head=newNode;
				tail=newNode;
			}
			else {
				tail.next=newNode;
				tail=newNode;
			}
		}
		
		return head;
    }
}
