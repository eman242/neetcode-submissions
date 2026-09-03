class LRUCache {

		class Node {
			int key; //cs to delete oldest node from map u used the leftMost node
			//&& it must store key
		    int val;
		    
		    Node next;
		    Node prev;

		    public Node(int key,int val) {
		    	this.key=key;
		        this.val = val;
		        this.next = null;
		        this.prev = null;
		    }
		}
		
	    private int size;
	    private int capacity;
	    //private Node leftHandle; leftHandle is null so cannot use .next
	    private Node leftHandle = new Node(0,0);
	    private Node rightHandle = new Node(0,0);
	    HashMap<Integer,Node> map;//can't be int or primitives

		public LRUCache(int capacity) {
			
			size=0;
			leftHandle.next=rightHandle;
			leftHandle.prev=null;
			rightHandle.prev=leftHandle;
			rightHandle.next=null;
	    	this.capacity=capacity;
	    	map = new HashMap<>();
	        
	    }
	    
	    public int get(int key) {
	    	Node valueNode= map.get(key);
	    	
	    	if(valueNode!=null) {
	    		this.delete(valueNode);
	    		this.insertRecent(valueNode);
	    		return valueNode.val;
	    	}
	    	else {
	    		return -1;
	    	}
	    	 
	    }
	    
	    public void put(int key, int value) {
            
	    	Node valueNode= map.get(key);
	    	if (valueNode!=null){//prexisting so no check capacity or new insert, just update
	    		valueNode.val=value;//update value
    			this.delete(valueNode);
    			this.insertRecent(valueNode);//update recent-cy
	    	}
	    	else {//new insert
	    		if (size<capacity) {//within capacity
	    			valueNode = new Node(key,value);//ik it hurts to read
	    			map.put(key, valueNode);//put into hashmap
	    			this.insertRecent(valueNode);//put into list
	    		}
	    		else {//size exceeded so delete oldest node
	    			Node oldest=leftHandle.next;
		    		this.delete(oldest);//update size -1 and remove old
		    		map.remove(oldest.key);
		    		this.put(key, value);//now re-use functions
	    		}
	    	}
	    	return;
	    }
	    
	    public void delete(Node deleteNode) {//removes given node
	    	
	    	//just update pointers next/prev pointers of preceding and following nodes 
	    	Node previousNode=deleteNode.prev;
	    	Node nextNode=deleteNode.next; // easier vs deleteNode.next.prev=deleteNode.prev
	 	    previousNode.next=nextNode;
	 	    nextNode.prev=previousNode;
	 	    size--;
		    	 
	 	}
	    
	    public void insertRecent(Node newNode) {//inserts node at most recent/RightHandle
 	    	rightHandle.prev.next=newNode;
 	    	newNode.prev=rightHandle.prev;
 	    	newNode.next=rightHandle;
 	    	rightHandle.prev=newNode;
 	    	size++;		 
	 	}
}
