package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12916

public class 문자열내p와y의개수 {
    class Solution {
        boolean solution(String s) {
            s = s.toLowerCase();
            int p = 0;
            int y = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'p') {
                    p++;
                }else if(s.charAt(i) == 'y'){
                    y++;
                }
            }
            return p == y;
        }
    }
}
