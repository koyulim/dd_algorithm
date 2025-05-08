import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // CASE 1
        int[][][] dp = new int[n + 1][2][3];
        // 아무 과목도 듣지 않은 상태
        dp[0][0][0] = 1;

        // i번째 과목까지 처리했을 때, B는 j번 사용했고 C는 z번 연속된 상태의 경우의 수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int z = 0; z < 3; z++) {
                    int val = dp[i][j][z];
                    if (val == 0) continue;

                    // A: C 리셋
                    dp[i + 1][j][0] = (dp[i + 1][j][0] + val) % 1000000;

                    // B: 아직 안 썼을 때만 가능
                    if (j == 0) {
                        dp[i + 1][1][0] = (dp[i + 1][1][0] + val) % 1000000;
                    }

                    // C: 연속 C가 2 미만일 때만 가능
                    if (z < 2) {
                        dp[i + 1][j][z + 1] = (dp[i + 1][j][z + 1] + val) % 1000000;
                    }
                }
            }
        }

        int total = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < 3; j++) {
                total += dp[n][i][j];
            }
        }

        // CASE 2
        int[][] dp = new int[n][6];
        // A
        dp[0][0] = 1;
        // C
        dp[0][1] = 1;
        // B
        dp[0][3] = 1;

        // B와 C의 조건에 맞는 모든 경우의 수의 누적 값
        for (int i = 1; i < n; i++) {
            // 누적된 값이 B O, C O인 경우 올 수 있는 경우의 수
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 1000000;
            // 누적된 값이 B O, C 1인 경우 올 수 있는 경우의 수
            dp[i][1] = dp[i - 1][0];
            // 누적된 값이 B O, C 2인 경우 올 수 있는 경우의 수
            dp[i][2] = dp[i - 1][1];
            // 누적된 값이 B 1, C O인 경우 올 수 있는 경우의 수
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5]) % 1000000;
            // 누적된 값이 B 1, C 1인 경우 올 수 있는 경우의 수
            dp[i][4] = dp[i - 1][3];
            // 누적된 값이 B 1, C 2인 경우 올 수 있는 경우의 수
            dp[i][5] = dp[i - 1][4];
        }

        int total = 0;
        for (int i = 0; i < 6; i++) {
            total += dp[n - 1][i];
        }

        bw.write((total % 1000000) + "\n");
        bw.flush();
    }
}