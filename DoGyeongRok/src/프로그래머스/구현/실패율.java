package 프로그래머스.구현;

// 2025-06-18
// https://school.programmers.co.kr/learn/courses/30/lessons/42889

import java.util.*;

public class 실패율 {
    class StageFail {
        int stage;
        double fail;

        public StageFail(int stage, double fail) {
            this.stage = stage;
            this.fail = fail;
        }
    }

    class Solution {
        public int[] solution(int N, int[] stages) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int val : stages) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }

            int[] arr = new int[N + 2];
            for (int i = 1; i < arr.length; i++) {
                arr[i] = map.getOrDefault(i, 0);
            }

            double[] fail = new double[N + 1];
            int total = stages.length;

            for (int i = 1; i <= N; i++) {
                if (total == 0) {
                    fail[i] = 0;
                } else {
                    fail[i] = (double) arr[i] / total;
                    total -= arr[i];
                }
            }

            List<StageFail> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                list.add(new StageFail(i, fail[i]));
            }

            Collections.sort(list, (a, b) -> {
                if (a.fail == b.fail) {
                    return a.stage - b.stage;
                }
                return Double.compare(b.fail, a.fail);
            });

            int[] answer = new int[N];
            for (int i = 0; i < N; i++) {
                answer[i] = list.get(i).stage;
            }

            return answer;
        }
    }

}
