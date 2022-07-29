package binaryHeap;

public class BinaryHeap {

	int[] binaryHeap;
	int size;
	
	
	public void createBinaryHeap(int size) {
		binaryHeap = new int[size+1];
		size = 0;
	}
	
	public void insert(int value) {
		binaryHeap[size+1] = value;
		size++;
		heapifyBottomToTop(size);
	}
	
	private void heapifyBottomToTop(int index) {
		
		if(index <= 1) return;
		int parentIndex = index /2;
		
		if(binaryHeap[parentIndex] > binaryHeap[index]) {
			int temp = binaryHeap[parentIndex];
			binaryHeap[parentIndex] = binaryHeap[index];
			binaryHeap[index] = temp;
		}
		
		heapifyBottomToTop(parentIndex);
	}
	
	public void size() {
		if (size == 0) {
			System.out.println("Binary heap is Empty");
		}
		else {
			System.out.println("Binary heap size is :" + size);
		}
	}
	
	
	public boolean isEmpty() {
		if(size <= 0) return true;
		return false;
	}
	
	public void peek() {
		if(size <= 0 ) System.out.println("Value is not present");
		System.out.println(binaryHeap[1]);
	}
	
	
	public int extract() {
		if( size == 0) return -1;
		int returnValue = binaryHeap[1];
		binaryHeap[1] = binaryHeap[size];
		size--;
		heapifyTopToBottom(1);
		return returnValue;
			
	}
	
	private void heapifyTopToBottom(int index) {
		int left = 2 * index;
		int right = (2 * index) +1;
		int smallestChild = 0;
		if(left >size) return;
		
		else if(left == size) {
			if(binaryHeap[index] > binaryHeap[left]) {
			int temp = binaryHeap[left];
			binaryHeap[left] = binaryHeap[index];
			binaryHeap[index] = temp;
			}
			return;
		}
		
		else {
			if(binaryHeap[left] > binaryHeap[right]) {
				smallestChild = right;
			}
			else {
				smallestChild = left;
			}
			if(binaryHeap[index] > binaryHeap[smallestChild]) {
				int temp = binaryHeap[index];
				binaryHeap[index] = binaryHeap[smallestChild];
				binaryHeap[smallestChild] = temp;
			}
		}
		heapifyTopToBottom(smallestChild);
	}
	
	
	
	public static void main(String[] args) {
		BinaryHeap bh = new BinaryHeap();
		bh.createBinaryHeap(5);
		bh.insert(50);
		bh.insert(20);
		bh.insert(30);
		bh.insert(10);
		bh.size();
		System.out.println(bh.isEmpty());
		bh.peek();
		System.out.println(bh.extract());
		bh.peek();
		
	}

}
