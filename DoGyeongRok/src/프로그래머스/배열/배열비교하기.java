package 프로그래머스.배열;

// 2025-06-14
// https://school.programmers.co.kr/learn/courses/30/lessons/181856

import java.util.*;

public class 배열비교하기 {
    class Solution {
        public int solution(int[] arr1, int[] arr2) {
            int arr1Length = arr1.length;
            int arr2Length = arr2.length;
            if(arr1Length > arr2Length) {
                return 1;
            }else if(arr1Length < arr2Length) {
                return -1;
            }else {
                int arr1Sum = 0;
                for(int num: arr1) {
                    arr1Sum += num;
                }
                int arr2Sum = 0;
                for(int num: arr2) {
                    arr2Sum += num;
                }
                return arr1Sum > arr2Sum ? 1 : arr1Sum < arr2Sum ? -1 : 0;
            }
        }
    }
}
