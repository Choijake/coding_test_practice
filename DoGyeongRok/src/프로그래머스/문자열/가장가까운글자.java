package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/142086

import java.util.*;

public class 가장가까운글자 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                if(map.containsKey(s.charAt(i))) {
                    answer[i] = i - map.get(s.charAt(i));
                }else {
                    answer[i] = -1;
                }
                map.put(s.charAt(i), i);
            }
            return answer;
        }
    }
}
