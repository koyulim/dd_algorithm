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

        boolean[][] list = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            list[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = true;
        }

        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int z = 1; z <= 6; z++) {
                    // 위쪽 이동 경우
                    if (i - z >= 0 && list[i][j] != true) {
                        dp[i][j] = (dp[i][j] + dp[i - z][j]) % 1000000007;
                    }
                    // 왼쪽 이동 경우
                    if (j - z >= 0 && list[i][j] != true) {
                        dp[i][j] = (dp[i][j] + dp[i][j - z]) % 1000000007;
                    }
                }
            }
        }
        bw.write(dp[n - 1][m - 1] + "\n");
        bw.flush();
    }
}