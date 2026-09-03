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
    public void reorderList(ListNode head) {

        int length=0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur=cur.next;
        }

        if (length==0 || length== 1){
            return; //no changes
        }

        int isOdd = length % 2;
        int mid = length/2;

        ListNode midNode=head;
        ListNode prev=null;
        while(mid != 0){
            prev=midNode;
            midNode=midNode.next;
            mid--;
        }
        prev.next=null;//cut into half using node before mid

        ListNode reversedHalf;
        if (isOdd==1){
            reversedHalf = reverseList(midNode.next);
            
        }
        else {
            reversedHalf = reverseList(midNode);
        }

        ListNode cur1,cur2,nextCur1,nextCur2,tail;
        cur1=head;
        prev=null;
        cur2=reversedHalf;
        

        while(cur1 !=null){ //this is halved 2nd list and both lists are same length
            
            nextCur1=cur1.next;
            nextCur2=cur2.next;
            
            cur1.next=cur2;
            cur2.next=nextCur1;

            prev=cur2;//land node in merge is added from reversed list so we use cur2
            cur1=nextCur1;
            cur2=nextCur2;
        }

        if (isOdd==1){//append mid node for odd length case
            prev.next=midNode;
            midNode.next=null;
        }

        //no return only modify the list
        return;
        
       
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur,nextCur,prev;
        
        if (head==null){
            return null;
        }

        prev=head;
        cur=head.next;
        
        while (cur != null) {
			nextCur=cur.next;
            cur.next = prev;
			prev=cur;
            cur=nextCur;
        }
        head.next=null;
        head=prev;//prev is last node in list
        return prev;
    }

}
