import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,count;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            arr = new int[M+1];
            visit = new boolean[M+1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= M ; j++) {
                dfs(arr[j], j);
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int nextNode, int start){
        if(visit[nextNode]) return;
        if(nextNode == start){
            visit[nextNode] = true;
            count++;
            return;
        }
        visit[nextNode] = true;
        dfs(arr[nextNode], start);

    }
}
