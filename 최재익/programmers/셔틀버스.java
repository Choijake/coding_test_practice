import java.util.*;

class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String table : timetable){
            pq.add(Integer.parseInt(table.substring(0,2))*60 + Integer.parseInt(table.substring(3)));
        }

        int start = 540;
        int end = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            count=0;
            while(!pq.isEmpty()){
                int cur = pq.peek();

                if(cur<=start && count<m){
                    pq.poll();
                    count++;
                }
                else break;

                end = cur-1;
            }

            start += t;
        }

        if(count<m)end = start-t;

        String h = String.format("%02d", end/60);
        String min = String.format("%02d", end%60);

        return h+":"+min;
    }
}