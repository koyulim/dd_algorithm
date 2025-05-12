import java.io.*;
import java.util.*;
public class Main {

    private static class Node {
        int n;
        List<Edges> edges;
        Node(int n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }

    private static class Edges {
        int n;
        int w;
        Edges (int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n = 4
        // A1 : 1 3 -> 1과 2(i + 1)의 연결, 나뭇가지 길이 3
        // A2 : 1 4 -> 1과 3의 연결, 나뭇가지 길이 4
        // A3 : 2 2 -> 2와 4의 연결, 나뭇가지 길이 2

        // 1. BFS로 트리의 지름을 찾기
        // 2. 가장 먼 노드 두 값을 기준으로 불을 붙였을 때 양쪽 거리중 최대 값이 가장 작은 위치 구하기
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = i + 1;
            int weight = Integer.parseInt(input[1]);

            nodes[start].edges.add(new Edges(end, weight));
            nodes[end].edges.add(new Edges(start, weight));
        }

        // BFS 1번을 기준으로 가장 먼 노드 구하기
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[1]);
        visit[1] = true;
        dist[1] = 0;

        int max = 0;
        int v = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Edges edge : node.edges) {
                if (!visit[edge.n]) {
                    visit[edge.n] = true;
                    dist[edge.n] = dist[node.n] + edge.w;
                    queue.add(nodes[edge.n]);
                    if (dist[edge.n] > dist[v]) {
                        v = edge.n;
                    }
                }
            }
        }

        // 배열 초기화
        Arrays.fill(visit, false);
        Arrays.fill(dist, 0);
        int[] parent = new int[n + 1];
        max = 0;

        // BFS 가장 먼 노드에서 가장 먼 노드 구하기
        queue.add(nodes[v]);
        visit[v] = true;
        dist[v] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Edges edge : node.edges) {
                if (!visit[edge.n]) {
                    visit[edge.n] = true;
                    dist[edge.n] = dist[node.n] + edge.w;
                    queue.add(nodes[edge.n]);
                    parent[edge.n] = node.n;
                    if (dist[edge.n] > dist[v]) {
                        v = edge.n;
                    }
                }
            }
        }

        // 부모 노드를 따라가며 거리 계산
        int result = Integer.MAX_VALUE;
        // 가장 먼 노드
        int currentNode = v;
        while (currentNode != 0) {
            int left = dist[currentNode];
            int right = dist[v] - dist[currentNode];
            result = Math.min(result, Math.max(left, right));
            currentNode = parent[currentNode];
        }

        bw.write(result + "\n");
        bw.flush();
    }
}