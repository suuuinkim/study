import java.util.Scanner;

public class Practice08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();
        int[] prices = new int[14];
        for(int i=0; i<14; i++) {
            prices[i] = sc.nextInt();
        }

        // 준현 전략
        int j_cash = money;
        int j_stock = 0;

        for(int i=0; i<14; i++) {
            if(j_cash >= prices[i]) {
                int buy = j_cash / prices[i];
                j_stock += buy;
                j_cash -= buy * prices[i];
            }
        }

        int j_asset = j_cash + j_stock * prices[13];

        // 성민 전략
        int s_cash = money;
        int s_stock = 0;

        for (int i=3; i<14; i++) {
            // 3일 연속 상승
            if(prices[i-3] < prices[i-2] && prices[i-2] < prices[i-1]) {
               // 전량 매도
                s_cash += s_stock*prices[i];
                s_stock = 0;
            }
            // 3일 연속 하락
            else if (prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1]) {
                // 전량 매수
                if (s_cash >= prices[i]) {
                    int buy = s_cash / prices[i];
                    s_stock += buy;
                    s_cash -= buy * prices[i];
                }
            }
        }
        int s_asset = s_cash + s_stock * prices[13];

        if (j_asset > s_asset) {
            System.out.println("BNP");
        } else if (j_asset < s_asset) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
