package 프로그래머스.배열;

// 2025-06-14
// https://school.programmers.co.kr/learn/courses/30/lessons/181860

import java.util.*;

public class 빈배열에추가삭제하기 {
    class Solution {
        public int[] solution(int[] arr, boolean[] flag) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                int val = arr[i];
                if(flag[i]) {
                    for(int j = 0; j < val * 2; j++) {
                        list.add(val);
                    }
                }else {
                    for(int j = 0; j < val; j++) {
                        list.remove(list.size() - 1);
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
