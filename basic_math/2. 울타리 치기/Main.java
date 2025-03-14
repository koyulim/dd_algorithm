import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int heights = Integer.parseInt(input[0]);
		for (int i = 1; i < n; i++) {
			heights += Math.abs(Integer.parseInt(input[i - 1]) - Integer.parseInt(input[i]));
		}
		
		int result = (n * 2) + heights + Integer.parseInt(input[n - 1]);
		bw.write(result + "\n");
		bw.flush();
	}
}