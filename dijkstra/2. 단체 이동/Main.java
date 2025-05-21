import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int node;
        List<Edges> edges;

        Node(int node) {
            this.node = node;
            edges = new ArrayList<>();
        }
    }

    private static class Edges {
        int node;
        int weight;

        Edges(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] sec = br.readLine().split(" ");
        int s = Integer.parseInt(sec[0]);
        int e = Integer.parseInt(sec[1]);
        int c = Integer.parseInt(sec[2]);

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            int k = (int) Math.ceil((float) c / weight);

            nodes[start].edges.add(new Edges(end, k));
            nodes[end].edges.add(new Edges(start, k));
        }

        int[] mdt = new int[n + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        mdt[s] = 0;

        Queue<Edges> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        queue.add(new Edges(s, 0));

        while (!queue.isEmpty()) {
            Edges edge = queue.poll();
            int node = edge.node;
            int weight = edge.weight;

            if (mdt[node] < weight) continue;

            for (Edges next : nodes[node].edges) {
                int nextNode = next.node;
                int nextWeight = next.weight;
                if (mdt[nextNode] > mdt[node] + nextWeight) {
                    mdt[nextNode] = mdt[node] + nextWeight;
                    queue.add(new Edges(nextNode, mdt[node] + nextWeight));
                }
            }
        }

        bw.write((mdt[e] != Integer.MAX_VALUE ? mdt[e] : -1) + "\n");
        bw.flush();
    }
}