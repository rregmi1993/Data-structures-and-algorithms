package Queue;


public class LinearQueueUsingArray {
	
	int front;
	int rear;
	int [] queueArr;
	
	public void createQueue(int size) {
		queueArr = new int[size];
		front = -1; 
		rear = -1;
	}
	
	public void enQueue(int val) {
		
		if (queueArr.length - 1 == rear) {
			System.out.println("Queue is overflow");
		}
		else if(rear == -1) {
			front = 0;
			rear++;
			queueArr[rear] = val;
		}
		else {
			rear++;
			queueArr[rear] = val;
		}
	}
	
	
	public void deQueue() {
		if(front == -1) {
			System.out.println("Queue is Empty");
		}
		else{
			queueArr[front] = 0;
			front++;
			
			if(front>rear) {
				front = 0;
				rear  = 0;
			}
		}
	}
	
	
	public void peek() {
		if(front == -1) {
			System.out.println("Queue is Empty");
		}
		else {
			System.out.println(queueArr[front]);
		}
	}
	
	
	public boolean isEmpty() {
		if(front == -1) return true;
		return false;
	}
	
	
	public boolean isFull() {
		if(queueArr != null && rear == queueArr.length - 1) return true;
		return false;
	}
	
	public void deleteQueue() {
		queueArr = null;
	}
	
	public static void main(String arrs[]) {
		LinearQueueUsingArray lq = new LinearQueueUsingArray();
		lq.createQueue(5);
		lq.enQueue(1);
		lq.enQueue(2);
		lq.enQueue(5);
		lq.enQueue(4);
		lq.deQueue();
		lq.peek();
		lq.deleteQueue();
		System.out.println(lq.isEmpty());
		System.out.println(lq.isFull());
	}

}
