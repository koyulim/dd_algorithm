import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 5; i <= n; i*= 5) {
			cnt += n / i;
		}
		bw.write(cnt + "\n");
		bw.flush();
	}
}