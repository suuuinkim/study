import java.util.*;

public class Practice13 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            int a= sc.nextInt();
            int b= sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 실행
        visited = new boolean[n+1];
        dfs(v);
        System.out.println(sb.toString().trim());

        // BFS 실행
        visited = new boolean[n+1];
        sb.setLength(0);
        bfs(v);
        System.out.println(sb.toString().trim());
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for (int next : graph[node]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
