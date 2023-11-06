import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[(n + 1)];
        System.out.println(solution(n));

    }

    static int solution(int n) {

        arr[1] = 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 1;
        
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr[j] == i && j + 1 <= n) {
                    if (arr[j + 1] == 0) {
                        arr[j + 1] = i + 1;
                    }
                }
                if (arr[j] == i && j * 2 <= n) {
                    if (arr[j * 2] == 0) {
                        arr[j * 2] = i + 1;
                    }
                }
                if (arr[j] == i && j * 3 <= n) {
                    if (arr[j * 3] == 0) {
                        arr[j * 3] = i + 1;
                    }
                }

            }
            if (arr[n] !=0){
                return arr[n];
            }
        }
        return arr[n];
    }
}