import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < t; i++) {
			String[] input = br.readLine().split(" ");
			long min = Math.min(Long.parseLong(input[0]), Long.parseLong(input[1]));
			long max = Math.max(Long.parseLong(input[0]), Long.parseLong(input[1]));
			
			if ((min * 160) <= (max * 100) && (min * 163) >= (max * 100)) {
				result++;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
	}
}