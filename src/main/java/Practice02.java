import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Practice02 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 9개를 배열에 담기
        int[] arr = new int[9];
        // 7개의 숫자를 담기
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> notAnswer = new ArrayList();
        int sum = 0;

        // 입력한 9가지를 합산해서 100을 만들기
        for(int i=0; i<arr.length; i++) {
            arr[i]=Integer.parseInt(br.readLine());
            // 9명의 키 합산 값을 구하기
            sum += arr[i];
        }

        // System.out.println("sum = " + sum);

        /* 틀린 코드
        int result = (sum - 100);

        // 9명 중 2명으로 result 구하기
        for(int i=0; i<arr.length; i++){
            for(int z=i+1; z<arr.length; z++) {
                if(arr[i] + arr[z] == result) {
                    notAnswer.add(arr[i]);
                    notAnswer.add(arr[z]);
                }
            }
        }

        for(int i=0; i<arr.length; i++) {
            answer.add(arr[i]);
        }
         */

        // 정답 코드
        int first = -1; int second = -1; // 인덱스를 찾지 못했다는 뜻!
        for (int i=0; i<9; i++) {
            for (int j= i+1; j<9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    first = i;
                    second = j;
                }
            }

            if (first != -1) break;
        }

        for (int i=0; i<9; i++) {
            if (i!=first && i!= second) {
                answer.add(arr[i]);
            }
        }

        Collections.sort(answer);

        for(int i=0; i<answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }


}
