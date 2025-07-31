import java.util.Scanner;

public class Practice22 {
    public static void main(String[] args) {
        final int MOD = 10007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];

        dp[0] = 1;
        if (n>=1) dp[1] = 1;
        if (n>=2) dp[2] = 2;

        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        System.out.println(dp[n]);
    }
}
