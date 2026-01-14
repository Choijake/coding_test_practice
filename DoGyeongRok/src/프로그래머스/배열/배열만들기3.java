package 프로그래머스.배열;

// 2025-06-13
// https://school.programmers.co.kr/learn/courses/30/lessons/181895

import java.util.*;

public class 배열만들기3 {
    class Solution {
        public int[] solution(int[] arr, int[][] intervals) {
            List<Integer> list = new ArrayList<>();
            int firstStart = intervals[0][0];
            int firstEnd = intervals[0][1];
            int secondStart = intervals[1][0];
            int secondEnd = intervals[1][1];
            for(int i = firstStart; i <= firstEnd; i++) {
                list.add(arr[i]);
            }
            for(int i = secondStart; i <= secondEnd; i++) {
                list.add(arr[i]);
            }
            int[] answer = new int[list.size()];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
