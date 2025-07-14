import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int ball = 1;

        for (int i=0; i<M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            if (ball == X) {
                ball = Y;
            } else if (ball == Y) {
                ball = X;
            }
        }

        System.out.println(ball);
    }
}
