import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Practice16 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i=0; i<N; i++){
            String line = sc.next();
            for(int j=0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complextList = new ArrayList<>();

        // 모든 좌표 탐색
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    complextList.add(count);
                }
            }
        }

        // 결과 출력
        System.out.println(complextList.size());
        Collections.sort(complextList);

        for (Integer integer : complextList) {
            System.out.println(integer);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int d=0; d<4; d++) {
            int nx = x+dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny>=0 && nx <N && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    count++;
                    dfs(nx,ny);
                }
            }
        }
    }
}
