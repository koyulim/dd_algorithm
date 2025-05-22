import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] list = new int[n + 1];
        int[] cumulative = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(input[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            cumulative[i] = list[i] + cumulative[i - 1];
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);
            bw.write((cumulative[r] - cumulative[l - 1]) + "\n");
        }
        bw.flush();
    }
}