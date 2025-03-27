import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nmk = br.readLine().split(" ");
		int n = Integer.parseInt(nmk[0]);
		int m = Integer.parseInt(nmk[1]);
		int k = Integer.parseInt(nmk[2]);
		
		int[][] list = new int[n + 1][m + 1];
		for (int z = 0; z < k; z++) {
			String[] input = br.readLine().split(" ");
			
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			list[x][y] = Integer.MAX_VALUE;
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (list[i][j] != Integer.MAX_VALUE) {
						int leng = (int)Math.pow(Math.abs((x - i)), 2) + (int)Math.pow(Math.abs(y - j), 2);
						list[i][j] += leng;
					}
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				result = Math.min(result, list[i][j]);
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
	}
}