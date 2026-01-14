package 프로그래머스.배열;

// 2025-06-14
// https://school.programmers.co.kr/learn/courses/30/lessons/181893

import java.util.*;

public class 배열조각하기 {
    class Solution {
        public int[] solution(int[] arr, int[] query) {
            List<Integer> list = new ArrayList<>();
            for(int val: arr) {
                list.add(val);
            }
            for(int i = 0; i < query.length; i++) {
                int idx = query[i];
                if(i % 2 == 0) {
                    int count = list.size() - idx - 1;
                    for(int j = 0; j < count; j++) {
                        list.remove(list.size() - 1);
                    }
                }else {
                    int count = idx - 1;
                    for(int j = 0; j <= count; j++) {
                        list.remove(0);
                    }
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
