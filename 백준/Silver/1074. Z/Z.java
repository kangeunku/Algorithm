import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,r,c;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,N);
        System.out.println(sol(size,r,c,0));
    }
    static int sol(int size, int r, int c, int count){
        if (size ==1){
            return count;
        }
        if( size / 2 > r && size/2 >c){
            return sol(size / 2, r, c, count);
        } else if (size/2 <= r && size/2 <= c) {
            count += (size * size / 4)*3;
            return sol(size/2, r-size/2, c-size/2, count);
        } else if(size/2 <= r && size/2 > c){
            count += (size * size / 4)*2;
            return  sol(size/2, r-size/2, c, count);
        } else{
            count += (size * size / 4);
            return  sol(size/2, r, c-size/2, count);
        }
    }

}
