package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12903

public class 가운데글자가져오기 {
    class Solution {
        public String solution(String s) {
            String answer = s.length() % 2 == 0 ? s.substring(s.length() / 2 - 1, s.length() / 2 + 1) : s.substring(s.length() / 2, s.length() / 2 + 1);
            return answer;
        }
    }
}
