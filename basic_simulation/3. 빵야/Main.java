import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int cnt = 0;
		long result = 0;
		
		for (int i = 0; i < n; i++) {
			int stamina = Integer.parseInt(input[i]);
			
			while (cnt > 0 && stamina > 0) {
				stamina -= cnt + 1;
				cnt = (cnt + 1) % 4;
				result++;
			}
			
			if (stamina <= 0) continue;
			
			result += (stamina / 10) * 4;
			stamina %= 10;
			
			while (stamina > 0) {
				stamina -= cnt + 1;
				cnt = (cnt + 1) % 4;
				result++;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
	}
}