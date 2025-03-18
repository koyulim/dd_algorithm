import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nmx = br.readLine().split(" ");
		int n = Integer.parseInt(nmx[0]);
		int m = Integer.parseInt(nmx[1]);
		int x = Integer.parseInt(nmx[2]) - 1;
		
		int[] list = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(input[i]);
		}

		long result = 0;
		int q = Integer.parseInt(br.readLine());
		String[] qList = br.readLine().split(" ");
		for (int i = 0; i < q; i++) {
			
			if (list[x] + i >= m) {
				result += list[x] + i;
				list[x] -= list[x] + i;
			}
			if (qList[i].equals("L")) {
				x = (x - 1 + n) % n;
				
			} else if (qList[i].equals("R")) {
				x = (x + 1) % n;
			}
		}
		bw.write(result + "\n");
		bw.flush();
	}
}