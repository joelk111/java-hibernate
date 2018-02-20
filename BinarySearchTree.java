package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;

public class BinarySearchTree {
	
	
	//Refrence for the root of the tree.
	
	//https://javabeat.net/binary-search-tree-traversal-java/
	public static Node root;

	public static void main(String[] args) {

	

		/**
		 * class Node {
	  //The value present in the node.
	  public int val;

	  //The reference to the left subtree.
	  public Node left;

	  //The reference to the right subtree.
	  public Node right;
	  
	  //constructor
		Node(int x) { val = x; }

}
 
		 */
		
		
		// create a new BST and insert some data. The POJO is called Node.
		
		  BinarySearchTree bst = new BinarySearchTree();
		  
		 
		    bst.insert(40);
		    bst.insert(25);
		    bst.insert(78);
		    bst.insert(10);
		    bst.insert(3);
		    bst.insert(17);
		    bst.insert(32);
		    bst.insert(30);
		    bst.insert(38);
		    bst.insert(78);
		    bst.insert(50);
		    bst.insert(93);
		    System.out.println("Inserted all the data");
		
		
		int min=findMinimum();
		System.out.println(min);
		
		
		int max =findMaximum();
		
		System.out.println(max);
		
/*		List<Integer> inorderTraversal =inorderTraversal(root);
		    
		inorderTraversal.forEach(System.out::println);
						//replaceAll(String::toUpperCase);
		
		
		boolean validate= isValidBST(root);  
		System.out.println(validate);*/
		
		
	//	bst.processBST();
		
		 
		
		printPostorder(root);
		
		
		
		

	}
	
	
	private boolean processBST() {
		
		
		
		boolean validate= isBST(); 
		
		
		//supplyAsync takes a Supplier containing the code we want to execute asynchronously — in our case the sendMsg method.
		
	//	CompletableFuture.supplyAsync(BinarySearchTree::isBST).thenAccept(this::insert);
		
		return validate;
	}
	
    // This method mainly calls insertRec()
    void insert(int key) {
       root = insertRec(root, key);
    }
     
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
	

	
	
	
	
	/**
	 * Returns the minimum value in the Binary Search Tree.
	 */
	public static int findMinimum(){
	  if ( root == null ){
	    return 0;
	  }
	  
	  Node currNode = root;
	  while(currNode.left != null){
	    currNode = currNode.left;
	  }
	  return currNode.val;
	}	
	
	
	
	/**
	 * Returns the maximum value in the Binary Search Tree
	 */
	public static int findMaximum(){
	  if ( root == null){
	    return 0;
	  }

	  Node currNode = root;
	  while(currNode.right != null){
	    currNode = currNode.right;
	  }
	  return currNode.val;
	}	
	
	

public static List<Integer> inorderTraversal(Node root) {
    List<Integer> result = new ArrayList<Integer>();
    
    
    if(root==null)
        return result;
    
    
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
 
    while(!stack.isEmpty()){
        Node top = stack.peek();
        
        if(top.left!=null){
            stack.push(top.left);
            top.left=null;
            
        }else{
            result.add(top.val);
            stack.pop();
            
            
            if(top.right!=null){
                stack.push(top.right);
            }
        }
    }
 
    return result;
}
	

public ArrayList<Integer> preorderTraversal(Node root) {
    ArrayList<Integer> returnList = new ArrayList<Integer>();

    if(root == null)
        return returnList;

    Stack<Node> stack = new Stack<Node>();
    stack.push(root);

    while(!stack.empty()){
        Node n = stack.pop();
        returnList.add(n.val);

        if(n.right != null){
            stack.push(n.right);
        }
        if(n.left != null){
            stack.push(n.left);
        }

    }
    return returnList;
}



public List<Integer> postorderTraversal(Node root) {
    List<Integer> res = new ArrayList<Integer>();
 
    if(root==null) {
        return res;
    }
 
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
 
    while(!stack.isEmpty()) {
        Node temp = stack.peek();
        if(temp.left==null && temp.right==null) {
            Node pop = stack.pop();
            res.add(pop.val);
        }
        else {
            if(temp.right!=null) {
                stack.push(temp.right);
                temp.right = null;
            }
 
            if(temp.left!=null) {
                stack.push(temp.left);
                temp.left = null;
            }
        }
    }
 
    return res;
}

/*
	 * returns true if given search tree is binary search tree (efficient version)
	 */
	static boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <= max.
	 */
	static boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.val < min || node.val > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.val - 1) && isBSTUtil(node.right, node.val + 1, max));
}
	




/**
 * 
 * isValidBST
 * 
 * To be a valid BST:
 * 
 * 1. Each node must have a key OR associated value.
   2. Each node must have at MOST 2 distinguished sub-trees, commonly denoted left and right.
   3. The key in each node must be greater than all keys stored in the left sub-tree, and smaller than all keys in the right sub-tree.
 * 
 * 
 * Remember, everything on the LEFT is SMALLER, everything on the RIGHT is LARGER.
 * 

 * 
 * 
 * @param root
 * @return
 */
	public static boolean isValidBST(Node root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
	
	
	
    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal.
    
     *POST - L R P
     *
     *
     */
	public static void printPostorder(Node node)
  {
      if (node == null)
          return;

      // first recur on left subtree
      printPostorder(node.left);

      // then recur on right subtree
      printPostorder(node.right);

      // now deal with the node
      System.out.print(node.val + " ");
  }

  /* Given a binary tree, print its nodes in inorder
   * 
   * 
   * INORDER -L P R
   * 
   * 
   * */
	public static void printInorder(Node node)
  {
      if (node == null)
          return;

      /* first recur on left child */
      printInorder(node.left);

      /* then print the data of node */
      System.out.print(node.val + " ");

      /* now recur on right child */
      printInorder(node.right);
  }

  /* Given a binary tree, print its nodes in preorder
   * 
   * 
   * PRE P L R
   * 
   * */
	public static  void printPreorder(Node node)
  {
      if (node == null)
          return;

      /* first print data of node */
      System.out.print(node.val + " ");

      /* then recur on left sutree */
      printPreorder(node.left);

      /* now recur on right subtree */
      printPreorder(node.right);
  }

	public static boolean isValidBST(Node Node, int min, int max) {
		
		
		//here we are checking for a leaf node that terminates( the leaf is null so there is other place to traverse)
		
		if (Node == null)
			return true;
		
		
		
		System.out.println("Comparing " + Node.val + " with " + min + " min value ");
		System.out.println("Comparing " + Node.val + " with " + max + " max value ");
		
		// makes sure that each child node is either less than its parent * 
		//(if it is a left child) or greater than its parent (if it is a right child). 
		
		if (Node.val <= min || Node.val >= max)
			return false;
		
		//Each node must validate its left and right sub tree before the node itself can be considered valid.

		return isValidBST(Node.left, min, Node.val) && isValidBST(Node.right, Node.val, max);
	}
}
