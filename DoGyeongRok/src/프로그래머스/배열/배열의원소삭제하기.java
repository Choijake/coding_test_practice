package 프로그래머스.배열;

// 2025-06-14
// https://school.programmers.co.kr/learn/courses/30/lessons/181844

import java.util.*;

public class 배열의원소삭제하기 {
    class Solution {
        public int[] solution(int[] arr, int[] delete_list) {
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();

            for(int val: arr) {
                listA.add(val);
            }
            for(int val: delete_list) {
                listB.add(val);
            }

            for(int i = 0; i < listB.size(); i++) {
                listA.remove(Integer.valueOf(listB.get(i)));
            }

            int[] answer = new int[listA.size()];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = listA.get(i);
            }
            return answer;
        }
    }
}
