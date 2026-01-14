package 프로그래머스.구현;

// 2025-06-25
// https://school.programmers.co.kr/learn/courses/30/lessons/340198

import java.util.*;

public class 공원 {
    class Solution {
        public int solution(int[] mats, String[][] park) {
            Arrays.sort(mats);
            int answer = -1;
            int x = park.length;
            int y = park[0].length;

            for(int i = 0; i < mats.length; i++) {
                for(int j = 0; j < park.length; j++) {
                    for(int k = 0; k < park[j].length; k++) {
                        if(park[j][k].equals("-1")) {
                            int count = 0;
                            for(int m = j; m < j + mats[i]; m++) {
                                for(int n = k; n < k + mats[i]; n++) {
                                    if(m < x && n < y && park[m][n].equals("-1")) {
                                        count++;
                                    }
                                }
                            }
                            if(count == mats[i] * mats[i]) {
                                answer = Math.max(answer, mats[i]);
                            }
                        }
                    }
                }
            }

            return answer;
        }
    }
}
