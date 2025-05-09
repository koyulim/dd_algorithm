import java.io.*;
import java.util.*;
public class Main {

    private static class Node {
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

        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            nodes[start].edges.add(nodes[end]);
            nodes[end].edges.add(nodes[start]);
        }

        boolean[] visit = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();
        int[] cnt = new int[n + 1];
        queue.add(nodes[1]);
        visit[1] = true;
        cnt[1] = 1;

        // 시작점 1부터 가장 먼 곳 구하기
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node v : node.edges) {
                if (!visit[v.n]) {
                    queue.add(v);
                    visit[v.n] = true;
                    cnt[v.n] = cnt[node.n] + 1;
                }
            }
        }

        // 시작점부터 가장 먼 index 값 추출
        int value = 0;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (value < cnt[i]) {
                value = cnt[i];
                idx = i;
            }
        }

        queue.add(nodes[idx]);

        // 방문 처리랑 횟수 초기화
        Arrays.fill(visit, false);
        Arrays.fill(cnt, 0);

        visit[idx] = true;
        cnt[idx] = 1;

        // 먼 곳 부터 가장 먼 곳 구하기
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node v : node.edges) {
                if (!visit[v.n]) {
                    queue.add(v);
                    visit[v.n] = true;
                    cnt[v.n] = cnt[node.n] + 1;
                }
            }
        }

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total = Math.max(total, cnt[i]);
        }

        bw.write(total + "\n");
        bw.flush();
    }
}