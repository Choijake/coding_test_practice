package 프로그래머스.정렬;

// 2025-06-04
// https://school.programmers.co.kr/learn/courses/30/lessons/42747
// 정렬 chapter 이긴 하나 이분탐색으로 풀었음

import java.util.*;

public class H_Index {
    class Solution {
        public int solution(int[] citations) {
            int[] arr = citations;
            Arrays.sort(arr);

            int left = 0;
            int right = arr[arr.length - 1];
            int answer = Integer.MIN_VALUE;

            while(left <= right) {
                int mid = (left + right) / 2;
                int count = 0;
                for(int citation: citations) {
                    if(citation >= mid) {
                        count++;
                    }
                }

                if(count >= mid) {
                    answer = Math.max(answer, mid);
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            return answer;
        }
    }
}
