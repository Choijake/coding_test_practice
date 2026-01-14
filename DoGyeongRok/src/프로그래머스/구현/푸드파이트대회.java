package 프로그래머스.구현;

// 2025-06-20
// https://school.programmers.co.kr/learn/courses/30/lessons/134240

import java.util.*;

public class 푸드파이트대회 {
    class Solution {
        public String solution(int[] food) {
            int[] calc = new int[food.length];
            int size = 0;
            for(int i = 1; i < food.length; i++) {
                calc[i] = food[i] / 2;
                size += food[i] / 2;
            }
            size *= 2;
            size += 1;
            List<Integer> list = new ArrayList<>();

            for(int i = 1; i < calc.length; i++) {
                int loop = calc[i];
                for(int j = 0; j < loop; j++) {
                    list.add(i);
                }
            }

            list.add(0);
            int idx = list.size() - 2;
            for(int i = 0; i < size / 2; i++) {
                list.add(list.get(idx--));
            }
            String answer = "";
            for(int val: list) {
                answer += val;
            }
            return answer;
        }
    }
}
