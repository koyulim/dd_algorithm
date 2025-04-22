import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] abc = br.readLine().split(" ");
        int a = Integer.parseInt(abc[0]);
        int b = Integer.parseInt(abc[1]);
        int c = Integer.parseInt(abc[2]);

        int count = Integer.parseInt(br.readLine());
        int[][] list = new int[count][2];
        for (int i = 0; i < count; i++) {
            String[] pt = br.readLine().split(" ");
            int p = Integer.parseInt(pt[0]);
            int t = Integer.parseInt(pt[1]);
            list[i][0] = p;
            list[i][1] = t;
        }

        Arrays.sort(list, Comparator.comparingInt(e -> e[0]));

        int totalCnt = 0;
        long totalPrice = 0;
        for (int i = 0; i < count; i++) {
            if (list[i][1] == 0) {
                if (a > 0) {
                    a--;
                    totalPrice += list[i][0];
                    totalCnt++;
                } else if (c > 0) {
                    c--;
                    totalPrice += list[i][0];
                    totalCnt++;
                }

            } else {
                if (b > 0) {
                    b--;
                    totalPrice += list[i][0];
                    totalCnt++;
                } else if (c > 0) {
                    c--;
                    totalPrice += list[i][0];
                    totalCnt++;
                }
            }
        }

        bw.write(totalCnt + " " + totalPrice);
        bw.flush();
    }
}