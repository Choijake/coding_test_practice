package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12931

public class 자릿수더하기 {
    public class Solution {
        public int solution(int n) {
            int answer = 0;
            String str = "" + n;
            for(int i = 0; i < str.length(); i++) {
                answer += Integer.parseInt(str.substring(i, i + 1));
            }
            return answer;
        }
    }
}
