package 프로그래머스.문자열;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/81301

public class 숫자문자열과영단어 {
    class Solution {
        public int solution(String s) {
            String answer = "";
            String str = "";
            for(int i = 0; i < s.length(); i++) {
                String target = s.substring(i, i + 1);
                if(Character.isDigit(s.charAt(i))) {
                    answer += target;
                } else {
                    str += target;
                    switch(str) {
                        case "zero":
                            answer += "0";
                            str = "";
                            break;
                        case "one":
                            answer += "1";
                            str = "";
                            break;
                        case "two":
                            answer += "2";
                            str = "";
                            break;
                        case "three":
                            answer += "3";
                            str = "";
                            break;
                        case "four":
                            answer += "4";
                            str = "";
                            break;
                        case "five":
                            answer += "5";
                            str = "";
                            break;
                        case "six":
                            answer += "6";
                            str = "";
                            break;
                        case "seven":
                            answer += "7";
                            str = "";
                            break;
                        case "eight":
                            answer += "8";
                            str = "";
                            break;
                        case "nine":
                            answer += "9";
                            str = "";
                            break;
                    }
                }
            }
            return Integer.parseInt(answer);
        }
    }
}
