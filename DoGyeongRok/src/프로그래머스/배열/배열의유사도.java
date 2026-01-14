package 프로그래머스.배열;

// 2025-06-16
// https://school.programmers.co.kr/learn/courses/30/lessons/120903

public class 배열의유사도 {
    class Solution {
        public int solution(String[] s1, String[] s2) {
            int answer = 0;
            if(s1.length > s2.length) {
                for(int i = 0; i < s1.length; i++) {
                    for(int j = 0; j < s2.length; j++) {
                        if(s1[i].equals(s2[j])) {
                            answer++;
                        }
                    }
                }
            }else {
                for(int i = 0; i < s2.length; i++) {
                    for(int j = 0; j < s1.length; j++) {
                        if(s2[i].equals(s1[j])) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
