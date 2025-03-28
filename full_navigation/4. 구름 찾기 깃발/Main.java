import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		int[][] list = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				
				if (list[i][j] == 1) continue;
				
				for (int z = 0; z < 4; z++) {
					int nx = dx[z] + i;
					int ny = dy[z] + j;
					
					if (nx >= 0 && ny >= 0 && nx < n && ny < n && list[nx][ny] == 1) {
						cnt++;
					}
				}
				
				if (i + 1 < n && j + 1 < n && list[i + 1][j + 1] == 1) {
					cnt++;
				}
				
				if (i + 1 < n && j - 1 >= 0 && list[i + 1][j - 1] == 1) {
					cnt++;
				}
				
				if (i - 1 >= 0 && j + 1 < n && list[i - 1][j + 1] == 1) {
					cnt++;
				}
				
				if (i - 1 >= 0 && j - 1 >= 0 && list[i - 1][j - 1] == 1) {
					cnt++;
				}
			
				if (cnt == k) {
					result++;
				}
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
	}
}