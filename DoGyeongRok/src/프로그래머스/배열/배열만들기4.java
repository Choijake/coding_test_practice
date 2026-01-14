package 프로그래머스.배열;

// 2025-06-13
// https://school.programmers.co.kr/learn/courses/30/lessons/181918

import java.util.*;

public class 배열만들기4 {
    class Solution {
        public int[] solution(int[] arr) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                if(list.size() == 0) {
                    list.add(arr[i]);
                } else {
                    if(list.get(list.size() - 1) < arr[i]) {
                        list.add(arr[i]);
                    }else {
                        list.remove(list.size() - 1);
                        i--;
                    }
                }
            }
            int[] stk = new int[list.size()];
            for(int i = 0; i < stk.length; i++) {
                stk[i] = list.get(i);
            }
            return stk;
        }
    }
}
