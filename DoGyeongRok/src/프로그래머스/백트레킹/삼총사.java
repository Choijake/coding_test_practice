package 프로그래머스.백트레킹;

// 2025-06-20
// https://school.programmers.co.kr/learn/courses/30/lessons/131705

public class 삼총사 {
    class Solution {
        public static int answer = 0;

        public int solution(int[] number) {
            answer = 0;
            combination(0, 0, 0, number);
            return answer;
        }

        public static void combination(int depth, int start, int sum, int[] number) {
            if (depth == 3) {
                if (sum == 0) {
                    answer++;
                }
                return;
            }

            for (int i = start; i < number.length; i++) {
                combination(depth + 1, i + 1, sum + number[i], number);
            }
        }
    }

}
