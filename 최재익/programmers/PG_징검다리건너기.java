import java.util.*;

class PG_징검다리건너기 {
    public int solution(int[] stones, int k) {
        int s = 0;
        int e = 200_000_000;

        while(s<e){
            int mid = (s+e)/2;

            boolean result = check(mid, stones, k);

            if(result){
                s = mid+1;
            }
            else e = mid;
        }

        return s;
    }

    static boolean check(int mid, int[] stones, int k){
        int count = 0;

        for(int i=0; i<stones.length; i++){
            if(stones[i]-mid <= 0){
                count++;
            }
            else count=0;

            if(count==k)return false;
        }

        return true;
    }
}