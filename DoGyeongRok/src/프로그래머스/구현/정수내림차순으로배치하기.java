package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12933

import java.util.*;

public class 정수내림차순으로배치하기 {
    class Solution {
        public long solution(long n) {
            String s = "" + n;
            long[] arr = new long[s.length()];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Long.parseLong(s.substring(i, i + 1));
            }
            Arrays.sort(arr);
            String str = "";
            for(int i = arr.length - 1; i >= 0; i--) {
                str += arr[i];
            }
            long answer = Long.parseLong(str);
            return answer;
        }
    }
}
