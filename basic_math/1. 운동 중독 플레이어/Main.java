import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		bw.write(((int)(Integer.parseInt(input[0]) * (1 + ((double)Integer.parseInt(input[1]) / 30)))) + "\n");
		bw.flush();
	}
}