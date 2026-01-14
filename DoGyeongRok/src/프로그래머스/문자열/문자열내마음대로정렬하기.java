package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12915

import java.util.*;

public class 문자열내마음대로정렬하기 {
    class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (a, b) -> {
                if (a.charAt(n) == b.charAt(n)) {
                    return a.compareTo(b);
                }
                return Character.compare(a.charAt(n), b.charAt(n));
            });
            return strings;
        }
    }
}
