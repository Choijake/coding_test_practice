package 프로그래머스.배열;

// 2025-06-14
// https://school.programmers.co.kr/learn/courses/30/lessons/181875

public class 배열에서문자열대소문자변환하기 {
    class Solution {
        public String[] solution(String[] strArr) {
            String[] answer = new String[strArr.length];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = i % 2 == 0 ? strArr[i].toLowerCase() : strArr[i].toUpperCase();
            }
            return answer;
        }
    }
}
