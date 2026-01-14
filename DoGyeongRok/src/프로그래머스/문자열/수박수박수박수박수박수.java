package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12922

public class 수박수박수박수박수박수 {
    class Solution {
        public String solution(int n) {
            String answer = "";
            for(int i = 1; i <= n; i++) {
                answer += i % 2 == 0 ? "박" : "수";
            }
            return answer;
        }
    }
}
