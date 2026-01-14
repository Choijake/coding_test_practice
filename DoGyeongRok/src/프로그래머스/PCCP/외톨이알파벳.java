package 프로그래머스.PCCP;

// 2025-06-30
// https://school.programmers.co.kr/learn/courses/15008/lessons/121683

import java.util.*;

public class 외톨이알파벳 {
    class Solution {
        public String solution(String input_string) {
            int[] arr = new int[26];
            for(int i = 0; i < input_string.length(); i++) {
                arr[input_string.charAt(i) - 'a']++;
            }
            String answer = "";
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] >= 2) {
                    List<Integer> list = new ArrayList<>();
                    for(int j = 0; j < input_string.length(); j++) {
                        if(i == input_string.charAt(j) - 'a') {
                            list.add(j);
                        }
                    }
                    int section = 1;
                    for(int j = 0; j < list.size() - 1; j++) {
                        if(list.get(j) + 1 != list.get(j + 1)) {
                            section++;
                        }
                    }
                    if(section >= 2) {
                        answer += (char) (i + 'a');
                    }
                }
            }
            return answer.equals("") ? "N" : answer;
        }
    }
}
