import java.io.*;
import java.util.*;

class Main {
	
	private static class Node{
		int n;
		List<Node> edges;
		Node(int n) {
			this.n = n;
			edges = new ArrayList<>();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int j = 0; j < t; j++) {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			Node[] nodes = new Node[n + 1];
			for (int i = 1; i <= n; i++) {
				nodes[i] = new Node(i);
			}
			
			for (int i = 0; i < m; i++) {
				String[] input = br.readLine().split(" ");
				int start = Integer.parseInt(input[0]);
				int end = Integer.parseInt(input[1]);
				
				nodes[start].edges.add(nodes[end]);
				nodes[end].edges.add(nodes[start]);
			}
			
			Queue<Node> queue = new LinkedList<>();
			boolean[] visit = new boolean[n + 1];
			visit[1] = true;
			queue.add(nodes[1]);
			int result = 0;
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				
				for (Node suro : node.edges) {
					if (!visit[suro.n]) {
						queue.add(suro);
						visit[suro.n] = true;
						result++;
					}
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}