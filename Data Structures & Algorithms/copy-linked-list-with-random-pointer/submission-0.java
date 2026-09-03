/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //hashMap links nodes to their copies
		HashMap<Node, Node> OrgToCopy = new HashMap<>();
		OrgToCopy.put(null, null);
		Node cur = head;
		Node copy;
		
		//1st Pass: creates copies and HM links original node to copy
		while (cur != null) {
			copy = new Node(cur.val);
			OrgToCopy.put(cur, copy); //key-value
			cur=cur.next;
		}
		
		//2nd Pass: updates pointers of copied node
		cur = head;
		
		while (cur != null) {
			copy= OrgToCopy.get(cur);
			copy.next=OrgToCopy.get(cur.next);
			copy.random = OrgToCopy.get(cur.random);
			cur=cur.next;
		}
		
		//now return head of new list which is copy of head node
		return OrgToCopy.get(head);
    }
}
