import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int x, y, dir, dist;

        Node(int x, int y, int dir, int dist) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        char[][] list = new char[N][M];
        int startX = 0, startY = 0, endX = 0, endY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                list[i][j] = str.charAt(j);
                if (list[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (list[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        int[][][] mdt = new int[N][M][8];
        for (int[][] arr2D : mdt) {
            for (int[] arr : arr2D) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
        }

        // 방향: 상, 하, 좌, 우, 대각선 포함 8방향
        int[][] DIR = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        for (int d = 0; d < 8; d++) {
            mdt[startX][startY][d] = 0;
            queue.offer(new Node(startX, startY, d, 0));
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (mdt[node.x][node.y][node.dir] < node.dist) continue;

            char c = list[node.x][node.y];

            if (c >= '0' && c <= '9') {
                int cost = c - '0';
                int nx = node.x + DIR[node.dir][0];
                int ny = node.y + DIR[node.dir][1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && list[nx][ny] != '#') {
                    if (mdt[nx][ny][node.dir] > node.dist + cost) {
                        mdt[nx][ny][node.dir] = node.dist + cost;
                        queue.offer(new Node(nx, ny, node.dir, node.dist + cost));
                    }
                }
            } else {
                for (int d = 0; d < 8; d++) {
                    int nx = node.x + DIR[d][0];
                    int ny = node.y + DIR[d][1];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && list[nx][ny] != '#') {
                        if (mdt[nx][ny][d] > node.dist + 1) {
                            mdt[nx][ny][d] = node.dist + 1;
                            queue.offer(new Node(nx, ny, d, node.dist + 1));
                        }
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int d = 0; d < 8; d++) {
            result = Math.min(result, mdt[endX][endY][d]);
        }

        bw.write((result == Integer.MAX_VALUE ? -1 : result) + "\n");
        bw.flush();
    }
}
