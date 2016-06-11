package com.VmWare;

public class TrieImplementation {
	Node head;
	public static void main(String[] args) {
		TrieImplementation trie = new TrieImplementation();
		trie.insert("Fazil");
		System.out.println("Inserted successfully and head is at "+trie.head.key);
		trie.insert("karni");
		trie.insert("Mohammed");
		trie.insert("Faiz");
		System.out.println("Key found ?:"+trie.search("Faiz"));
		System.out.println("Key found ?:"+trie.search("Fazil"));
		System.out.println("Key found ?:"+trie.search("karani"));
		System.out.println("Key found ?:"+trie.search("karni"));
		System.out.println("Key found ?:"+trie.search("Mohammed"));

	}
	public Boolean search(String find){
		
		Node pointer = head;
		int counter = 0;
		while(pointer!=null&&counter<find.length()){
			if(pointer.key != find.charAt(counter)){
				pointer = pointer.sibling;
			}else{
				pointer = pointer.child;
				counter++;
			}
		}
		
		if(counter==find.length()){
			return true;
		}else{
			return false;
		}
		
	}
	public  void insert(String word){
		int counter=0;
		int wordLength = word.length();
		boolean inserSibling = false;
		Node parent = null;
			Node pointer = head;
			while(pointer!=null&&counter<wordLength){
				parent = pointer;
				if(pointer.key!=word.charAt(counter)){
					pointer = pointer.sibling;
					inserSibling = true;
				}else{
					inserSibling = false;
					pointer = pointer.child;
					counter++;
				}
			}
			Node node = null;
			while(counter<wordLength){
				node = new Node(word.charAt(counter++));
				if(parent==null){
					head=parent = node;
				}else if(inserSibling){
					inserSibling = false;
					parent.sibling = node;
					parent = parent.sibling;
				}else{
					parent.child = node;
					parent = parent.child;
				}
				
			}
			parent.isWord = true;
		}
	
	
	
	class Node{
		char key;
		Node child;
		Node sibling;
		boolean isWord;
		
		public Node(char key){
			this.key = key;
			this.child = null;
			this.sibling = null;
		}
	}
	
   

}
