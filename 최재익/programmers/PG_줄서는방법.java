import java.util.*;

class PG_줄서는방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        long num = 1;
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=n; i++){
            num *= i;
            list.add(i);
        }

        k--;
        int idx = 0;

        while(idx<n){
            num = num / (n-idx);
            answer[idx++] = list.remove((int)(k/num));
            k %= num;
        }

        return answer;
    }
}