import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < t; i++) {
			String[] input = br.readLine().split(" ");
			if (input[1].equals("+")) {
				result += Integer.parseInt(input[0]) + Integer.parseInt(input[2]);
			} else if (input[1].equals("-")) {
				result += Integer.parseInt(input[0]) - Integer.parseInt(input[2]);
			} else if (input[1].equals("*")) {
				result += Integer.parseInt(input[0]) * Integer.parseInt(input[2]);
			} else if (input[1].equals("/")) {
				result += Integer.parseInt(input[0]) / Integer.parseInt(input[2]);
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
	}
}