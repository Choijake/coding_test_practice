package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12917

import java.util.*;

public class 문자열내림차순으로배치하기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] arr = new String[s.length()];
            for(int i = 0; i < s.length(); i++) {
                arr[i] = s.substring(i, i + 1);
            }
            Arrays.sort(arr, (a, b) -> {
                return b.compareTo(a);
            });
            for(String str: arr) {
                answer += str;
            }
            return answer;
        }
    }
}
