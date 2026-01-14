package 프로그래머스.배열;

// 2025-06-16
// https://school.programmers.co.kr/learn/courses/30/lessons/12932

public class 자연수뒤집어배열로만들기 {
    class Solution {
        public int[] solution(long n) {
            String target = "" + n;
            int[] answer = new int[target.length()];
            int startIndex = target.length() - 1;
            for(int i = 0; i < answer.length; i++) {
                answer[i] = Integer.parseInt(target.substring(startIndex, startIndex + 1));
                startIndex--;
            }
            return answer;
        }
    }
}
