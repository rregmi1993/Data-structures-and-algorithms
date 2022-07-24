package bst;

public class BinarySearchTree {

	class Node {
		Node left;
		int value;
		Node right;
		Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	
	Node root; 
	
	public void createBST() {
		root = null;
		System.out.println("BST is created");
	}
	
	
	public void insert(int value) {
		root = insertBST(root, value);
	}
	
	
	private Node insertBST(Node currNode, int value) {
		Node newNode = new Node(value);
		if(currNode == null) {
			currNode = newNode;
			return currNode;
		}
		else if(currNode.value > value) {
			currNode.left = insertBST(currNode.left, value);
			return currNode;
		}
		else {
			currNode.right = insertBST(currNode.right, value);
			return currNode;
		}
	}
	
    public void inorder() { inorderTrav(root); }
 
    private void inorderTrav(Node root)
    {
        if (root != null) {
        	inorderTrav(root.left);
            System.out.println(root.value);
            inorderTrav(root.right);
        }
    }
 
    public void preorder() { preorderTrav(root); }
    
    private void preorderTrav(Node root)
    {
        if (root != null) {
        	System.out.println(root.value);
        	preorderTrav(root.left);
        	preorderTrav(root.right);
        }
    }
 
	
    public void postorder() { postorderTrav(root); }
	
    private void postorderTrav(Node root) {
		
    	if(root != null) {
    		postorderTrav(root.left);
    		postorderTrav(root.right);
    		System.out.println(root.value);
    	}
		
	}

	public static void main(String arrs[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.createBST();
		bst.insert(10);
		bst.insert(20);
		bst.insert(5);
		System.out.println("-----In Order Traversal-------");
		bst.inorder();
		System.out.println("-----Pre Order Traversal-------");
		bst.preorder();
		System.out.println("----------Post Order Traversal ----------");
		bst.postorder();
	}
}