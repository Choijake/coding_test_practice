package 프로그래머스.배열;

import java.util.*;

public class 배열만들기5 {
    class Solution {
        public int[] solution(String[] intStrs, int k, int s, int l) {
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < intStrs.length; i++) {
                String str = intStrs[i].substring(s, s + l);
                if(Integer.parseInt(str) > k) {
                    list.add(Integer.parseInt(str));
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
