
class Solution {
    static int[] dx = {1,0,-1};
    static int[] dy = {0,1,-1};
    public int[] solution(int n) {
        int sum = n *(n+1)/ 2;
        int[] answer = new int[sum];
        int[][] temp = new int[n+1][n+1];
        int count = 1;
        int x =-1;
        int y =0;
        for(int i=0; i<n; i++){
            int x_plus = dx[i % 3];
            int y_plus = dy[i % 3];
            for(int j=n -i; j>0; j--){
                x = x+x_plus;
                y = y+y_plus;
                temp[x][y] = count++;
            }
        }
        count = 0;
        for(int[] first :temp){
            for(int tem : first){
                if(tem !=0){
                    answer[count++] = tem;
                } else continue;
            }
        }
        return answer;
    }
}