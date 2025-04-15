import java.io.*;
import java.awt.Point;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]); // 5
        int m = Integer.parseInt(nm[1]); // 4

        char[][] list = new char[m][n];
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                list[i][j] = input.charAt(j);
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] visit = new boolean[m][n];
        int result = 0;
        int resultCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Queue<Point> queue = new LinkedList<>();
                int cnt = 1;
                if (!visit[i][j] && list[i][j] == '#') {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        int x = point.x;
                        int y = point.y;

                        for (int z = 0; z < 4; z++) {
                            int nx = dx[z] + x;
                            int ny = dy[z] + y;
                            if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visit[nx][ny] && list[nx][ny] == '#') {
                                queue.add(new Point(nx, ny));
                                visit[nx][ny] = true;
                                cnt++;
                            }
                        }
                    }
                    result++;
                    resultCnt = Math.max(resultCnt, cnt);
                }
            }
        }
        bw.write(result + "\n");
        bw.write(resultCnt + "\n");
        bw.flush();
    }
}