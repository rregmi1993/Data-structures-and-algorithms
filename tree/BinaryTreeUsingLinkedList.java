package tree;

import java.util.*;
public class BinaryTreeUsingLinkedList {
	
	private class Node{
		int value;
		Node left, right;
		
		Node(int val){
			this.value = val;
		}
		
		/*
		 * Node(int val, Node left, Node right){ this.value = val; this.left = left;
		 * this.right = right; }
		 */
	}

	Node root;
	
	void createBinaryTree(){
		root = null;
	}
	
	void insertInBinaryTree(int val) {
		Node newNode = new Node(val);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(! queue.isEmpty()) {
			Node currNode = queue.remove();
			
			if(currNode.left == null) {
				currNode.left = newNode;
				break;
			}
			else if(currNode.right == null) {
				currNode.right = newNode;
				break;
			}
			else {
				queue.add(currNode.left);
				queue.add(currNode.right);
			}
			
		}
		
	}
	
	void search(int val) {
		
		if(root == null) {
			System.out.println("Binary Tree is empty !!!");
		}
		else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node currNode = queue.remove();
				
				if(currNode.value == val) {
					System.out.println("Number: " + val + " is found!");
					return;
				}
				else {
					if(currNode.left != null){
						queue.add(currNode.left);
					}
					if(currNode.right != null) {
						queue.add(currNode.right);
					}
				}
			}
		}
		System.out.println("Number: " + val + " is not found ");
	}
	
	
	void deleteNode(int val) {
		if(root == null) {
			System.out.println("Tree is Empty !!!");
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node currNode = queue.remove();
			
			if(currNode.value == val) {
				currNode.value = getDeepestNode().value;
				deleteDeepestNode();
				break;
			}
			
			if(currNode.left != null) {
				queue.add(currNode.left);
			}
			if(currNode.right != null) {
				queue.add(currNode.right);
			}
		}
	}
	
	
	private Node getDeepestNode() {
		
		if(root == null) {
			System.out.println("Tree is Empty !!!");
			return null;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node currNode = null;
		while(!queue.isEmpty()) {
			currNode = queue.remove();
			if(currNode.left != null) {
				queue.add(currNode.left);
			}
			if(currNode.right != null) {
				queue.add(currNode.right);
			}
		}
		
		return currNode; 
	}
	
	
	private void deleteDeepestNode() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node prevNode, currNode = null;
		while (!queue.isEmpty()) {
			prevNode = currNode;
			currNode = queue.remove();
			if (currNode.left == null) {
				prevNode.right = null;
				return;
			} else if (currNode.right == null) {
				currNode.left = null;
				return;
			}
			queue.add(currNode.left);
			queue.add(currNode.right);
		}
	}
	
	
	public static void main(String arrs[]) {
		BinaryTreeUsingLinkedList bt = new BinaryTreeUsingLinkedList();
		bt.createBinaryTree();
		bt.insertInBinaryTree(1);
		bt.insertInBinaryTree(2);
		bt.insertInBinaryTree(3);
		bt.search(11);
		bt.deleteNode(1);
		bt.search(1);
	}
}
