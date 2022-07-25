package bst;

import java.awt.geom.CubicCurve2D;

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
    
    
    public void delete(int value) {
    	if(root == null) {
    		System.out.println("Invalid Operation !!!");
    		return;
    	}
    	deleteNode(root, value);
    }

    private Node deleteNode(Node root, int value) {
    	
    	if(root.value > value) {
    		root.left = deleteNode(root.left, value);
    	}
    	else if(root.value < value) {
    		root.right = deleteNode(root.right, value);
    	}
    	else {
    		if(root.left != null && root.right != null) {
    			Node tempNode = root;
    			Node minimumNode = getMinimumNode(tempNode.right);
    			root.value = minimumNode.value;
    			root.right = deleteNode(root.right, minimumNode.value);
    		}
    		else if(root.left != null) {
    			root = root.left;
    		}
    		else if(root.right != null) {
    			root = root.right;
    		}
    		else {
    			root = null;
    		}
    	}
    	
    	return root;
    }
    
    public Node getMinimumNode(Node root) {
    	if(root.left == null) {
    		return root;
    	}
    	else {
    		return getMinimumNode(root.right);
    	}
    }
	public static void main(String arrs[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.createBST();
		bst.insert(50);
		bst.insert(30);
	    bst.insert(20);
	    bst.insert(40);
	    bst.insert(70);
	    bst.insert(60);
	    bst.insert(80);
	    bst.delete(20);
	    bst.delete(30);
	    bst.delete(50);
		System.out.println("-----In Order Traversal-------");
		bst.inorder();
		System.out.println("-----Pre Order Traversal-------");
		bst.preorder();
		System.out.println("----------Post Order Traversal ----------");
		bst.postorder();
	}
}