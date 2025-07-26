import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice18 {
    static int[] visited = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        bfs(N, M);

        System.out.println(minTime);
        System.out.println(count);
    }

    public static void bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int currentTime = visited[current];

            if (current == target) {
                if (minTime > currentTime - 1) {
                    minTime = currentTime - 1;
                    count = 1;
                } else if (minTime == currentTime - 1) {
                    count++;
                }
            }

            int[] nextPositions = {current - 1, current + 1, current * 2};
            for (int next : nextPositions) {
                if (next < 0 || next > 100000) continue;

                if (visited[next] == 0 || visited[next] == currentTime + 1) {
                    visited[next] = currentTime + 1;
                    queue.add(next);
                }
            }
        }
    }
}
