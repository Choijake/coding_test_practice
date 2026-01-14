package 프로그래머스.배열;

// 2025-06-16
// https://school.programmers.co.kr/learn/courses/30/lessons/120833

public class 배열자르기 {
    class Solution {
        public int[] solution(int[] numbers, int num1, int num2) {
            int[] answer = new int[num2 - num1 + 1];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = numbers[num1++];
            }
            return answer;
        }
    }
}
