import java.io.*;
import java.util.*;

// 이분 탐색으로 해결결
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] list = new int[a];
		for (int i = 0; i < a; i++) {
			list[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(list);
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			int b = Integer.parseInt(br.readLine());
			if (Arrays.binarySearch(list, b) >= 0) {
				bw.write("1" + "\n");
			} else {
				bw.write("0" + "\n");
			}
		}
		bw.flush();
	}
}

// HashSet으로 해결
// public class Main {
// 	public static void main(String[] args) throws Exception {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		HashSet<Integer> set = new HashSet<>();
		
// 		int a = Integer.parseInt(br.readLine());
// 		String[] input = br.readLine().split(" ");
// 		int[] list = new int[a];
// 		for (int i = 0; i < a; i++) {
// 			set.add(Integer.parseInt(input[i]));
// 		}
		
// 		int m = Integer.parseInt(br.readLine());
// 		for (int i = 0; i < m; i++) {
// 			int b = Integer.parseInt(br.readLine());
// 			if (set.contains(b)) {
// 				bw.write("1" + "\n");
// 			} else {
// 				bw.write("0" + "\n");
// 			}
// 		}
// 		bw.flush();
// 	}
// }