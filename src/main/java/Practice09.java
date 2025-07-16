import java.util.Scanner;

public class Practice09 {
    static int[][] board = new int[5][5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int called = sc.nextInt();
                count++;

                markNumber(called); // 철수 빙고판에서 숫자 지우기 (표시)

                if (count >= 12) { // 최소 12개 이상 불러야 빙고 3줄 가능
                    int bingo = countBingoLines();
                    if (bingo >= 3) {
                        System.out.println(count);
                        return;
                    }
                }
            }
        }
    }

    static void markNumber(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == number) {
                    board[i][j] = -1;
                    return;
                }
            }
        }
    }

    static int countBingoLines() {
        int count = 0;

        // 가로 줄
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) count++;
        }

        // 세로 줄
        for (int j = 0; j < 5; j++) {
            boolean isBingo = true;
            for (int i = 0; i < 5; i++) {
                if (board[i][j] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) count++;
        }

        // 대각선 (좌상단 → 우하단)
        boolean isBingo1 = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != -1) {
                isBingo1 = false;
                break;
            }
        }
        if (isBingo1) count++;

        // 대각선 (우상단 → 좌하단)
        boolean isBingo2 = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != -1) {
                isBingo2 = false;
                break;
            }
        }
        if (isBingo2) count++;

        return count;
    }
}
