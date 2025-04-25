import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[1000000];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i < 1000000; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 1000000007;
        }

        bw.write((list[n - 1] % 1000000007) + "\n");
        bw.flush();
    }
}