import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static long[] arr;
    static long start;
    static long sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr = new long[M];

            for (int j = M-1; j >= 0; j--) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            start = arr[0];
            sum = 0;
            for (int j = 1; j < M; j++) {
                if(arr[j] > start){
                    start = arr[j];
                }else if(arr[j] < start){
                    sum += start - arr[j];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
