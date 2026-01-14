package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/76501

public class 음양더하기 {
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for(int i = 0; i < absolutes.length; i++) {
                answer += signs[i] == true ? absolutes[i] : -absolutes[i];
            }
            return answer;
        }
    }
}
