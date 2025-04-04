import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm = br.readLine().split(" ");
		long n = Long.parseLong(nm[0]);
		long m = Long.parseLong(nm[1]);
		
		int win = (int)(m * 100 / n);
		int key = win + 1;
		
		long l = 1;
		long r = 999999999999L;
		long cnt = 100000000000L;
		while (l <= r) {
			long mid = (l + r) / 2;
			
			if (((m + mid) * 100) / (n + mid) >= key) {
				r = mid - 1;
				cnt = mid;
			} else {
				l = mid + 1;
			}
		}
		
		if (cnt == 100000000000L) {
			bw.write("X" + "\n");
		} else {
			bw.write(cnt + "\n");
		}
		
		bw.flush();
	}
}