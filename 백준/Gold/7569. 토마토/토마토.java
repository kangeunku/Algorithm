import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] tomato, answer;
    static int[] dx,dy;

    static int n,m,h, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomato = new int[n*h][m];
        answer = new int[n*h][m];
        dx = new int[]{1,-1,0,0, n, -n};
        dy = new int[]{0,0,1,-1,0,0};
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n*h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j]==1){
                    queue.offer(new Point(i, j));
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(-1);
            return;
        } else count =0;
        while (!queue.isEmpty()){
            Point temp = queue.poll();
            for (int i = 0; i < 6; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if((temp.x+1) % n == 0 && i ==0) continue;
                if(temp.x % n == 0 && i ==1) continue;
                if(x <0 || y<0 || x>=n*h || y>=m) continue;
                if(tomato[x][y] == 0){
                    tomato[x][y] = 1;
                    answer[x][y] = answer[temp.x][temp.y] +1;
                    queue.offer(new Point(x,y));
                }
            }
        }
        for (int i = 0; i < n*h; i++) {
            for (int j = 0; j < m; j++) {
                if(tomato[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                count = Math.max(count, answer[i][j]);
            }
        }
        System.out.println(count);
    }
}
class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}