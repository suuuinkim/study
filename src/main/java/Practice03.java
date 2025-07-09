import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Practice03 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 몇 개의 숫자를 입력 받을 건지
        int k = Integer.parseInt(br.readLine());

        // 2. 입력받은 숫자를 배열에 담기
        int[] arr = new int[k];

        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 3. 삼각수 구하기
        // n(n+1) /2
        ArrayList<Integer> tri = new ArrayList<>();
        for(int i=1; i*(i+1)/2 <= 1000; i++) {
            tri.add(i*(i+1)/2);
        }

        for (int i : arr) {
            boolean isSuccess = false;

            for(int j=0; j<tri.size(); j++) {
                for(int z=0; z<tri.size(); z++) {
                    for(int r=0; r<tri.size(); r++) {
                        int sum = tri.get(j) + tri.get(z) + tri.get(r);

                        if (sum == i) {
                            isSuccess = true;
                            break;
                        }
                    }

                    if(isSuccess) break;
                }
                if(isSuccess) break;
            }

            System.out.println(isSuccess ? 1: 0);
        }

    }
}
