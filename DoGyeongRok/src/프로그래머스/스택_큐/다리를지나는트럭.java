package 프로그래머스.스택_큐;

// 2025-06-04
// https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;

public class 다리를지나는트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> queue = new LinkedList<>();
            int sum = 0;
            int time = 0;

            for(int truck: truck_weights) {
                while(true) {
                    if(queue.isEmpty()) {
                        queue.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    }else if(queue.size() == bridge_length) {
                        sum -= queue.poll();
                    }else {
                        if(sum + truck <= weight) {
                            queue.offer(truck);
                            sum += truck;
                            time++;
                            break;
                        }else {
                            queue.offer(0);
                            time++;
                        }
                    }
                }
            }
            return time + bridge_length;
        }
    }
}
