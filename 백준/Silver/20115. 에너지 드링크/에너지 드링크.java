import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Double[] arr = new Double[N];
        for (int i = 0; i<arr.length; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        double answer = arr[0];
        for (int i =1; i <arr.length; i++){
            answer += arr[i] / 2;
        }
        System.out.println(answer);
    }

}
