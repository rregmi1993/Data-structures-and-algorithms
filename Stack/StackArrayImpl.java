package Stack;

public class StackArrayImpl {
	
	int topOfStack;
	int stackArr[];
	
	public void createStack(int size) {
		stackArr = new int[size];
		topOfStack = -1;
		
	}
	
	// add 
	public void push(int item) {
		if(stackArr == null || stackArr.length - 1 == topOfStack) {
			System.out.println("stack is full/overflow !!!");
			return;
		}else {
			stackArr[topOfStack + 1] = item;
			topOfStack++;
		}
	}
	
	// pop - return and delete the item from stack
	public void pop() {
		if(topOfStack == -1) {
			System.out.println("stack is empty/underflow !!!");
		}else {
			System.out.println(stackArr[topOfStack]);
			stackArr[topOfStack] = 0;
			topOfStack--;
		}
	}
	
	
	// peek - return top element without deleting it
	public void peek() {
		if(topOfStack == -1) {
			System.out.println("stack is underflow");
		}else {
			System.out.println(stackArr[topOfStack]);
		}
	}
	
	// isEmpty()
	public boolean isEmpty() {
		if(stackArr.length == 0) return true;
		return false;
	}
	
	//isFull
	public boolean isFull() {
		if(stackArr.length - 1 == topOfStack ) return true;
		return false;
	}
	
	//delete stack
	
	public void delete() {
		stackArr = null;
		topOfStack = -1;
	}
	
	public static void main(String arrs[]) {
		StackArrayImpl stackArrayImpl = new StackArrayImpl();
		stackArrayImpl.createStack(3);
		stackArrayImpl.push(1);
		stackArrayImpl.push(2);
		stackArrayImpl.push(3);
		stackArrayImpl.pop();
		stackArrayImpl.push(11);
		stackArrayImpl.pop();
		stackArrayImpl.peek();
		stackArrayImpl.push(8);
		System.out.println(stackArrayImpl.isEmpty());
		System.out.println(stackArrayImpl.isFull());
		stackArrayImpl.delete();
		stackArrayImpl.peek();
		stackArrayImpl.pop();
		stackArrayImpl.push(2);
	}

}
