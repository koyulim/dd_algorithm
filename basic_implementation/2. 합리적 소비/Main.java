import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int min = Integer.MAX_VALUE;
		String maxName = "";
		String minName = "";
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			if (max < Integer.parseInt(input[1])) {
				max = Integer.parseInt(input[1]);
				maxName = input[0];
			}
			
			if (min > Integer.parseInt(input[1])) {
				min = Integer.parseInt(input[1]);
				minName = input[0];
			}
		}
		
		bw.write(maxName + " " + max + "\n");
		bw.write(minName + " " + min + "\n");
		bw.flush();
	}
}