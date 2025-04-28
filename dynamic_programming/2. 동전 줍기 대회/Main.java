import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] dp = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            // 첫 번째 원소는 그대로 저장
            if (i == 0) dp[0] = Integer.parseInt(input[i]);
            // 현재 원소 + 이전까지의 최대 부분합
            // 음수면 0으로 무시
            else dp[i] = Math.max(dp[i - 1], 0) + Integer.parseInt(input[i]);
            // 지금까지의 최대 합 저장
            total = Math.max(total, dp[i]);
        }

        bw.write(total + "\n");
        bw.flush();
    }
}
