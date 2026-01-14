package 프로그래머스.배열;

// 2025-06-15
// https://school.programmers.co.kr/learn/courses/30/lessons/181833

public class 특별한이차원배열1 {
    class Solution {
        public int[][] solution(int n) {
            int[][] answer = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) {
                        answer[i][j] = 1;
                    }
                }
            }
            return answer;
        }
    }
}
