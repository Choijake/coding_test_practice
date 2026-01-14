package 프로그래머스.구현;

// 2025-06-16
// https://school.programmers.co.kr/learn/courses/30/lessons/77884

public class 약수의개수와덧셈 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for(int i = left; i <= right; i++) {
                int count = 0;
                for(int j = 1; j <= i; j++) {
                    if(i % j == 0) {
                        count++;
                    }
                }
                answer += count % 2 == 0 ? i : -i;
            }
            return answer;
        }
    }
}
