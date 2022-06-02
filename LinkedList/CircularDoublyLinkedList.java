package LinkedList;
public class CircularDoublyLinkedList {

	
	class Node{
		int val;
		Node prev;
		Node next;
		Node(int val){
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}
	
	int size = 0;
	Node head = null;
	Node tail = null;
	
	private Node getPrevNode(int index) {
		Node curr = head;
		for(int i = 0; i<index; i++) curr = curr.next;
		return curr;
	}
	
	
	// same function can be use to add at tail
	void addNode(int val) {
		Node newNode = new Node(val);
		
		if(head == null) {
			head = tail = newNode;
			tail.next = head;
			head.next = tail;
		}else {
			newNode.next = head;
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
			head.prev = newNode;
		}
		size++;
	}
	
	void addAtHead(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = tail = newNode;
			tail.next = head;
			head.next = tail;
			
		}else {
			newNode.prev = tail;
			newNode.next = head;
			head.prev = newNode;
			tail.next = newNode;
			head = newNode;
		}
		size++;
	}
	
	
	
	void display() {
		
		Node curr = head;
		if(head == null) {
			System.out.println("Linked List is Emoty !!!");
		}
		System.out.println(curr.val);
		curr = curr.next;
		while(curr != head) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
	
	
	void addAtIndex(int index, int val) {
		
		if(index == 0) {
			addAtHead(val);
		}
		else if(index == size) {
			addNode(val);
		}
		else {
		
		
		Node prevNode = getPrevNode(index - 1);
		Node newNode = new Node(val);
		newNode.next = prevNode.next;
		newNode.prev = prevNode;
		prevNode.next.prev = newNode;
		prevNode.next = newNode;
		}
		size++;
		
	}
	
	void deleteAtIndex(int index) {
		
		if(index<0 || index>=size) return;
		
		if(index == 0) {
			head = head.next;
			head.prev = tail;
			tail.next = head;
		}
		else {
		Node prevNode = getPrevNode(index - 1);
		prevNode.next.next.prev = prevNode;
		prevNode.next = prevNode.next.next;
		if(index == size -1) {
			tail = prevNode;
		}
		}
		size--;
	}

	public static void main(String arrs[]) {
	
		CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();
		circularDoublyLinkedList.addNode(2);
		circularDoublyLinkedList.addNode(3);
		circularDoublyLinkedList.addNode(4);
		circularDoublyLinkedList.addNode(5);
		circularDoublyLinkedList.addAtHead(0);
		circularDoublyLinkedList.addAtIndex(3, 11);
		circularDoublyLinkedList.display();
		
		System.out.println("-------------------------------");
		circularDoublyLinkedList.deleteAtIndex(1);
		circularDoublyLinkedList.display();
		
		
	}

}
