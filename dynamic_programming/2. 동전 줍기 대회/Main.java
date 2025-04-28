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
            if (i == 0) dp[0] = Integer.parseInt(input[i]);
            else dp[i] = Math.max(dp[i - 1], 0) + Integer.parseInt(input[i]);
            total = Math.max(total, dp[i]);
        }

        bw.write(total + "\n");
        bw.flush();
    }
}