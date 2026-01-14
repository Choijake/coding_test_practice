package 프로그래머스.배열;

// 2025-06-13
// https://school.programmers.co.kr/learn/courses/30/lessons/181909

import java.util.*;

public class 접미사배열 {
    class Solution {
        public String[] solution(String my_string) {
            String[] answer = new String[my_string.length()];
            for(int i = 0; i < my_string.length(); i++) {
                answer[i] = my_string.substring(i);
            }
            Arrays.sort(answer);
            return answer;
        }
    }
}
