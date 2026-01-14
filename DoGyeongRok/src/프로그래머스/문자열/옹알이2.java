package 프로그래머스.문자열;

// 2025-06-25
// https://school.programmers.co.kr/learn/courses/30/lessons/133499

public class 옹알이2 {
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] possible = {"aya", "ye", "woo", "ma"};
            String[] impossible = {"ayaaya", "yeye", "woowoo", "mama"};
            for(String str: babbling) {
                for(String check: impossible) {
                    str = str.replace(check, "X");
                }
                for(String check: possible) {
                    str = str.replace(check, "O");
                }
                boolean flag = true;
                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) != 'O') {
                        flag = false;
                        break;
                    }
                }
                answer += flag ? 1 : 0;
            }
            return answer;
        }
    }

}
