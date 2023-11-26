import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp !=0) pQ.offer(temp);
            else if(!pQ.isEmpty()){
                sb.append(pQ.poll()).append("\n");
            } else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
