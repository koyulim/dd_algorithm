import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][5];

        // 5가지 경우의 수 1로 초기화
        // n = 1일 때 모든 경우의 수
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }

        // 두 번째 줄부터 첫 번째 줄의 경우의 수 1개마다 올 수 있는 모든 경우의 수를 누적
        for (int i = 1; i < n; i++) {
            // 윗줄이 0,0,0 인 경우에 그 다음줄에 올 수 있는 경우의 수
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % 100000007;
            // 윗줄이 1,0,0 인 경우에 그 다음줄에 올 수 있는 경우의 수
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2] + dp[i - 1][3]) % 100000007;
            // 윗줄이 0,1,0 인 경우에 그 다음줄에 올 수 있는 경우의 수
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4]) % 100000007;
            // 윗줄이 0,0,1 인 경우에 그 다음줄에 올 수 있는 경우의 수
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 100000007;
            // 윗줄이 1,0,1 인 경우에 그 다음줄에 올 수 있는 경우의 수
            dp[i][4] = (dp[i - 1][0] + dp[i - 1][2]) % 100000007;
        }

        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += dp[n - 1][i];
        }

        bw.write((total % 100000007) + "\n");
        bw.flush();
    }
}