import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] list = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			list[i][0] = Integer.parseInt(input[0]);
			list[i][1] = Integer.parseInt(input[1]);
			list[i][2] = i;
		}
		
		Arrays.sort(list, (a, b) -> {
			if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
			return Integer.compare(a[0], b[0]);
		});
		
		
		int[] cnt = new int[n];
		for (int i = 0; i < n; i++) {
			cnt[list[i][2]] = n - i - 1;
		}
		
		for (int i = 0; i < n; i++) {
			 bw.write(cnt[i] + "\n");
		}
		bw.flush();
	}
}