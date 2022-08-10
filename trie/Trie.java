package trie;

import java.util.*;

public class Trie {
	
	// Trie class
	
	private class TrieNode{
		boolean endOfWord;
		Map<Character, TrieNode> child;
		
		TrieNode() {
			this.child = new HashMap<Character, TrieNode>();
			this.endOfWord = false;
		}
	}
	
	private TrieNode root;
	public void createTrie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for(int i = 0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode newNode = current.child.get(ch);
			if (newNode == null) {
				newNode = new TrieNode();
				current.child.put(ch, newNode);
			}
			current = newNode; 
		}
			
		current.endOfWord = true;
		System.out.println("sucessfully inserted into the Trie: " + word);
		
	}
	
	public boolean prefixSearch(String perfixSearch) {
		TrieNode currNode = root;
		for(int j = 0; j<perfixSearch.length(); j++) {
			char ch = perfixSearch.charAt(j);
			TrieNode newNode = currNode.child.get(ch);
			if(newNode == null) {
				return false;
			}
			currNode = newNode; 
		}
		return true;
	}
	
	public boolean searchWord(String searchWord) {
		
		TrieNode currNode = root;
		for(int k = 0; k < searchWord.length(); k++) {
			char ch = searchWord.charAt(k);
			TrieNode newNode = currNode.child.get(ch);
			if(newNode == null) return false;
			currNode = newNode; 
		}
		
		
		return currNode.endOfWord;
	}
	
	
	public void deleteWord(String word) {
		if(searchWord(word) == true) {
			delete(root, word, 0);
		}
	}
	
	private boolean delete(TrieNode currNode, String word, int index) {
		
		if(index == word.length()) {
			if(!currNode.endOfWord) {
				return false;
			}
			currNode.endOfWord = false;
			return currNode.child.size() == 0;
		}
		
		char ch = word.charAt(index);
		TrieNode newNode = currNode.child.get(ch);
		if(newNode == null) {
			return false;
		}
		
		boolean deleteNode = delete(newNode, word, index+1);
		if(deleteNode) {
			currNode.child.remove(ch);
			return currNode.child.size() == 0;
		}
		
		
		
		return false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.createTrie();
		trie.insert("apple");
		trie.insert("orange");
		System.out.println(trie.prefixSearch("app"));
		System.out.println(trie.searchWord("apple"));
		trie.deleteWord("orange");
		System.out.println(trie.searchWord("orange"));
		
	}

}
