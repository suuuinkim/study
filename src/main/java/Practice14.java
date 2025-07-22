import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice14 {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList<>();
        visited = new boolean[N+1];

        // 그래프 초기화
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i=0; i<M; i++) {
            int u = sc.nextInt();
            int v= sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향 그래프
        }

        int count = 0;

        for (int i=1; i<=N; i++){
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
