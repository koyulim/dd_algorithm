import java.io.*;
import java.util.*;

class Main {

    private static class Node {
        int node;
        List<Node> edges;

        Node(int node) {
            this.node = node;
            edges = new ArrayList();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            nodes[a].edges.add(nodes[b]);
            nodes[b].edges.add(nodes[a]);
        }

        boolean[] visit = new boolean[n + 1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                cnt++;
                Queue<Node> queue = new LinkedList<>();
                visit[i] = true;
                queue.add(nodes[i]);
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (Node product : node.edges) {
                        if (!visit[product.node]) {
                            queue.add(product);
                            visit[product.node] = true;
                        }
                    }
                }
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
    }
}