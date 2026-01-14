package 프로그래머스.그리디;

// 2025-06-19
// https://school.programmers.co.kr/learn/courses/30/lessons/135808

import java.util.*;

public class 과일장수 {
    class Solution {
        public int solution(int k, int m, int[] score) {
            int[] arr = score;
            Arrays.sort(arr);
            int answer = 0;
            for(int i = arr.length - 1; i >= 0; i -= m) {
                int idx = i - m + 1;
                if(idx >= 0) {
                    answer += arr[idx] * m;
                }
            }
            return answer;
        }
    }
}
