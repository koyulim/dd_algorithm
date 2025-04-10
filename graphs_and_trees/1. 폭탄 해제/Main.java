import java.io.*;
import java.awt.Point;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		List<Point> arr = new ArrayList<>();
		int[] cnt = new int[n + 1];
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			arr.add(new Point(a, b)); 
			cnt[a]++;
			cnt[b]++;
		}
		
		boolean check = false;
		for (int i = 0; i < m; i++) {
			Point point = arr.get(i);
			int start = point.x;
			int end = point.y;
			if (cnt[start] - 1 > 0 && cnt[end] - 1 > 0) {
				check = true;
				bw.write((i + 1) + " ");
			}
		}
		
		if (!check) {
			bw.write("-1");
		}
		
		bw.write("\n");
		bw.flush();
	}
}