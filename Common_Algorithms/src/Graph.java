import java.util.ArrayList;
import java.util.List;

public class Graph {
	static List<Node> graph= new ArrayList<Node>();
	public static class Node{
		public int val;
		public ArrayList<Node> adjacentNodes;
		@Override
		public String toString() {
			return "Node [val=" + val + ", adjacentNodes=" + adjacentNodes + "]";
		}
		public Node(int val){
			this.val=val;
			this.adjacentNodes = new ArrayList<Node>();
		}
		public void addConnection(Node a){
			adjacentNodes.add(a);
		}
		
	}
	public static void main(String args[]){
		
	}
	public static void addConnection(int a, int b){
		if (checkNodesExist(a) && checkNodesExist(b)){
			Node bNode=null;
			for(Node n:graph){
				if (n.val==b)
					bNode=n;
			}
			for(Node n:graph){
				if (n.val==a){
					n.addConnection(bNode);
				}
			}
		}
		
	}
	public static boolean checkNodesExist(int a){
		for(Node n:graph){
			if (n.val==a)
				return true;	
		}
		return false;
	}
}
