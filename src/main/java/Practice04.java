import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Practice04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 1~10 을 2번씩 넣기
        List<Integer> cards = new ArrayList<>();
        for(int i=1; i<=10; i++){
           cards.add(i);
           cards.add(i);
        }

        // 2. 영학이의 패 제거
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        cards.remove(Integer.valueOf(A));
        cards.remove(Integer.valueOf(B));

        // 3. 상대방 카드 조합
        List<int[]> otherCards = new ArrayList<>();

        for(int i=0; i<cards.size(); i++) {
            for(int z=i+1; z<cards.size(); z++) {
                int[] pair = new int[]{cards.get(i), cards.get(z)}; // 배열 선언과 초기화
                otherCards.add(pair);
            }
        }

        int[] score = evaluation(A, B);
        double winCount = 0;

        for (int[] pair : otherCards) {
            int[] otherScore = evaluation(pair[0], pair[1]);
            winCount += compare(score, otherScore);
        }

        double total = otherCards.size();
        double winRate = winCount / total;
        System.out.printf(String.format("%.3f\n", winRate));


    }

    // 땡인지 끗인지
    static int[] evaluation(int x, int y) {
        if (x == y) {
            return new int[]{1,x};
        } else {
            return new int[]{0, (x + y)%10};
        }
    }

    static double compare(int[] my, int[] other) {
        if(my[0] > other[0]) return 1;
        else if (my[0] < other[0]) return 0;
        else {
            if (my[1] > other[1]) return 1;
            else if (my[1] == other[1]) return 0.5;
            else return 0;
        }
    }
}
