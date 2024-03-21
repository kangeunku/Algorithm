
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] arr;
    static boolean[] visit;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        answer = new int[N+1];
        visit = new boolean[N+1];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int[] check = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        Queue<Integer> que = new LinkedList<>();
        que.offer(check[0]);
        while (!que.isEmpty()){
            if(answer[check[1]] !=0) break;
            int temp = que.poll();
            for (int i = 1; i <=N; i++) {
                if(arr[temp][i] != 0 && !visit[i]){
                    visit[i] = true;
                    answer[i] = answer[temp] +1;
                    que.offer(i);
                }
            }

        }
        if(answer[check[1]] !=0){
            System.out.println(answer[check[1]]);
        } else {
            System.out.println(-1);
        }
    }
}
