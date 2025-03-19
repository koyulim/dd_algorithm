import java.io.*;

public class Main {

	private static String[][] list;
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		list = new String[n][n];

		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			String[] graph = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list[i][j] = graph[j];
			}
		}

		int goorm = move(Integer.parseInt(input1[0]) - 1, Integer.parseInt(input1[1]) - 1);
		int player = move(Integer.parseInt(input2[0]) - 1, Integer.parseInt(input2[1]) - 1);

		if (goorm < player) {
			bw.write("player" + " " + player + "\n");
		} else {
			bw.write("goorm" + " " + goorm + "\n");
		}

		bw.flush();
	}

	private static int move(int x, int y) {
		boolean visit[][] = new boolean[n][n];

		int cnt = 1;
		visit[x][y] = true;

		while (true) {
			String input3 = list[x][y];
			int count = Integer.parseInt(input3.substring(0, input3.length() - 1));
			char moving = input3.charAt(input3.length() - 1);

			for (int i = 0; i < count; i++) {
				if (moving == 'U') {
					x = (x - 1 + n) % n;
				} else if (moving == 'D') {
					x = (x + 1) % n;
				} else if (moving == 'R') {
					y = (y + 1) % n;
				} else {
					y = (y - 1 + n) % n;
				}

				if (visit[x][y])
					return cnt;
				visit[x][y] = true;
				cnt++;
			}
		}
	}
}