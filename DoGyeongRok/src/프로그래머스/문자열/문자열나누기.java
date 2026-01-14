package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/140108

public class 문자열나누기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            int same = 0;
            int different = 0;
            char target = s.charAt(0);

            for(int i = 0; i < s.length(); i++) {
                if(same == 0 && different == 0) {
                    target = s.charAt(i);
                }

                if(s.charAt(i) == target) {
                    same++;
                } else {
                    different++;
                }

                if(same == different) {
                    answer++;
                    same = 0;
                    different = 0;
                }
            }

            return same != 0 || different != 0 ? answer + 1 : answer;
        }
    }
}
