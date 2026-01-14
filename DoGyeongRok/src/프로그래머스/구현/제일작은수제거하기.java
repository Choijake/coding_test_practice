package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12935

import java.util.*;

public class 제일작은수제거하기 {
    class Solution {
        public int[] solution(int[] arr) {
            List<Integer> list = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for(int val: arr) {
                list.add(val);
                min = Math.min(min, val);
            }
            list.remove(Integer.valueOf(min));
            int[] answer = new int[list.size()];
            if(answer.length == 0) {
                return new int[] {-1};
            }else {
                for(int i = 0; i < answer.length; i++) {
                    answer[i] = list.get(i);
                }
            }
            return answer;
        }
    }
}
