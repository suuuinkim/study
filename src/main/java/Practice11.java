import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice11 {

    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                S[i][j] = Integer.parseInt(input[j]);
            }
        }

        backtrack(0, 0);
        System.out.println(minDiff);
    }

    static void backtrack(int idx, int depth) {
        if (depth == N/2) {
            calculateDifference();
            return;
        }

        for (int i=idx; i<N; i++) {
            visited[i] = true;
            backtrack(i+1, depth+1);
            visited[i] = false;
        }
    }

    static void calculateDifference() {
        int start =0, link =0;

        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                if (visited[i] && visited[j]) {
                    start += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += S[i][j] + S[j][i];
                }
            }
        }

        minDiff = Math.min(minDiff, Math.abs(start - link));
    }
}
