import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int[] count = new int[3];
            int[] price = new int[3];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                count[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(count, price));
        }
    }
    static int solution(int[] count, int[] price){
        int ab = Math.min(count[0], count[1]);
        int bc = Math.min(count[1], count[2]);
        int ca = Math.min(count[2], count[0]);
        int maxPrice = 0;
        for (int i = 0; i <= ab; i++) {
            for (int j = 0; j <= Math.min(count[1] -i, count[2]); j++) {
                ca = Math.min(count[2] -j, count[0] - i);
                maxPrice = Math.max(maxPrice, i*price[0] + j*price[1] + ca*price[2]);
            }
        }


        return maxPrice;
    }
}
