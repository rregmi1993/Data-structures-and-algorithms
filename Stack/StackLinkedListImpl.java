package Stack;

public class StackLinkedListImpl {
	
	class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	
	Node head;
	void create() {
		head = null;
	}
	
	
	void push(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	
	void pop() {
		if(head == null) {
			System.out.println("Stack is underflow !!!");
		}
		else{
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	void peek() {
		if(head == null) {
			System.out.println("stack is underflow ");
		}
		else {
			System.out.println(head.val);
		}
	}
	
	
	boolean isEmpty() {
		
		if(head == null) return true;
		return false;
	}
	
	
	void delete(){
		head = null;
	}
	
	public static void main(String arrs[]) {
		
		StackLinkedListImpl stackLinkedListImpl = new StackLinkedListImpl();
		stackLinkedListImpl.create();
		stackLinkedListImpl.push(3);
		stackLinkedListImpl.push(33);
		stackLinkedListImpl.push(333);
		stackLinkedListImpl.push(3333);
		stackLinkedListImpl.peek();
		stackLinkedListImpl.pop();
		System.out.println(stackLinkedListImpl.isEmpty());
		stackLinkedListImpl.delete();
	}

}
