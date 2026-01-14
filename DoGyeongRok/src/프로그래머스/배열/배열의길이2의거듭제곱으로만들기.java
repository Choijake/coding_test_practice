package 프로그래머스.배열;

// 2025-06-14
// https://school.programmers.co.kr/learn/courses/30/lessons/181857

import java.util.*;

public class 배열의길이2의거듭제곱으로만들기 {
    class Solution {
        public int[] solution(int[] arr) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            int idx = 0;
            while((int) Math.pow(2, idx) < list.size()) {
                idx++;
            }
            int size = (int) Math.pow(2, idx);
            for(int i = 0; i < size - arr.length; i++) {
                list.add(0);
            }
            int[] answer = new int[list.size()];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
