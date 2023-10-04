class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int x : num_list){
            if (x > 0) {
              answer++;}
            if (x < 0) return answer;
        }
        return -1;
    }
}