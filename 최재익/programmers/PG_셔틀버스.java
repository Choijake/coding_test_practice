import java.util.*;

class PG_셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {

        int[] time = new int[timetable.length];
        for(int i=0; i<time.length; i++){
            String hour = timetable[i].substring(0, 2);
            String min = timetable[i].substring(3);

            time[i] = Integer.parseInt(hour)*60 + Integer.parseInt(min);
        }

        Arrays.sort(time);

        int startTime = 540;
        int endTime = 0;
        int idx = 0;
        for(int i=0; i<n; i++){

            int count = 0;
            int lastTime = 0;

            while(idx<time.length && time[idx]<=startTime && count<m){
                count++;
                lastTime = time[idx];
                idx++;
            }

            if(i==n-1){
                if(count<m){
                    endTime = startTime;
                }
                else endTime = lastTime-1;
            }

            startTime += t;
        }

        return String.format("%02d:%02d", endTime/60, endTime%60);
    }
}