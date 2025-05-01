import java.io.*;
import java.math.BigInteger;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        BigInteger[][] dp = new BigInteger[k + 1][n + m + 1];
        // BigInteger 배열 값 0으로 초기화
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n + m; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }

        // 구름이가 n개의 구슬을 가지고 있는 경우의 수
        // 구름이의 구슬 개수를 알면 상대방의 개수도 알 수 있으니 구름이의 개수를 체크
        dp[0][n] = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            // k번째에서 구름이가 j개의 구슬을 가지고 있는 경우의 수
            for (int j = 1; j < n + m; j++) {
                // 구름이가 졌을 때
                dp[i + 1][j - 1] = dp[i + 1][j - 1].add(dp[i][j]);
                // 무승부 일 때
                dp[i + 1][j] = dp[i + 1][j].add(dp[i][j]);
                // 구름이가 이겼을 때
                dp[i + 1][j + 1] = dp[i + 1][j + 1].add(dp[i][j]);
            }
        }

        BigInteger total = BigInteger.ZERO;
        // 전체 구슬을 구름이가 가지고 있는 경우의 수 + 전체 구슬을 구름이가 안가지고 있는 경우의 수(상대방이 구슬을 모두 가지고 있는 경우)
        for (int i = 1; i <= k; i++) {
            total = total.add(dp[i][0]).add(dp[i][n + m]);
        }

        bw.write(total + "\n");
        bw.flush();
    }
}