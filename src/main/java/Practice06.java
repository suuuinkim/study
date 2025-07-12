import java.util.Scanner;

public class Practice06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        // 이차원 배열로 입력 받기
        char[][] grid = new char[N][M];

        for (int i=0; i<N; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }

        int maxSize = 1; // 최소 정사각형 크기

        for (int i=0; i< N; i++) {
            for (int j=0; j<M; j++) {
                for (int k=1; i + k < N && j +k < M; k++) {
                    if (grid[i][j] == grid[i][j+k] &&
                        grid[i][j] == grid[i+k][j] &&
                        grid[i][j] == grid[i+k][j+k]) {
                        int size = k+1;
                        maxSize = Math.max(maxSize, size);
                    }
                }
            }
        }

        System.out.println(maxSize * maxSize);
    }
}
