class Solution {
    static int answer =0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, 0, target);
        return answer;
    }
    public static void dfs(int depth, int[] number, int temp, int target){
    if(depth == number.length){
        if(temp == target){
            answer++;
        }
        return;
    }
    for(int i=0; i <2; i++){
        if(i==0){
            dfs(depth+1, number, temp+number[depth], target);
        }
        if(i==1){
            dfs(depth+1, number, temp-number[depth], target);
        }
    }
    }
}