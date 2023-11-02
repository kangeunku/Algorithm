
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    public static int n,m,start;
    public static int[][] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] =1;
        }
        dfs(start);
        sb.append("\n");
        visit = new boolean[n+1];
        bfs(start);
        System.out.print(sb);

    }
    static void dfs(int start){
        visit[start] = true; //방문처리
        sb.append(start + " ");
        for(int i = 1; i <=n; i++){
            if (arr[start][i] ==1 && (!visit[i])) {
                dfs(i);

            }
        }
    }
    static void bfs(int start){
        que.add(start);
        visit[start] = true; //방문처리

        while (!que.isEmpty()){
            start = que.poll();
            sb.append(start + " ");
            for(int i = 1; i <=n; i++){
                if (arr[start][i] ==1 && !(visit[i])) {
                    que.add(i);
                    visit[i] = true;

                }
            }

        }

    }
}
