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
		for(int k = 0 ; k < searchWord.length(); k++) {
			char ch = searchWord.charAt(k);
			TrieNode newNode = currNode.child.get(ch);
			if(newNode == null) return false;
			currNode = newNode; 
		}
		
		
		return currNode.endOfWord;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.createTrie();
		trie.insert("apple");
		trie.insert("orange");
		System.out.println(trie.prefixSearch("app"));
		System.out.println(trie.prefixSearch("orgn"));
		System.out.println(trie.searchWord("apple"));
	}

}
