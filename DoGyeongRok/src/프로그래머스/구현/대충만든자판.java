package 프로그래머스.구현;

// 2025-06-23
// https://school.programmers.co.kr/learn/courses/30/lessons/160586

import java.util.*;

public class 대충만든자판 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            Map<Character, Integer> map = new HashMap<>();
            for(String str: keymap) {
                for(int i = 0; i < str.length(); i++) {
                    if(map.containsKey(str.charAt(i))) {
                        map.put(str.charAt(i), Math.min(map.get(str.charAt(i)), i + 1));
                    }else {
                        map.put(str.charAt(i), i + 1);
                    }
                }
            }
            int[] answer = new int[targets.length];
            for(int i = 0; i < targets.length; i++) {
                for(int j = 0; j < targets[i].length(); j++) {
                    char c = targets[i].charAt(j);
                    if(!map.containsKey(c)) {
                        answer[i] = -1;
                        break;
                    }
                    answer[i] += map.get(c);
                }
            }
            return answer;
        }
    }
}
