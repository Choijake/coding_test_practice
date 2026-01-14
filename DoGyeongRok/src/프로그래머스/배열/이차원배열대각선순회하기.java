package 프로그래머스.배열;

// 2025-06-15
// https://school.programmers.co.kr/learn/courses/30/lessons/181829

public class 이차원배열대각선순회하기 {
    class Solution {
        public int solution(int[][] board, int k) {
            int answer = 0;
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    if(i + j <= k) {
                        answer += board[i][j];
                    }
                }
            }
            return answer;
        }
    }
}
