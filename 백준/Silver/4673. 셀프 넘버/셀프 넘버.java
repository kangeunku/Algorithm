import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= 10000; i++){
            set.add(selfNum(i));
        }
        for (int i = 1; i <= 10000 ; i++) {
            if (set.contains(i)) {
                continue;
            } else System.out.println(i);
        }

    }
    public static int selfNum(int n){
        int sum = 0;
        sum += n;
        while (n != 0){
            sum += n % 10;
            n = n/ 10;
        }
        return sum;
    }
}