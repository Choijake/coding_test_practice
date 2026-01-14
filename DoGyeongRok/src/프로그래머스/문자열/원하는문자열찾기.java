package 프로그래머스.문자열;

// 2025-06-04
// https://school.programmers.co.kr/learn/courses/30/lessons/181878?language=java

public class 원하는문자열찾기 {
    class Solution {
        public int solution(String myString, String pat) {
            int answer = 0;
            for (int i = 0; i <= myString.length() - pat.length(); i++) {
                String splitMyString = myString.substring(i, i + pat.length());
                if (splitMyString.equalsIgnoreCase(pat)) {
                    answer = 1;
                    break;
                }
            }
            return answer;
        }
    }
}
