import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0, 1,-1};
    static boolean[][] visit;
    static int[][] distance;
    
    public int solution(int[][] maps) {
        int answer = 0;
        distance = new int[maps.length][maps[0].length];
        visit = new boolean[maps.length][maps[0].length];
        
        if(bfs(maps) != 0){
            return distance[maps.length-1][maps[0].length-1];
        } else return -1;
    }
    
    public static int bfs(int[][] maps){
        Queue<Point> q = new LinkedList<>();
        distance[0][0] =1;
        q.offer(new Point(0,0));
        visit[0][0]= true;
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0; i<4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                
                if(x <0 || y<0 || x >= maps.length || y >= maps[0].length) continue;
                
                if(maps[x][y] == 1 && !visit[x][y]){
                    visit[x][y] = true;
                    distance[x][y] = distance[temp.x][temp.y] + 1;
                    q.offer(new Point(x,y));
                }
                
                if(distance[maps.length-1][maps[0].length-1] !=0){
                    return distance[maps.length-1][maps[0].length-1];
                }
            }
        }
        return 0;
    }
}
    
class Point{
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}