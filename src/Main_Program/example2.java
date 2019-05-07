package Main_Program;

import java.util.ArrayList;

public class example2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> B = new ArrayList<Integer>();
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i=0; i<5; i++) A.add(i);
		for (int i=5; i<10; i++) B.add(i);
		for(int c: B) System.out.print(c+" ");
	}

}
