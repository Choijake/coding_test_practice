package 프로그래머스.깊이너비우선탐색;

// 2025-06-12
// https://school.programmers.co.kr/learn/courses/30/lessons/43165

import java.util.*;

public class 타겟넘버 {
    class Solution {
        public static int answer;
        public static int[] nums;
        public static int target;

        public int solution(int[] numbers, int target) {
            answer = 0;
            nums = numbers;
            Solution.target = target;
            dfs(0, 0);
            return answer;
        }

        public static void dfs(int depth, int sum) {
            if (depth == nums.length) {
                if (sum == target) {
                    answer++;
                }
                return;
            }

            dfs(depth + 1, sum + nums[depth]);
            dfs(depth + 1, sum - nums[depth]);
        }
    }
}
