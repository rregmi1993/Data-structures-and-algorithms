package linkedList;

public class CircularSinglyLinkedList {

	class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	
	Node head = null;
	Node tail = null;
	int size = 0;
	
	private Node getPrevNode(int index) {
		Node currNode = head;
		for(int i = 0; i < index; i++) currNode = currNode.next;
		return currNode;
	}
	
	void addNode(int val) {
		Node newNode = new Node(val);
		if(head ==  null) {
			head = tail = newNode;
			tail.next = head;
		}
		else {
			tail.next = newNode;
			newNode.next = head;
			tail = newNode;
			
		}
		size++;
	}
	
	void insertAtHead(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = tail = newNode;
			tail.next = head;
		}
		else {
			newNode.next = head;
			tail.next = newNode;
			head = newNode;
		}
		size++;
	}
	
	void insertAtTail(int val) {
		Node newNode = new Node(val);
		
		if(head == null) {
			head = tail = newNode;
			newNode.next = head;
		}
		else {
			tail.next = newNode;
			newNode.next = head;
			tail = newNode;
		}
		size++;
	}
	
	
	void deleteAtIndex(int index) {
		if(index<0 || index>size) return;
		if(index == 0) {
			head = head.next;
		}
		else {
			Node prevNode = getPrevNode(index - 1);
			prevNode.next = prevNode.next.next;
			if(index == size -1) {
				tail = prevNode;
			}
		}
		size--;
		
	}
	
	void display() {

		if(head == null) {
			System.out.println("Linked List Empty !!!");
			return;
		}else {
			System.out.println(head.val);
			Node curr = head.next;
			while(curr != head) {
				System.out.println(curr.val);
				curr = curr.next;
			}
		}
	}
	
	
	public static void main(String arr[]) {
		CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
		circularSinglyLinkedList.insertAtHead(3);
		circularSinglyLinkedList.insertAtHead(2);
		circularSinglyLinkedList.insertAtHead(1);
		circularSinglyLinkedList.insertAtTail(5);
		circularSinglyLinkedList.deleteAtIndex(1);
		circularSinglyLinkedList.display();
		
	}
}
