import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class WordBFS {
	public static void main(String args[]){
		String[] words={"ban", "cog", "cat", "fog","fan","fon","dog","bog"};
		int[][] distances = createDistancesGrid(words);
		List<String> path=wordBFS(words,"ban","cog");
		System.out.println(path);
		
	}
	private static List<String> wordBFS(String[] words, String start, String end){
		int startIndex=findIndexWord(words, start);
		int endIndex=findIndexWord(words, end);
		int[][] distancesGrid = createDistancesGrid(words);
		List<String> currentPath = new ArrayList<String>();
		currentPath.add(start);
		Stack<Integer> posLocs = null;
		boolean[] visited=new boolean[words.length];
		visited[startIndex]=true;
		wordBFSHelper(words, distancesGrid, currentPath, startIndex, endIndex, posLocs, visited);
		return currentPath;
	}
	private static void wordBFSHelper(String[] words,int[][] distancesGrid, List<String> currentPath, int current, int end, Stack<Integer> possLocations, boolean[] visited){
		//redo to return shortest path not just a path
		if (current==end){
			return;
		}
		else{
			if (possLocations==null){
				possLocations = new Stack<Integer>();
			}
			Collection<Integer> possHops = getPossibleWordHop(current, distancesGrid, end);
			possLocations.addAll(possHops);
			while(possLocations.size()>0){
				int newLoc = possLocations.pop();
				if (visited[newLoc]==false){
					visited[newLoc]=true;
					currentPath.add(words[newLoc]);
					wordBFSHelper(words, distancesGrid, currentPath, newLoc, end, possLocations, visited);
				}
			}
		}
	}
	private static int hammingDistance(String a, String b){
		if (a.length()!=b.length())
			return -1;
		else{
			int distance=0;
			for(int i=0;i<a.length();i++){
				if (a.charAt(i)!=b.charAt(i))
					distance++;
			}
			return distance;
		}
	}
	private static int[][] createDistancesGrid(String[] words){
		int[][] distances = new int[words.length][words.length];
		for (int i=0;i<words.length;i++){
			for(int j=i;j<words.length;j++){
				int distance=hammingDistance(words[i],words[j]);
				distances[i][j]=distance;
				distances[j][i]=distance;
			}
		}
		return distances;
	}
	private static int findIndexWord(String[] words, String a){
		for(int i=0;i<words.length;i++){
			if (words[i].equals(a))
				return i;
		}
		return -1;
	}
	private static Collection<Integer> getPossibleWordHop(int location, int[][] distancesGrid, int end){
		Collection<Integer> locations = new ArrayList<Integer>();
		if (distancesGrid[location][end]==1){
			locations.add(end);
			return locations;
		}
		for(int i=0;i<distancesGrid[location].length;i++){
			if (distancesGrid[location][i]==1){
				locations.add(i);
			}
		}
		return locations;
	}
	
}
