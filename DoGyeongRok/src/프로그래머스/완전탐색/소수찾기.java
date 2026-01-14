package 프로그래머스.완전탐색;

// 2025-06-12
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
// 순열(백트레킹)

import java.util.*;

public class 소수찾기 {
    class Solution {
        public static int answer;
        public static String[] arr, result;
        public static boolean[] isVisited;
        public static Set<Integer> set;

        public int solution(String numbers) {
            arr = new String[numbers.length()];
            result = new String[numbers.length()];
            isVisited = new boolean[numbers.length()];
            set = new HashSet<>();

            for(int i = 0; i < numbers.length(); i++) {
                arr[i] = numbers.substring(i, i + 1);
            }

            answer = 0;
            for(int i = 1; i <= numbers.length(); i++) {
                permutation(0, i);
            }
            calc();
            return answer;
        }

        public static void permutation(int depth, int length) {
            if(depth == length) {
                String val = "";
                for(int i = 0; i < length; i++) {
                    val += result[i];
                }
                int target = Integer.parseInt(val);
                set.add(target);
                return;
            }
            for(int i = 0; i < arr.length; i++) {
                if(isVisited[i]) continue;
                result[depth] = arr[i];
                isVisited[i] = true;
                permutation(depth + 1, length);
                isVisited[i] = false;
            }
        }

        public static void calc() {
            for(int val: set) {
                if(val < 2) continue;
                boolean flag = true;
                for(int i = 2; i <= Math.sqrt(val); i++) {
                    if(val % i == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    answer++;
                }
            }
        }
    }
}
