package 프로그래머스.그리디;

// 2025-06-23
// https://school.programmers.co.kr/learn/courses/30/lessons/161989

public class 덧칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int max = 0;

            for (int sec : section) {
                if (max <= sec) {
                    max = sec + m;
                    answer++;
                }
            }
            return answer;
        }
    }
}
