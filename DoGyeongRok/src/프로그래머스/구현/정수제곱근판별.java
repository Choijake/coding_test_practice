package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12934

public class 정수제곱근판별 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            long target = (long) Math.sqrt(n);
            if(Math.pow(target, 2) == n) {
                answer = (long) Math.pow(target + 1, 2);
            }else {
                answer = -1;
            }
            return answer;
        }
    }
}
