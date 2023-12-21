import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] Arr;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(count(Arr));
        while (true){
            Arr  = checkAir(Arr);
            Arr = melting(Arr);
            int cnt = count(Arr);
            if(cnt ==0) break;
            answer.add(cnt);
        }

        System.out.println(answer.size());
        System.out.println(answer.get(answer.size()-1));
    }
    public static int[][] checkAir(int[][] arr){
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(arr[i][j] ==2){
                    que.add(new int[]{i,j});

                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(arr[i][0] == 0){

                que.add(new int[]{i,0});
                arr[i][0] = 2;
            }
            if(arr[i][m-1] ==0){

                que.add(new int[]{i,m-1});
                arr[i][m-1] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            if(arr[0][i] ==0){

                que.add(new int[]{0,i});
                arr[0][i] = 2;
            }
            if(arr[n-1][i]==0){

                que.add(new int[]{n-1,i});
                arr[n-1][i] = 2;
            }
        }
        while (!que.isEmpty()){
            int[] point = que.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                x = point[0]+dx[i];
                y = point[1]+dy[i];
                if(x <0 || x>=n || y<0 || y>=m) continue;
                if(arr[x][y] == 0){

                    que.add(new int[]{x,y});
                    arr[x][y] = 2;
                }
            }
        }
        return arr;
    }
    public static int[][] melting(int[][] arr){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(arr[i][j] ==1){
                    for (int k = 0; k <4; k++) {
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if(x <0 || x>=n || y<0 || y>=m) continue;
                        if(arr[x][y] == 2){
                            arr[i][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return arr;
    }
    public static int count(int[][] arr){
        int cnt = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(arr[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;

    }
}
