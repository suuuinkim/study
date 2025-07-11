import java.util.Scanner;

public class Practice05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char [][] board = new char[N][M];
        for (int i=0; i<N; i++) {
            String line = sc.nextLine();
            for (int j=0; j<M; j++){
                board[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                int repaint = countRepaint(board, i, j);
                min = Math.min(min, repaint);
            }
        }

        System.out.println(min);
    }

    public static int countRepaint(char[][] board, int startRow, int startCol) {
        int repaintW = 0;
        int repaintB = 0;

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                char expectedW = ((i+j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i+j) % 2 == 0) ? 'B' : 'W';

                if (board[startRow + i][startCol + j] != expectedW) repaintW++;
                if (board[startRow + i][startCol + j] != expectedB) repaintB++;
            }
        }
        return Math.min(repaintW, repaintB);
    }
}
