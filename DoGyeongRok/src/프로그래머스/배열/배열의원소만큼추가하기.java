package 프로그래머스.배열;

// 2025-06-14
// https://school.programmers.co.kr/learn/courses/30/lessons/181861

import java.util.*;

public class 배열의원소만큼추가하기 {
    class Solution {
        public int[] solution(int[] arr) {
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i]; j++) {
                    list.add(arr[i]);
                }
            }

            int[] answer = new int[list.size()];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
