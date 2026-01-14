package 프로그래머스.구현;

// 2025-06-18
// https://school.programmers.co.kr/learn/courses/30/lessons/68935

public class 삼진법뒤집기 {
    class Solution {
        public int solution(int n) {
            String str = "";
            int target = n;
            while(target != 0) {
                str += target % 3;
                target /= 3;
            }
            int answer = 0;
            for(int i = str.length() - 1; i >= 0; i--) {
                answer += (int) Math.pow(3, str.length() - 1 - i) * Integer.parseInt(str.substring(i, i + 1));
            }
            return answer;
        }
    }
}
