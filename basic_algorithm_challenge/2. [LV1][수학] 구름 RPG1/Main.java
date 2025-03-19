import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			boolean chack = true;
			if (a <= 3) {
				chack = true;
			} else if (a % 2 == 0 || a % 3 == 0) {
				chack = false;
			} else {
				for (int j = 5; j * j <= a; j += 6) {
					if (a % j == 0 || a % (j + 2) == 0) {
						chack = false;
						break;
					}
				}
			}
			
			if (chack) {
				bw.write("Yes" + "\n");
			} else {
				bw.write("No" + "\n");
			}
		}
		bw.flush();
	}
}