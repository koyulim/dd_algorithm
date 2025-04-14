import java.io.*;
import java.util.*;

public class Main {

    private static class Node{
        int n;
        List<Node> edges;
        Node (int n) {
            this.n = n;
            edges = new ArrayList();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        boolean[][] check = new boolean[n + 1][n + 1];
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            check[start][end] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (check[i][j] && check[j][i]) {
                    nodes[i].edges.add(nodes[j]);
                    nodes[j].edges.add(nodes[i]);
                }
            }
        }

        boolean[] visit = new boolean[n + 1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            Queue<Node> queue = new LinkedList();
            if (!visit[i]) {
                cnt++;
                queue.add(nodes[i]);
                visit[i] = true;
                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (Node v : node.edges) {
                        if (!visit[v.n]) {
                            queue.add(v);
                            visit[v.n] = true;
                        }
                    }
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}