package 프로그래머스.이분탐색;

// 2025-06-10
// https://school.programmers.co.kr/learn/courses/30/lessons/142085

import java.util.*;

public class 디펜스게임 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int left = 0;
            int right = enemy.length - 1;
            int answer = 0;

            if (enemy.length == 0) {
                return 0;
            }

            while (left <= right) {
                int currentArmy = n;
                int currentPass = k;
                int mid = left + (right - left) / 2;

                List<Integer> currentEnemies = new ArrayList<>();
                for (int i = 0; i <= mid; i++) {
                    currentEnemies.add(enemy[i]);
                }
                Collections.sort(currentEnemies, Collections.reverseOrder());

                boolean canSurvive = true;
                for (int enemyStrength : currentEnemies) {
                    if (currentPass > 0) {
                        currentPass--;
                        if (currentArmy < 0) {
                            canSurvive = false;
                            break;
                        }
                    }
                }

                if (canSurvive) {
                    answer = Math.max(answer, mid + 1);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return answer;
        }
    }
}
