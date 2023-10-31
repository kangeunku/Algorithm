import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 1;
        int count = 1;
        if (N == 1) {System.out.print("1/1");}
        else{
            for(int i = 2; i <= N; i++){
                num += i;
                count += 1;
                if (num >= N){
                    break;
                }
            }
            if ( count % 2 == 0){
                System.out.print((count + 1 -(num - N + 1)) + "/" + (num - N + 1));

            }else{System.out.print( (num - N + 1) + "/" +(count + 1 -(num - N + 1)));
            }
        }


    }
}