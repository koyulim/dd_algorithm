import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			int cnt = 0;
			while (a >= 2) {
				boolean check = true;
				for (int j = 2; j * j <= a; j++) {
					if (a % j == 0) {
						check = false;
						break;
					}
				}
				if (check) break;
				a--;
				cnt++;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
	}
}