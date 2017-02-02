import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	private static Node root;
	private static Stack<Node> stack;
	public class Node{
		int val;
		Node left;
		Node right;
		public Node(int val){
			this.val=val;
		}
		public String toString(){
			return val+" , ";
		}
	}
	public Node remove(int val, Node node) {
		if (node==null)
			return node;
		if (node.val>val){
			node.right=remove(val, node.right);
		}
		else if(node.val<val){
			node.left=remove(val, node.left);
		}
		else{
			if (node.left!=null && node.right!=null){
				node.val=minValue(node.right);
				node.right=remove(node.right.val, node.right);
			}
			else if (node.left==null)
				node=node.right;
			else if (node.right==null)
				node=node.left;	
			else
				node=null;
		}
		return node;
	}
	private int minValue(Node node) {
		if (node.left == null)
            return node.val;
       else
           return minValue(node.left);
	}
	public void add(int val){
		root=addHelper(val, root);
		if (stack==null){
			stack=new Stack<Node>();
			stack.add(root);
		}
	}
	public Node addHelper(int val, Node node){
		if (node==null){
			node = new Node(val);
		}
		else{
			if (node.val<val){
				if (node.right==null){
					node.right=new Node(val);
				}
				else{
					node.right=addHelper(val, node.right);
				}
			}
			else{
				if (node.left==null){
					node.left=new Node(val);
				}
				else{
					node.left=addHelper(val, node.left);
				}
			}
		}
		return node;
	}
	public String inOrderToString(){
		StringBuilder s = new StringBuilder();
		inOrderToStringHelper(root, s);
		return s.toString();
	}
	public void inOrderToStringHelper(Node node, StringBuilder toString){
		if (node==null)
			return;
		else
			if (node.left!=null){
				inOrderToStringHelper(node.left, toString);
			}
			toString.append(node.val+",");
			if (node.right!=null){
				inOrderToStringHelper(node.right, toString);
			}
			return;
	}
	public String levelOrderToString(){
		StringBuilder s = new StringBuilder();
		Queue<Node> stack = new LinkedList<Node>();
		stack.add(root);
		while(!stack.isEmpty()){
			Node n=stack.poll();
			s.append(n.val+", ");
			if (n.left!=null)
				stack.add(n.left);
			if (n.right!=null)
				stack.add(n.right);
		}
		return s.toString();
	}
	public void remove(int val){
		root=remove(val, root);
		stack=new Stack<Node>();
		stack.add(root);
	}
	public static boolean hasNext(){
		if (stack.isEmpty())
			return false;
		else
			return true;
			
	}
	public static Node next(){
		Node n = stack.pop();
		if (n.right!=null){
			Node temp=n.right;
			while(temp!=null){
				stack.add(temp);
				temp=temp.left;
			}
		}
		return n;	
	}
	public static void main(String args[]){
		BinarySearchTree b = new BinarySearchTree();
		b.add(5);
		b.add(6);
		b.add(4);
		b.add(10);
		b.add(1);
		b.add(7);
		b.add(8);
		System.out.println(b.inOrderToString());
		while(b.hasNext()){
			System.out.print(b.next());
		}
		System.out.println();
		b.remove(5);
		while(b.hasNext()){
			System.out.print(b.next());
		}
		System.out.println();
		System.out.println(b.inOrderToString());
		System.out.println(b.levelOrderToString());
	}
	
	
}
