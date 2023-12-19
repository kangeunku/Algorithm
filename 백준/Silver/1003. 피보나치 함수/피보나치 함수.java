import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] ans0;
    static int[] ans1;
    static int[] memory;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i <N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        ans0 = new int[max+1];
        ans1 = new int[max+1];
        memory = new int[max+1];

        for (int i = 0; i < max+1; i++) {
            fibonacci(i);
        }

        for (int a: arr) {
            System.out.println(ans0[a] + " "+ ans1[a]);
        }

    }
    static int fibonacci(int n) {
        if (n == 0) {
            ans0[0] = 1;
            return memory[0] = 0;
        } else if (n == 1) {
            ans1[1] = 1;
            return memory[1] = 1;
        } else {
            ans0[n] = ans0[n-1] + ans0[n-2];
            ans1[n] = ans1[n-1] + ans1[n-2];
            return memory[n] = memory[n-1] + memory[n-2];
        }
    }
}
