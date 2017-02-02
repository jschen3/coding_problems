package problem13;

import java.util.ArrayList;
import java.util.List;

public class TreePaths {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			val=x;
		}
	}
	public static void main (String args[]){
		TreeNode root = setUpTree();
		System.out.println(binaryTreePaths(root));
	}
	public static TreeNode setUpTree(){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left=b;
		a.right=c;
		
		TreeNode d= new TreeNode(4);
		TreeNode e = new TreeNode(5);
		b.left=d;
		b.right=e;
		
		TreeNode f  = new TreeNode(6);
		e.right=f;
		
		TreeNode g = new TreeNode(7);
		TreeNode h = new TreeNode(8);
		f.left=g;
		f.right=h;
		
		TreeNode i = new TreeNode(9);
		c.right=i;
		
		TreeNode j = new TreeNode(10);
		TreeNode k = new TreeNode(11);
		i.left=j;
		i.right=k;
		return a;
	}
	public static List<String> binaryTreePaths(TreeNode root){
		String currentPath = "";
		List<String> pathList = new ArrayList<String>();
		binaryTreePathsHelper(root, currentPath, pathList);
		return pathList;
	}
	public static void binaryTreePathsHelper(TreeNode root,String currentPath, List<String> pathList){
		if (root==null)
			return;
		else if (root.left==null && root.right==null){
			currentPath = currentPath + root.val+"";
			pathList.add(currentPath);
			return;
		}
		else if (root.left==null && root.right!=null){
			currentPath = currentPath + root.val+",";
			binaryTreePathsHelper(root.right, currentPath, pathList);
		}
		else if (root.right==null && root.left!=null){
			currentPath = currentPath + root.val+",";
			binaryTreePathsHelper(root.left, currentPath, pathList);
		}
		else{
			currentPath = currentPath + root.val+",";
			binaryTreePathsHelper(root.left, currentPath,pathList);
			binaryTreePathsHelper(root.right, currentPath, pathList);
		}
	}
	
}
