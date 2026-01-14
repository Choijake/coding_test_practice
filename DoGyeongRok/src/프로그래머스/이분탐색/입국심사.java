package 프로그래머스.이분탐색;

// 2025-06-04
// https://school.programmers.co.kr/learn/courses/30/lessons/43238

import java.util.*;

public class 입국심사 {
    class Solution {
        public long solution(int n, int[] times) {
            long[] arr = new long[times.length];
            for(int i = 0; i < times.length; i++) {
                arr[i] = times[i];
            }
            Arrays.sort(arr);

            long left = 0;
            long right = arr[arr.length - 1] * n;
            long answer = Long.MAX_VALUE;

            while(left <= right) {
                long mid = (left + right) / 2;
                long sum = 0;
                for(long time : times) {
                    sum += mid / time;
                }
                if(n <= sum) {
                    right = mid - 1;
                    answer = Math.min(answer, mid);
                }else if(n > sum) {
                    left = mid + 1;
                }
            }

            return answer;
        }
    }
}
