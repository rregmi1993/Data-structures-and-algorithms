package LinkedList;

public class SinglyLinkedList {

	public class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	Node head = null;
	Node tail = null;
	int size = 0 ;
	
	private Node getNode(int index) {
		Node p = head;
		for(int i = 0; i<index; i++) p = p.next;
		return p;
	}
	
	public void addAtHead(int val) {
		Node newNodeObj = new Node(val);
		if(head == null) {
			head = tail = newNodeObj;
		}
		else {
			newNodeObj.next = head;
			head = newNodeObj;
			
		}
		
	}
	
	public void addAttail(int val) {
		Node newNodeObj = new Node(val);
		if(head == null) {
			head = tail = newNodeObj;
		}
		else {
			tail.next = newNodeObj;
			tail = newNodeObj;
		}
	}
	
	public void addAtIndex(int index, int val) {
		if(index == 0) addAtHead(val);
		else if(index == size) addAttail(val);
		else {
		Node preNode = getNode(index - 1);
		Node newNodeObj =  new Node(val);
		newNodeObj.next = preNode.next;
		preNode.next = newNodeObj;
		size++;
		}
		
	}
	
	public void deleteAtIndex(int index) {
    	if (index<0 || index>=size) { 
    		return;
    	}
    	if (index == 0) {
    		head = head.next;
    	} 
    	else {
    		Node prevNode = getNode(index - 1);
    		prevNode.next = prevNode.next.next;
    		if (index == size - 1) {
    			tail = prevNode;
    		}
    	}
    	size--;
    }
	
	public void display() {
		if(head == null) {
			System.out.println("Linked List is Empty !!!");
		}else {
			Node curr = head;
			while(curr != null) {
				System.out.println(curr.val);
				curr = curr.next;
			}
			
		}
	}
	public static void main(String arrs[]) {
		SinglyLinkedList singleLinkedList= new SinglyLinkedList();

		singleLinkedList.addAtHead(5);
		singleLinkedList.addAtHead(6);
		singleLinkedList.addAttail(100);
		singleLinkedList.addAtIndex(2, 55);
		singleLinkedList.deleteAtIndex(0);
		singleLinkedList.display();
		
	}


	
}
