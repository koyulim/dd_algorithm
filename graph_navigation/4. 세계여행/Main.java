import java.io.*;
import java.util.*;
public class Main {

    private static class Node {
        int n;
        List<Node> edges;
        Node(int n) {
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

        String[] aList = br.readLine().split(" ");
        int[] list = new int[n + 1];
        HashSet<Integer> set = new HashSet<>();

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(aList[i - 1]);
            set.add(list[i]);
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            nodes[start].edges.add(nodes[end]);
            nodes[end].edges.add(nodes[start]);
        }

        int result = 0;
        int a = list[1];

        for (int b : set) {

            HashSet<Integer> lag = new HashSet<>();
            lag.add(a);
            lag.add(b);

            Queue<Node> queue = new LinkedList<>();
            boolean[] visit = new boolean[n + 1];
            queue.add(nodes[1]);
            visit[1] = true;

            int cnt = 1;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for (Node s : node.edges) {
                    if (!visit[s.n] && lag.contains(list[s.n])) {
                        queue.add(s);
                        visit[s.n] = true;
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        bw.write(result + "\n");
        bw.flush();
    }
}