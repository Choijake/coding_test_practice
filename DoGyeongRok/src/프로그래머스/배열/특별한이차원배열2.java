package 프로그래머스.배열;

// 2025-06-15
// https://school.programmers.co.kr/learn/courses/30/lessons/181831

public class 특별한이차원배열2 {
    class Solution {
        public int solution(int[][] arr) {
            int answer = 1;
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    if(arr[i][j] != arr[j][i]) {
                        return 0;
                    }
                }
            }
            return answer;
        }
    }
}
