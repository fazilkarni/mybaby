import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BST {
	int prev=Integer.MIN_VALUE;
	boolean isBSTTree=true;
	public static void main(String[] args) {
		BST bst = new BST();
		Node head = new Node(100);
		head.left = new Node(90);
		head.right = new Node(105);
		head.left.left = new Node(80);
		head.left.right = new Node(95);
		head.right.right = new Node(110);
		head.right.left = new Node(102);
		head.right.left.left = new Node(101);
//		head.left.left.left = new Node(75);
//		head.left.left.right = new Node(85);
//		head.right.left = new Node(102);
//		head.right.right = new Node(110);
//		head.right.right.left = new Node(108);
//		head.right.right.right = new Node(111);
		System.out.println("Pre order traversal");
		bst.preOrderTraversal(head);
		System.out.println("\nIn order traversal");
		bst.inOrderTraversal(head);
		System.out.println("\npost order traversal");
		bst.postOrderTraversal(head);
		bst.q.add(head);
		System.out.println("\nLevel order traveral");
		bst.levelOrderTraversal();
		
		System.out.println("\nMax element of the tree:"+bst.maxElementOfBST(head).key);
		
		System.out.println("\nMin element of the tree:"+bst.minElementOfBST(head).key);
		
		System.out.println("\nMin height of BST:"+bst.minHeight(head));
		
		System.out.println("\nMax height of BST:"+bst.maxHeight(head));
		
		System.out.println("Given tree is BST:"+bst.checkBST(head));
		
		System.out.println("Give tree is BST(inorder traversal approach:"+bst.isBSTInorderSecondApproach(head));

	}
	
	public void preOrderTraversal(Node node){
		if(node==null)return ;
		System.out.print(node.key+", ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	public void inOrderTraversal(Node node){
		if(node==null)return ;
		inOrderTraversal(node.left);
		System.out.print(node.key+", ");
		inOrderTraversal(node.right);
	}
	
	public void postOrderTraversal(Node node){
		if(node==null)return ;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.key+", ");
	}
	Queue<Node> q = new ArrayDeque<Node>();
	public void levelOrderTraversal(){
		if(!q.isEmpty()){
			Node head = q.poll();
			System.out.print(head.key+", ");
			if(head.left!=null) q.offer(head.left);
			if(head.right!=null)q.offer(head.right);
			levelOrderTraversal();
		}
		
	}
	Node maxNode;
	public Node maxElementOfBST(Node head){
		
		if(head.right!=null){
			maxNode = head.right;
			maxElementOfBST(maxNode);
		}
		return maxNode;
	}
	
	public Node minElementOfBST(Node head){
		
		if(head.left!=null){
			maxNode = head.left;
			minElementOfBST(maxNode);
		}
		return maxNode;
	}
	
	public int maxHeight(Node head){
		
		if(head==null)return -1;
		return Math.max(maxHeight(head.left), maxHeight(head.right))+1;
		
	}
	
	public int minHeight(Node head){
		if(head==null) return -1;
		return Math.min(minHeight(head.left),minHeight(head.right))+1;
	}
	
	public boolean checkBST(Node head){
		return isBST(head,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	/**
	 * Considering the some smallest and biggest integer to compare with the node. Second approach is traverse in inorder.
	 * If order is increaing then its bst ele not.
	 * @param head
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean isBST(Node head,int min,int max){
		if(head==null)return true;
		if(head.key>min&&head.key<max&&isBST(head.left,min,head.key)&&isBST(head.right,head.key,max)){
			return true;
		}else{
			return false;
		}
	}
	public boolean isBSTInorderSecondApproach(Node head){
		iBSTInOrder(head);
		return isBSTTree;
	}
	public void iBSTInOrder(Node head){
		if(head==null) return;
		iBSTInOrder(head.left);
		if(prev>head.key){
			isBSTTree=false;return;
		}else{
			prev=head.key;
		}
		iBSTInOrder(head.right);
	}
	
	
	/**
	 * Find the nth min element of the bst
	 */
	
	public Node findNthMinElement(Node node, int n){
		if(node ==null) return null;
		
		
		
	}
}

class Node{
	int key;
	Node left;
	Node right;
	public Node(int key){
		this.key=key;
	}
}