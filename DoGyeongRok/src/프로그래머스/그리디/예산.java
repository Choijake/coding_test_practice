package 프로그래머스.그리디;

// 2025-06-18
// https://school.programmers.co.kr/learn/courses/30/lessons/12982

import java.util.*;

public class 예산 {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            int[] arr = d;
            int limit = budget;
            Arrays.sort(arr);
            for(int i = 0; i < arr.length; i++) {
                limit -= arr[i];
                if(limit < 0) {
                    break;
                }else {
                    answer++;
                }
            }
            return answer;
        }
    }
}
