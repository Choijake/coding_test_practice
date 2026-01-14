package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12930

public class 이상한문자만들기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            int count = 0;
            for(int i = 0; i < s.length(); i++) {
                String str = s.substring(i, i + 1);
                if(str.equals(" ")) {
                    answer += str;
                    count = 0;
                }else {
                    if(count % 2 == 0) {
                        answer += str.toUpperCase();
                        count++;
                    }else {
                        answer += str.toLowerCase();
                        count++;
                    }
                }
            }
            return answer;
        }
    }
}
