package com.capgemini.binarysearchtree;

public class BinarySearchTree<K extends Comparable<K>> {

	private BinaryNode<K> root;
	private static BinarySearchTree binaryTree = new BinarySearchTree<>();

	// Function to add node which internally calls recursive function
	public void add(K key) {
		this.root = this.addRecursively(root, key);
	}

	// Recursive function to add node to tree
	private BinaryNode<K> addRecursively(BinaryNode<K> current, K key) {
		if (current == null)
			return new BinaryNode<>(key);
		int comparison = key.compareTo((K) current.key);
		if (comparison == 0)
			return current;
		if (comparison < 0) {
			current.left = addRecursively(current.left, key);
		} else {
			current.right = addRecursively(current.right, key);
		}
		return current;
	}

	// Function to get size which internally calls recursive function
	public int getSize() {
		return this.getSizeRecursively(root);
	}

	// Recursive function to get size
	private int getSizeRecursively(BinaryNode<K> current) {
		return current == null ? 0 : 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
	}
	
	//Function to search which internally calls the recursive function
	public BinaryNode<K> searchByKey(K key) {
		return this.searchByKeyRecursively(root, key);
	}
	
	// Recursive function which returns the node at which the element is found
	private BinaryNode<K> searchByKeyRecursively(BinaryNode<K> current, K key) {
		int comparison = current.key.compareTo(key);
		if (comparison == 0) {
			return current;
		} else if (comparison < 0) {
			return this.searchByKeyRecursively(current.right, key);
		} else {
			return this.searchByKeyRecursively(current.left, key);
		}
	}

	// Check if size is correct
	public static void checkSize() {
		// Checking if all elements are added to the tree using getSize() function
		if (binaryTree.getSize() == 13) {
			System.out.println("All elements added to the binary tree");
		} else
			System.out.println("All elements were not added to the binary tree");
	}
	
	//Check if element is found or not
	public static void checkElementFound() {
		BinaryNode searchNode = binaryTree.searchByKey(63);
		if (searchNode.key.equals(63)) {
			System.out.println("Element is present in the binary tree");
		}
		else {
			System.out.println("Element is not present in the binary tree");
		}
	}

	public static void main(String[] args) {

		binaryTree.add(56);
		binaryTree.add(30);
		binaryTree.add(70);
		binaryTree.add(22);
		binaryTree.add(40);
		binaryTree.add(60);
		binaryTree.add(95);
		binaryTree.add(11);
		binaryTree.add(65);
		binaryTree.add(3);
		binaryTree.add(16);
		binaryTree.add(63);
		binaryTree.add(67);
		checkSize();
		checkElementFound();
	}
}
