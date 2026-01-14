package 프로그래머스.구현;

// 2025-06-20
// https://school.programmers.co.kr/learn/courses/30/lessons/132267

public class 콜라문제 {
    class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;
            int bottle = n;
            while(bottle >= a) {
                int q = bottle / a;
                int r = bottle % a;
                answer += q * b;
                bottle = q * b + r;
            }
            return answer;
        }
    }
}
