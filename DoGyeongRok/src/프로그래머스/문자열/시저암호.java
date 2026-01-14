package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12926

public class 시저암호 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == ' ') {
                    answer += ch;
                } else if(ch >= 'A' && ch <= 'Z') {
                    int num = (int) ch + n;
                    if(num > 'Z') {
                        num = num - 26;
                    }
                    answer += (char) num;
                } else if(ch >= 'a' && ch <= 'z') {
                    int num = (int) ch + n;
                    if(num > 'z') {
                        num = num - 26;
                    }
                    answer += (char) num;
                }
            }
            return answer;
        }
    }
}
