import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr_1 = new int[a];
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < a; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        int b = Integer.parseInt(br.readLine());
        int[] arr_2 = new int[b];
        StringTokenizer st_2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < b; i++) {
            arr_2[i] = Integer.parseInt(st_2.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int num:arr_2) {
            if(treeSet.contains(num)){
                sb.append(1).append("\n");
            } else sb.append(0).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
