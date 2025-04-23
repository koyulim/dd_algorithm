import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        List<long[]> arr = new ArrayList();
        long total = 0;
        for (int i = 0; i < n; i++) {
            String[] xyt = br.readLine().split(" ");
            long x = Long.parseLong(xyt[0]);
            long y = Long.parseLong(xyt[1]);
            long t = Long.parseLong(xyt[2]);

            long d = (x*x + y*y) * 2;
            total += d;
            arr.add(new long[]{t, 1});
            arr.add(new long[]{t + d, -1});
        }

        arr.sort((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        long max = 0;
        long cnt = 0;
        for (long[] v : arr) {
            cnt += v[1];
            max = Math.max(max, cnt);
        }

        bw.write((total - max) + "\n");
        bw.flush();
    }
}