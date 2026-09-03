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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        while(lists.length > 1){
            ListNode list1;
            ListNode list2;
            ArrayList<ListNode> tempList = new ArrayList<>();
            for(int i=0;i<lists.length;i+=2){
                list1 = lists[i];
                
                list2= null;
                if (i+1<lists.length){
                    list2 = lists[i+1];
                }
                tempList.add(mergeTwoLists(list1,list2));
            }
            lists=tempList.toArray(new ListNode[0]);//this arg helps IDE understand it is list of nodes
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);//dummy node, actual head is dummy.next
        ListNode tail=dummy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

    while (cur1 != null && cur2 !=null ){
        if (cur1.val < cur2.val){
            tail.next=cur1;
            tail=tail.next;
            cur1=cur1.next;
        }
        else {
            tail.next=cur2;
            tail=tail.next;
            cur2=cur2.next;
        }
    }
    //exiting the loop means combos: both lists empty/only 1 empty
    //so attatch the rest


    //simpler to write this as 2 if but only one will ever be in use cs loop condition
    if (cur1 != null){
        tail.next=cur1;
    }
    if (cur2 != null){
        tail.next=cur2;
    }

    return dummy.next;  
    }

}
