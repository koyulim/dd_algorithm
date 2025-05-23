import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int n;
        List<Edge> edges;

        Node(int n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }

    private static class Edge {
        int n;
        int w;

        Edge(int n, int w) {
            this.n = n;
            this.w = w;
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

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            nodes[start].edges.add(new Edge(end, weight));
        }

        int[] mdt = new int[n + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        mdt[s] = 0;
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        queue.add(new Edge(s, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int node = edge.n;
            int weight = edge.w;

            if (mdt[node] < weight) continue;

            for (Edge next : nodes[node].edges) {
                int nextNode = next.n;
                int nextWeight = next.w;
                if (mdt[nextNode] > mdt[node] + nextWeight) {
                    mdt[nextNode] = mdt[node] + nextWeight;
                    queue.add(new Edge(nextNode, mdt[node] + nextWeight));
                }
            }
        }

        long total = 0;
        for (int i = 1; i <= n; i++) {
            if (mdt[i] != Integer.MAX_VALUE) {
                total += (long) mdt[i];
            } else {
                total += (long) -1;
            }
        }
        bw.write(total + "\n");
        bw.flush();
    }
}