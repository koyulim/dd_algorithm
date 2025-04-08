import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new TreeMap();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			String s = input[0];
			int a = Integer.parseInt(input[1]);
			
			map.put(s, map.getOrDefault(s, 0) + a);
		}
		
		for (String s : map.keySet()) {
			bw.write(s + " " + map.get(s) + "\n");
		}
		bw.flush();
	}
}