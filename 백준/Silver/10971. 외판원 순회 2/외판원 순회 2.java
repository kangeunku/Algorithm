import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] city = new int[N][N];
        boolean[] visit = new boolean[N];
        for (int i = 0; i <N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <N ; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            dfs(0, i,i, city,   visit, 0);
        }
        System.out.println(answer);
    }
    static void dfs(int depth, int startCity, int presentCity, int[][] city, boolean[] visit, int cost){
        if(depth == N){
            answer = Math.min(answer, cost);
            return;
        }
        if(visit[startCity]) return;
        for (int i = 0; i < N; i++) {
            if(city[presentCity][i] !=0 && !visit[i]){
                visit[i] = true;
                dfs(depth +1, startCity, i, city, visit, cost+city[presentCity][i]);
                visit[i] = false;
            }
        }
    }
}
