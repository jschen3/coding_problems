import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeSum {
	public static class Node{
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
	public static void main(String args[]){
		Node n = createTree();
		System.out.println(findSumPaths(7, n));
	}
	private static Set<ArrayList<Integer>> findSumPaths(int i, Node n) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		Set<ArrayList<Integer>> solutionPaths = new HashSet<ArrayList<Integer>>();
		findSumPaths(solutionPaths, i, path, 0, n);
		return solutionPaths;
		
	}
	private static void findSumPaths(Set<ArrayList<Integer>> solutionPaths , int goal, ArrayList<Integer> currentPath, int current, Node currentNode){
		if (current==goal){
			solutionPaths.add(currentPath);
		}
		if (currentNode==null)
			return;
		else{
			ArrayList<Integer> clone = clone(currentPath);
			clone.add(currentNode.val);
			currentPath.add(currentNode.val);
			int sum = current+currentNode.val;
			findSumPaths(solutionPaths, goal, clone, current+currentNode.val, currentNode.left);
			findSumPaths(solutionPaths, goal, currentPath, current+currentNode.val, currentNode.right);
			ArrayList<Integer> startPathHere = new ArrayList<Integer>();
			ArrayList<Integer> clone2 = new ArrayList<Integer>();
			startPathHere.add(currentNode.val);
			clone2.add(currentNode.val);
			findSumPaths(solutionPaths, goal, startPathHere, currentNode.val, currentNode.left);
			findSumPaths(solutionPaths, goal, clone2, currentNode.val, currentNode.right);
			
		}
	}
	public static ArrayList<Integer> clone(ArrayList<Integer> list){
		ArrayList<Integer> clone = new ArrayList<Integer>();
		for(Integer i:list){
			clone.add(i);
		}
		return clone;
	}
	public static Node createTree(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n7 = new Node(6);
		Node n9 = new Node(7);
		n1.right=n3;
		n1.left = n2;
		n3.right=n9;
		n3.left= n7;
		n2.left=n4;
		n2.right=n5;
		return n1;
	}
}
