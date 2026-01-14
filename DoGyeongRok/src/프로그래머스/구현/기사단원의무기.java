package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/136798

public class 기사단원의무기 {
    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            int[] arr = new int[number];
            for (int i = 1; i <= number; i++) {
                int cnt = 0;
                for (int j = 1; j * j <= i; j++) {
                    if (i % j == 0) {
                        cnt += (j * j == i) ? 1 : 2;
                    }
                }
                answer += (cnt > limit) ? power : cnt;
            }
            for(int val: arr) {
                answer += val;
            }
            return answer;
        }
    }
}
