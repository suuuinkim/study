import java.util.Scanner;

public class Practice10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 총 상담 가능한 날 수
        int[] T = new int[N]; // 각 날의 상담 소요 기간
        int[] P = new int[N]; // 각 날의 상담 수익
        int[] dp = new int[N+1];  // dp[i] = i일 이후 퇴사까지 얻을 수 있는 최대 이익

        for (int i = 0; i<N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        // DP는 뒤에서부터 계산
        for (int i = N -1; i >=0; i--) {
            int endDay = i + T[i];
            if (endDay <= N) {
                dp[i] = Math.max(P[i] + dp[endDay], dp[i+1]);
            } else {
                dp[i] = dp[i+1];
            }
        }
        System.out.println(dp[0]);
    }
}
