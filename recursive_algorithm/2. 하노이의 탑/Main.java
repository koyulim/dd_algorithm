import java.io.*;
import java.util.*;

class Main {

    private static List<int[]> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        hanoi(1, 3, 2, 20);

        List<Integer>[] list = new ArrayList[4];
        for (int i = 1; i <= 3; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 20; i > 0; i--) {
            list[1].add(i);
        }

        for (int i = 0; i < n; i++) {
            int start = arr.get(i)[0];
            int end = arr.get(i)[1];

            int disk = list[start].remove(list[start].size() - 1);
            list[end].add(disk);
        }

        for (int i = 1; i <= 3; i++) {
            int total = 0;
            for (int disk : list[i]) {
                total += disk;
            }
            bw.write(total + " ");
        }

        bw.write("\n");
        bw.flush();
    }

    private static void hanoi(int start, int end, int mid, int num) throws Exception {
        if (num == 1) {
            arr.add(new int[]{start, end});
            return;
        }

        hanoi(start, mid, end, num - 1);
        arr.add(new int[]{start, end});
        hanoi(mid, end, start, num - 1);
    }
}