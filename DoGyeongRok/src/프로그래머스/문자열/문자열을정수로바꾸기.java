package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12925

public class 문자열을정수로바꾸기 {
    class Solution {
        public int solution(String s) {
            return Character.isDigit(s.charAt(0)) ? Integer.parseInt(s) : s.charAt(0) == '+' ? Integer.parseInt(s.substring(1)) : Integer.parseInt(s.substring(1)) * -1;
        }
    }
}
