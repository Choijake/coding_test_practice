package 프로그래머스.그래프;

// 2025-06-28
// https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

public class 가장먼노드 {
    class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            List<List<Integer>> adj = new ArrayList<>();
            boolean[] isVisited = new boolean[n + 1];
            int[] result = new int[n + 1];
            for(int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            for(int i = 0; i < edge.length; i++) {
                int from = edge[i][0];
                int to = edge[i][1];
                adj.get(from).add(to);
                adj.get(to).add(from);
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            isVisited[1] = true;
            result[1] = 0;
            int max = -1;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int node: adj.get(cur)) {
                    if(!isVisited[node]) {
                        isVisited[node] = true;
                        result[node] = result[cur] + 1;
                        max = Math.max(max, result[node]);
                        queue.offer(node);
                    }
                }
            }
            for(int i = 1; i < result.length; i++) {
                if(result[i] == max) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
