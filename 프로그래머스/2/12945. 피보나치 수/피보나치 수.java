class Solution {
    static int[] memory;
    public int solution(int n) {
        memory = new int[n+1];
        for(int i =0; i<n+1; i++){
            pibo(i);
        }
        return memory[n];
    }
    public int pibo(int m){
        if (m ==0){
            return memory[0]=0;
        }
        if( m==1){
            return memory[1] =1;
        }
        return memory[m] = (memory[m-1]+memory[m-2]) %1234567;
    }
}