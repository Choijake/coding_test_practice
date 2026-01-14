package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12918

public class 문자열다루기기본 {
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            if(s.length() == 4 || s.length() == 6) {
                for(int i = 0; i < s.length(); i++) {
                    if(!Character.isDigit(s.charAt(i))) {
                        return false;
                    }
                }
            }else {
                return false;
            }
            return answer;
        }
    }
}
