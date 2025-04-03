import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		TreeSet<String> mapA = new TreeSet<>();
		TreeSet<String> mapB = new TreeSet<>();
		
		String[] aList = br.readLine().split(" ");
		String[] bList = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			mapA.add(aList[i]);
			mapB.add(bList[i]);
		}
		
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			String a = input[0];
			String b = input[1];
			
			if (mapA.contains(a) && mapB.contains(b)) {
				mapA.add(b);
				mapB.add(a);
				mapA.remove(a);
				mapB.remove(b);
			}
		}
		
		for (String s : mapA) {
			bw.write(s + " ");
		}
		bw.write("\n");
		bw.flush();
	}
}