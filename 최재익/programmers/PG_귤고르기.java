import java.util.*;

class PG_귤고르기 {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer t : tangerine){
            map.put(t, map.getOrDefault(t, 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        int answer = 0;
        for(int i=0; i<list.size(); i++){
            int count = list.get(i);

            k-=count;
            answer++;

            if(k<=0)break;
        }

        return answer;
    }
}