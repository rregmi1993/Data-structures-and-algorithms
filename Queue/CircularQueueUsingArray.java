package Queue;

public class CircularQueueUsingArray {

	int [] queueArr;
	int front, rear;
	int size;
	
	public void createQueue(int len) {
		
		front = rear = -1;
		queueArr = new int[len];
		size = len;
	}
	
	public boolean isFull() {
		if (front == 0 && rear == size - 1) {
			return true;
		}
		if (front == rear + 1) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if (rear == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void enQueue(int val) {
		if(isFull()) {
			System.out.println("Queue is full ");
		}
		else{
			if(front == -1) front = 0;
			rear = (rear+1) % size;
			queueArr[rear] = val;
		}
	}
	
	public void deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty !!!");
		}else {
			if(front == rear) {
				front = rear = -1;
			}
			else {
				front = (front + 1) % size;
			}
		}
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty !!!");
		}
		else {
			System.out.println(queueArr[front]);
		}
	}
	
	public static void main(String arr[])
	 {
		CircularQueueUsingArray queue = new CircularQueueUsingArray();
		queue.createQueue(5);
	
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
	
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(60);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.peek();
	}
}