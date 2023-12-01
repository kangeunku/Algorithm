import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n,m;
    static boolean[] check;
    static int[] list;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new boolean[n];
        list = new int[m];
        sb = new StringBuilder();
        sol(0);
        System.out.println(sb);
    }
    static void sol(int depth){
        if (depth == m){
            for (int i=0; i<m; i++) {
                sb.append(list[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!check[i]){
                list[depth] = i+1;
                sol(depth+1);

            }


        }
    }
}
