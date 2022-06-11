package Queue;

public class LinearQueueUsingLinkedList {
	
	private class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	Node front;
	Node rear;
	
	void createQueue() {
		front = rear = null;
	}
	
	
	public void enQueue(int val) {
		Node newNode = new Node(val);
		if(rear == null) {
			front = rear = newNode;
		}else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public void deQueue() {
		if(front == null) {
			System.out.println("Queue is Empty !!!");
		}
		else {
			front = front.next;
			if (front == null) {
				rear = null;
			}
		}
	}
	
	
	public void peek() {
		if (front == null) {
			System.out.println("Queue is Empty!");
		} else {
			System.out.println(front.val);
		}
	}
	
	public boolean isEmpty() {
		if (front == null) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteQueue() {
		front = rear = null;
		System.out.println("Queue is Deleted!");
	}
	
	public static void mian(String[] arrs) {
		LinearQueueUsingLinkedList queue = new LinearQueueUsingLinkedList();
		queue.createQueue();
		queue.enQueue(1);
		queue.enQueue(12);
		queue.enQueue(13);
		queue.enQueue(14);
		
		queue.deleteQueue();
		
		queue.peek();
		
		queue.isEmpty();
		queue.deleteQueue();
	}
}
