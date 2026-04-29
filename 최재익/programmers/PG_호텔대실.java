import java.util.*;

class PG_호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;

        Arrays.sort(book_time, (b1, b2)->{
            int b1Start = convertToMinute(b1[0]);
            int b2Start = convertToMinute(b2[0]);

            return b1Start-b2Start;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<book_time.length; i++){
            String[] time = book_time[i];

            int start = convertToMinute(time[0]);
            int end = convertToMinute(time[1]);


            if(pq.isEmpty()){
                answer++;
            }
            else{
                int lastTime = pq.peek();
                if(start<lastTime){
                    answer++;
                }
                else pq.poll();
            }

            pq.offer(end+10);
        }

        return answer;
    }

    static int convertToMinute(String time){
        String[] t = time.split(":");

        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}