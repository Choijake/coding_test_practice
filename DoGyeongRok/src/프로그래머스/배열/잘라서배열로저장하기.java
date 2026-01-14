package 프로그래머스.배열;

// 2025-06-16
// https://school.programmers.co.kr/learn/courses/30/lessons/120913

public class 잘라서배열로저장하기 {
    class Solution {
        public String[] solution(String my_str, int n) {
            String[] answer = new String[my_str.length() % n == 0 ? my_str.length() / n : my_str.length() / n + 1];
            int limit = my_str.length();
            int idx = 0;
            for(int i = 0; i < my_str.length(); i += n) {
                if(i + n > my_str.length()) {
                    answer[idx] = my_str.substring(i);
                }else {
                    answer[idx++] = my_str.substring(i, i + n);
                }
            }
            return answer;
        }
    }
}
