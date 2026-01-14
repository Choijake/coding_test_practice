package 프로그래머스.구현;

// 2025-06-22
// https://school.programmers.co.kr/learn/courses/30/lessons/131128

import java.util.*;

public class 숫자짝꿍 {
    class Solution {
        public String solution(String X, String Y) {
            Map<Character, Integer> mapX = new HashMap<>();
            Map<Character, Integer> mapY = new HashMap<>();

            for (char c : X.toCharArray()) {
                mapX.put(c, mapX.getOrDefault(c, 0) + 1);
            }

            for (char c : Y.toCharArray()) {
                mapY.put(c, mapY.getOrDefault(c, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();

            for (char c = '9'; c >= '0'; c--) {
                if (mapX.containsKey(c) && mapY.containsKey(c)) {
                    int count = Math.min(mapX.get(c), mapY.get(c));
                    for (int i = 0; i < count; i++) {
                        sb.append(c);
                    }
                }
            }

            if (sb.length() == 0) return "-1";
            if (sb.charAt(0) == '0') return "0";

            return sb.toString();
        }
    }
}
