import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        answer = new int[M];
        DFS(N,M,0);
        System.out.print(sb.toString());
    }
    public static void DFS(int N, int M, int depth){
        if(depth == M){
            for(int val : answer){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = i+1;
                DFS(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}