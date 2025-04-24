import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[][] list = new int[n][2];
        for (int i = 0; i < n; i++) {
            list[i][0] = i + 1;
            list[i][1] = Integer.parseInt(input[i]);
        }

        Arrays.sort(list, Comparator.comparingInt(e -> e[1]));

        for (int i = 0; i < n; i++) {
            if (list[i][1] - i <= 0) {
                for (int j = 1; j <= n; j++) {
                    bw.write(j + " ");
                }
                bw.write("\n");
                bw.flush();
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(list[i][0] + " ");
        }

        bw.write("\n");
        bw.flush();
    }
}