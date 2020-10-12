package com.capgemini.binarysearchtree;

public class BinarySearchTree<K extends Comparable<K>> {
	
	private BinaryNode<K> root;
	
	//Function to add node which internally calls recursive function
	public void add(K key) {
		this.root = this.addRecursively(root, key);
	}
	
	//Recursive function to add node to tree
	private BinaryNode<K> addRecursively(BinaryNode<K> current, K key) {
		if (current == null) 
			return new BinaryNode<>(key);
		int comparison = key.compareTo((K) current.key);
		if (comparison == 0)
			return current;
		if (comparison < 0) {
			current.left = addRecursively(current.left, key);
		}else {
			current.right = addRecursively(current.right, key);
		}
		return current;
	}
	
	//Printing the tree, root node first, followed by left node and then right node
	private void printTree() {
		System.out.println(this.root.key+" "+this.root.left.key+" "+this.root.right.key);
	}
	public static void main(String[] args) {
		
		BinarySearchTree binaryTree = new BinarySearchTree<>();
		binaryTree.add(56);
		binaryTree.add(30);
		binaryTree.add(70);
		binaryTree.printTree();
	}
}
