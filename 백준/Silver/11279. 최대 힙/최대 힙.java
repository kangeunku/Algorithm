import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp !=0) pQ.offer(temp);
            else if(!pQ.isEmpty()){
                System.out.println(pQ.poll());
            } else System.out.println(0);
        }
    }
}
