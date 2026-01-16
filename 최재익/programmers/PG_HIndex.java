import java.util.*;

class PG_HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int max = citations[citations.length-1];
        for(int i=0; i<=max; i++){
            int h = 0;
            for(int j=0; j<citations.length; j++){
                if(citations[j]>i)h++;
            }
            if(h==i)answer = Math.max(answer, h);
        }
        return answer;
    }
}