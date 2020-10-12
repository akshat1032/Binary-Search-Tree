package com.capgemini.binarysearchtree;

public class BinaryNode<K extends Comparable<K>> {
	//Instance variable for node of the tree
	K key;
	BinaryNode left;
	BinaryNode right;

	//Initializing the node with key
	public BinaryNode(K key) {
		this.key = key;
		left = null;
		right = null;
	}
}
