package 프로그래머스.구현;

// 2025-06-18
// https://school.programmers.co.kr/learn/courses/30/lessons/12954

public class x만큼간격이있는n개의숫자 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            for(int i = 1; i <= n; i++) {
                answer[i - 1] = (long) x * i;
            }
            return answer;
        }
    }
}
