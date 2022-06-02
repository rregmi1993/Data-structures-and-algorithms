package LinkedList;

public class DoublyLinkedList {
	
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
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	
	void addAtHead(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = tail = newNode;
		}else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	
	
	
	void display() {
		
		Node curr = head;
		if(head == null) {
			System.out.println("Linked List is Emoty !!!");
		}
		while(curr != null) {
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
		
		
		Node prevNode = getPrevNode(index);
		Node newNode = new Node(val);
		newNode.next = prevNode.next;
		newNode.prev = prevNode;
		prevNode.next.prev = newNode;
		prevNode.next = newNode;
		}
		size++;
		
	}
	
	void deleteAtIndex(int index) {
		
		if(index<0 || index>size) return;
		
		if(index == 0) {
			head = head.next;
			head.prev = null;
		}
		else {
		Node prevNode = getPrevNode(index - 1);
		prevNode.next.prev = prevNode;
		prevNode.next = prevNode.next.next;
		}
		size--;
	}

	public static void main(String arrs[]) {
	
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.addNode(4);
		doublyLinkedList.addNode(5);
		doublyLinkedList.addNode(6);
		doublyLinkedList.addNode(7);
		doublyLinkedList.addAtHead(1);
		doublyLinkedList.addAtHead(0);
		doublyLinkedList.addAtIndex(1, 11);
		doublyLinkedList.display();
		
		System.out.println("-------------------------------");
		
		doublyLinkedList.deleteAtIndex(0);
		doublyLinkedList.display();
		
		
	}
}
