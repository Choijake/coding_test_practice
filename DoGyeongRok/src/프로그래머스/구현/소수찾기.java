package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12921

public class 소수찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for(int i = 2; i <= n; i++) {
                boolean flag = true;
                for(int j = 2; j * j <= i; j++) {
                    if(i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
