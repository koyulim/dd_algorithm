import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rc = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);

        char[][] list = new char[r][c];
        Queue<Point> queue = new LinkedList();
        boolean[][] visit = new boolean[r][c];
        int[][] cnt = new int[r][c];
        Point end = null;

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                list[i][j] = input.charAt(j);
                if (list[i][j] == '@') {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                }
                if (list[i][j] == '&') {
                    end = new Point(i, j);
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visit[nx][ny] && list[nx][ny] != '#') {
                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                    cnt[nx][ny] = cnt[p.x][p.y] + 1;
                }
            }
        }

        bw.write((cnt[end.x][end.y] - 1) + "\n");
        bw.flush();;
    }
}