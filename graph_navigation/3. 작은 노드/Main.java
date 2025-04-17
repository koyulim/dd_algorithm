import java.io.*;
import java.util.*;
public class Main {

    private static class Node{
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

        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

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

        for (int i = 1; i <= n; i++) {
            nodes[i].edges.sort(Comparator.comparingInt(e -> e.n));
        }

        boolean[] visit = new boolean[n + 1];
        Node node = nodes[k];
        visit[k] = true;
        int cnt = 1;
        int last = k;

        while(true) {
            boolean check = false;
            for (Node v : node.edges) {
                if (!visit[v.n]) {
                    visit[v.n] = true;
                    cnt++;
                    last = v.n;
                    node = v;
                    check = true;
                    break;
                }
            }
            if (!check) break;
        }
        bw.write(cnt + " " + last + "\n");
        bw.flush();
    }
}