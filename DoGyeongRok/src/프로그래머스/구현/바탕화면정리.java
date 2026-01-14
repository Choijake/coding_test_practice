package 프로그래머스.구현;

// 2025-06-23
// https://school.programmers.co.kr/learn/courses/30/lessons/161990

import java.util.*;

public class 바탕화면정리 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            for(int i = 0; i < wallpaper.length; i++) {
                for(int j = 0; j < wallpaper[i].length(); j++) {
                    String str = wallpaper[i].substring(j, j + 1);
                    if(str.equals("#")) {
                        x.add(i);
                        y.add(j);
                    }
                }
            }

            Collections.sort(x);
            Collections.sort(y);

            answer[0] = x.get(0);
            answer[1] = y.get(0);
            answer[2] = x.get(x.size() - 1) + 1;
            answer[3] = y.get(y.size() - 1) + 1;

            return answer;
        }
    }
}
