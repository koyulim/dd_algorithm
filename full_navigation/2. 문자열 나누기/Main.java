import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		List<String[]> arr = new ArrayList<>();
		TreeMap<String, Integer> map = new TreeMap<>();
		
		String a = "";
		String b = "";
		String c = "";
		for (int i = 0; i < n - 2; i++) {
			a += str.charAt(i);
			b = "";
			for (int j = i + 1; j < n - 1; j++) {
				b += str.charAt(j);
				c = "";
				for (int z = j + 1; z < n; z++) {
					c += str.charAt(z);
				}
				map.put(a, 0);
				map.put(b, 0);
				map.put(c, 0);
				arr.add(new String[]{a, b, c});
			}
		}
		
		int index = 1;
		for (String s : map.keySet()) {
			map.put(s, index);
			index++;
		}
		
		int result = 0;
		for (String[] list : arr) {
			String x = list[0];
			String y = list[1];
			String z = list[2];
			
			int v = map.get(x) + map.get(y) + map.get(z);
			result = Math.max(result, v);
		}
		
		bw.write(result + "\n");
		bw.flush();
	}
}