import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String str = "";
        arr = new String[N+1];
        for (int i = 1; i < N+1; i++) {
            str = br.readLine();
            arr[i] = str;
            map.put(str, i);
        }
        str = "";
        int temp =0;
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            if(isInteger(str)){
                sb.append(arr[Integer.parseInt(str)]).append("\n");
            } else sb.append(map.get(str)).append("\n");
        }
        System.out.println(sb);
    }
    public static boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
