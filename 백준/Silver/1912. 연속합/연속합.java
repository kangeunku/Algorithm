import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> ans = new ArrayList<>();
        arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i= 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int sum = 0;
        for (int a : arr){
            if(a>=0){
                sum +=a;
            }
            else if(a<0){
                ans.add(sum);
                sum +=a;
                if(sum<0){
                    sum =0;
                }
            }
        }
        ans.add(sum);
        if(Collections.max(ans) ==0){
            System.out.println(max);
        } else{
            System.out.println(Collections.max(ans));
        }



    }
}
