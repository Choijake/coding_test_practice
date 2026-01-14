package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12944

public class 평균구하기 {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;
            int sum = 0;
            for(int val : arr) {
                sum += val;
            }
            answer = (double) sum / arr.length;
            return answer;
        }
    }
}
