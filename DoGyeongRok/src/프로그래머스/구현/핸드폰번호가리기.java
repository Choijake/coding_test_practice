package 프로그래머스.구현;

// 2025-06-18
// https://school.programmers.co.kr/learn/courses/30/lessons/12948

public class 핸드폰번호가리기 {
    class Solution {
        public String solution(String phone_number) {
            String answer = "";
            int length = phone_number.length() - 4;
            for(int i = 1; i <= length; i++) {
                answer += "*";
            }
            answer += phone_number.substring(phone_number.length() - 4, phone_number.length());
            return answer;
        }
    }
}
