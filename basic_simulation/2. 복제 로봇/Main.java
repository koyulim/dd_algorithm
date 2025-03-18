import java.io.*;
import java.awt.Point;

class Main {
	
	private static int x, y, n;
	private static Point[] wave;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] xy = br.readLine().split(" ");
		x = Integer.parseInt(xy[0]);
		y = Integer.parseInt(xy[1]);
		
		n = Integer.parseInt(br.readLine());
		wave = new Point[n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			wave[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		
		int cnt = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < cnt; i++) {
			if (input[i].equals("L")) {
				if (!chack(x - 1, y)) x -= 1;
			} else if (input[i].equals("R")) {
				if (!chack(x + 1, y)) x += 1;
			} else if (input[i].equals("U")) {
				if (!chack(x, y + 1)) y += 1;
			} else {
				if (!chack(x, y - 1)) y -= 1;
			}
		}
		bw.write(x + " " + y + "\n");
		bw.flush();
	}
	
	private static boolean chack(int x, int y) {
		for (int i = 0; i < n; i++) {
			Point point = wave[i];
			if (x == point.x && y == point.y) {
				return true;
			}
		}
		return false;
	}
}