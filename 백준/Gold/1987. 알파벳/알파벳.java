import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m, cnt, max;
    static char[][] map;
    static boolean[] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visit = new boolean[26];
        sol(0,0, 1);
        System.out.println(max);
    }
    static void sol(int x, int y, int cnt){
        max = Math.max(max, cnt);
        char a = map[x][y];
        visit[a-65] = true;
        for (int i = 0; i < 4; i++) {
            int x_1 = x+dx[i];
            int y_1 = y+dy[i];
            if(x_1<0 || x_1>=n || y_1<0 ||y_1>=m) continue;
                char b = map[x_1][y_1];
            if(!visit[b-65]){
                visit[b-65] = true;
                sol(x_1,y_1,cnt +1);
                visit[b-65] = false;
            }
        }
    }
}
