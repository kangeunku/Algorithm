class Solution{
    static int answer;
    static boolean flag = false;
    public int solution(int n, int a, int b){
        if(a > b){
            int temp = b;
            b = a;
            a = temp;
        }
        dfs(1, a, b );
        return answer;
    }
    public void dfs(int depth, int a, int b){
        if(b - a == 1 && (b+1)/2 == (a+1)/2){
            answer = depth;
            flag = true;
            return;
        }
        a = (a+1) / 2;
        b = (b+1) / 2;
        dfs(depth +1, a, b);
    }
}