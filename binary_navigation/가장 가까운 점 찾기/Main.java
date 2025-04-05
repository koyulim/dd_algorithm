import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nq = br.readLine().split(" ");
		int n = Integer.parseInt(nq[0]);
		int q = Integer.parseInt(nq[1]);
		
		long[] list = new long[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			list[i] = Long.parseLong(input[i]);
		}
		
		Arrays.sort(list);
		
		for (int i = 0; i < q; i++) {
			long key = Long.parseLong(br.readLine());
			
			int l = 0;
			int r = n - 1;
			long a = list[n - 1];
			long b = list[n - 1];
			while (l <= r) {
				int mid = (l + r) / 2;
				
				if (list[mid] < key) {
					l = mid + 1;
					a = list[mid];
				} else {
					r = mid - 1;
					b = list[mid];
				}
			}
			
			if (Math.abs(a - key) > Math.abs(b - key)) {
				bw.write(b + "\n");
			} else if (Math.abs(a - key) < Math.abs(b - key)) {
				bw.write(a + "\n");
			} else {
				bw.write(Math.min(a, b) + "\n");
			}
		}
		
		bw.flush();
	}
}