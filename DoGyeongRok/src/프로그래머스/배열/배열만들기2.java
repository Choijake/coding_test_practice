package 프로그래머스.배열;

// 2025-06-13
// https://school.programmers.co.kr/learn/courses/30/lessons/181921

import java.util.*;

public class 배열만들기2 {
    class Solution {
        public int[] solution(int l, int r) {
            List<Integer> list = new ArrayList<>();
            for(int i = l; i <= r; i++) {
                if(i % 5 == 0) {
                    String target = i + "";
                    boolean flag = true;
                    for(int j = 0; j < target.length(); j++) {
                        if(target.charAt(j) == '0' || target.charAt(j) == '5') {
                            continue;
                        }else {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        list.add(i);
                    }
                }
            }
            if(list.size() == 0) {
                return new int[] {-1};
            }
            int[] answer = new int[list.size()];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
