import java.io.*;
public class Main {
	
	private static int n;
	private static long k, result;
	private static int[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(input[i]);
		}
		k = Long.parseLong(br.readLine());

		result = Long.MAX_VALUE;
		solve(0);
		
		bw.write(result + "\n");
		bw.flush();
	}
	
	private static void solve(long v) {
		if (v > k) {
			result = Math.min(result, v);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (list[i] == 0 && v == 0) continue;
			solve(v * 10 + list[i]);
		}
	}
}