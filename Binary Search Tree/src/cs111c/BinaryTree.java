package cs111c;

import java.util.*;

/**
   A class that implements the ADT binary tree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class BinaryTree<T> extends LinkedStack<T> implements BinaryTreeInterface<T>,StackInterface<T> {

    private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	} // end default constructor

	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	} // end constructor

	public BinaryTree(T rootData, BinaryTree<T> leftTree,
					  BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	} // end constructor

	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	} // end setTree

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
						BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>) leftTree,
				(BinaryTree<T>) rightTree);
	} // end setTree

	private void privateSetTree(T rootData, BinaryTree<T> leftTree,
								BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);

		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);

		if ((rightTree != null) && !rightTree.isEmpty()) {
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		} // end if

		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();

		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	} // end privateSetTree

	public T getRootData() {
		if (isEmpty())
			throw new IllegalStateException();
		else
			return root.getData();
	} // end getRootData

    public boolean isEmpty() {
		return root == null;
	} // end isEmpty

	public void clear() {
		root = null;
	} // end clear

	protected void setRootData(T rootData) {
		root.setData(rootData);
	} // end setRootData

	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	} // end setRootNode

	protected BinaryNode<T> getRootNode() {
		return root;
	} // end getRootNode

	public int getHeight() {
		return root.getHeight();
	} // end getHeight

	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	public Iterator<T> getPreorderIterator() {
		return null;
	}

	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	public Iterator<T> getPostorderIterator() {return null; }

	public Iterator<T> getLevelOrderIterator() {
		return null;
	}
	
	private class InorderIterator implements Iterator<T>
	{
	   private StackInterface<BinaryNode<T>> nodeStack;
	   private BinaryNode<T> currentNode;

	   public InorderIterator()
	   {
	      nodeStack = new LinkedStack<>();
	      currentNode = root;
	   } // end default constructor

	   public boolean hasNext() 
	   {
	      return !nodeStack.isEmpty() || (currentNode != null);
	   } // end hasNext

	   public T next()
	   {
	      BinaryNode<T> nextNode = null;

	      // Find leftmost node with no left child
	      while (currentNode != null)
	      {
	         nodeStack.push(currentNode);
	         currentNode = currentNode.getLeftChild();
	      } // end while

	      // Get leftmost node, then move to its right subtree
	      if (!nodeStack.isEmpty())
	      {
	         nextNode = nodeStack.pop();
	         assert nextNode != null; // Since nodeStack was not empty
	                                  // before the pop
	         currentNode = nextNode.getRightChild();
	      }
	      else
	         throw new NoSuchElementException();

	      return nextNode.getData(); 
	   } // end next

	   public void remove()
	   {
	      throw new UnsupportedOperationException();
	   } // end remove
	} // end InorderIterator
}

