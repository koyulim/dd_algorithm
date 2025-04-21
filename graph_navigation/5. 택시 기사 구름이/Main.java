import java.io.*;
import java.util.*;
import java.awt.Point;
public class Main {

    private static int n,m,x,y,z;
    private static int[][] list;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        String[] xyz = br.readLine().split(" ");
        x = Integer.parseInt(xyz[0]);
        y = Integer.parseInt(xyz[1]);
        z = Integer.parseInt(xyz[2]);

        list = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        int totalmove = 0;
        int totalmoney = 0;
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < m; i++) {
            String[] abcd = br.readLine().split(" ");
            int a = Integer.parseInt(abcd[0]) - 1;
            int b = Integer.parseInt(abcd[1]) - 1;
            int c = Integer.parseInt(abcd[2]) - 1;
            int d = Integer.parseInt(abcd[3]) - 1;

            int move = bfs(b, a, d, c);
            if (i != 0) {
                int move2 = bfs(startY, startX, b, a);
                totalmove += move2;
            }

            totalmove += move;
            totalmoney += (move > 5) ? x + (move - 5) * y : x;
            startX = c;
            startY = d;
        }

        bw.write((totalmoney - (totalmove * z)) + "\n");
        bw.flush();
    }

    private static int bfs (int a, int b, int c, int d) {

        boolean[][] visit = new boolean[n][n];
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(a, b));
        visit[a][b] = true;
        int[][] dist = new int[n][n];

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if(point.x == c && point.y == d) {
                return dist[point.x][point.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + point.x;
                int ny = dy[i] + point.y;
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny] && list[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                    dist[nx][ny] = dist[point.x][point.y] + 1;
                }
            }
        }

        return 0;
    }
}