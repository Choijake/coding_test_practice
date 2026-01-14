package 프로그래머스.배열;

// 2025-06-13
// https://school.programmers.co.kr/learn/courses/30/lessons/181901

public class 배열만들기1 {
    class Solution {
        public int[] solution(int n, int k) {
            int[] answer = new int[n / k];
            int idx = 0;
            for(int i = 1; i <= n; i++) {
                if(i % k == 0) {
                    answer[idx++] = i;
                }
            }
            return answer;
        }
    }
}
