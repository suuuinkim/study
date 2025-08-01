import java.util.Scanner;

public class Practice23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 곡 수
        int S = sc.nextInt(); // 시작 볼륨
        int M = sc.nextInt(); // 최대 볼륨

        int[] V = new int[N];
        for (int i=0; i< N; i++) {
            V[i] = sc.nextInt();
        }

        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][S] =true;

        for (int i=0; i<N; i++) {
            for (int vol = 0; vol<=M; vol++) {
                if (dp[i][vol]) {
                    if (vol + V[i] <= M) dp[i+1][vol + V[i]] = true;
                    if (vol - V[i] >= 0) dp[i+1][vol - V[i]] = true;

                }
            }
        }

        int result = -1;
        for (int vol = M; vol >= 0; vol--) {
            if (dp[N][vol]) {
                result = vol;
                break;
            }
        }

        System.out.println(result);
    }
}
