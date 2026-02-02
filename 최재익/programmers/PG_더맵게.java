import java.util.*;

class PG_더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }

        int answer = 0;
        while(pq.peek()<K){
            if(pq.size()>1){
                int first = pq.poll();
                int second = pq.poll();

                int newOne = first + (second*2);
                pq.add(newOne);

                answer++;
            }
            else{
                return -1;
            }
        }

        return answer;
    }
}
//새로운 음식을 만들 수 없는 경우, 즉 큐가 빈 경우에 예외처리를 해줘야함