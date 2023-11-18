import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Point> que = new LinkedList<>();
        int cnt = 0;
        while (true){
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a ==0 && b==0){
                break;
            }
            map = new int[b][a];
            visit = new boolean[b][a];
            for (int i = 0; i < b ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < a; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < b ; i++) {
                for (int j = 0; j < a; j++) {
                    if(map[i][j] == 1 && !visit[i][j]){
                        Point p = new Point(i,j);
                        cnt++;
                        que.offer(p);
                        while(!que.isEmpty()){
                            Point temp = que.poll();
                            for (int k = 0; k <dx.length ; k++) {
                                int x = temp.x+dx[k];
                                int y = temp.y+dy[k];

                                if(x<0||x >=b || y<0 || y>=a) continue;

                                if(map[x][y] == 1 && !visit[x][y]){
                                    visit[x][y] = true;
                                    que.offer(new Point(x,y));
                                }
                            }

                        }

                    }
                }
            }
            System.out.println(cnt);

        }

    }
}
