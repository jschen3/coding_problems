package problem10;

import java.util.ArrayList;
import java.util.Scanner;

public class EquilibriumSum {
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		String s=sc.next();
		String[] sArray = s.split(",");
		int[] intArray = new int[sArray.length];
		int c=0;
		for (String b:sArray){
			intArray[c]=Integer.parseInt(b);
			c++;
		}
		ArrayList<Integer> points = new ArrayList<Integer>();
		equilibriumPoints(intArray,points);
		System.out.println(points);
	}
	public static void equilibriumPoints(int[] intArray, ArrayList<Integer> points){
		int totalSum=0;
		for (int num:intArray){
			totalSum+=num;
		}
		int curSum=0;
		if (curSum==totalSum)
			points.add(0);
		for (int i=1;i<intArray.length;i++){
			curSum+=intArray[i-1];
			int rightSum=totalSum-curSum;
			if (curSum==rightSum)
				points.add(i);
		}
	}
}
