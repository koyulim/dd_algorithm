import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		long[] list = new long[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			list[i] = Long.parseLong(input[i]);
		}
		
		Arrays.sort(list);
		long result = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				long sum = list[i] + list[j];

				// 풀이 1
				// int idx = Arrays.binarySearch(list, j + 1, n, sum);
				// if (idx < 0) {
				// 	idx = -idx - 1;
				// } else {
				// 	idx++;
				// }

				// 풀이 2
				int l = j + 1;
				int r = n - 1;
				int idx = n;
				while(l <= r) {
					int mid = (l + r) / 2;
					
					if (list[mid] < sum) {
						l = mid + 1;
					} else {
						idx = mid;
						r = mid - 1;
					}
				}
				
				if (idx < n && sum == list[idx]) {
					idx++;
				}

				if (idx > j + 1) {
					result += idx - (j + 1);
				}
				
			}
		}
		bw.write(result + "\n");
		bw.flush();
	}
}