import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr_1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr_1[i] = sc.nextInt();
        }
        int[] arr_2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr_2[i] = sc.nextInt();
        }

        Arrays.sort(arr_1);
        Arrays.sort(arr_2);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr_1[i]*arr_2[n-1-i];
        }
        System.out.println(sum);
    }
}
