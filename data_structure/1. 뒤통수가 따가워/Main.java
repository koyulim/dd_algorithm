import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(input[i]);
		}
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			bw.write(stack.size() + " ");
			
			while (!stack.empty() && stack.peek() <= list[i]) {
				stack.pop();
			}
			stack.add(list[i]);
		}
		
		bw.write("\n");
		bw.flush();
	}
}
