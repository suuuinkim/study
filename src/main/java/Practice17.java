import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int MAX = 100001;
        boolean[] visited = new boolean[MAX];
        int[] time = new int[MAX];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        time[N] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == M) {
                System.out.println(time[now]);
                break;
            }

            int[] nextPositions = {now -1, now +1, now*2};

            for(int next : nextPositions) {
                if(next >= 0 && next < MAX && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    time[next] = time[now] + 1;
                }
            }
        }

    }
}
