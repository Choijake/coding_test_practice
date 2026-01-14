package 프로그래머스.깊이너비우선탐색;

// 2025-06-27
// https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.*;

public class 네트워크 {
    class Solution {
        public static List<List<Integer>> adj;
        public static boolean[] isVisited;

        public int solution(int n, int[][] computers) {
            int answer = 0;
            adj = new ArrayList<>();
            isVisited = new boolean[n];
            for(int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for(int i = 0; i < computers.length; i++) {
                int from = i;
                for(int j = 0; j < computers[i].length; j++) {
                    if(i != j) {
                        if(computers[i][j] == 1) {
                            int to = j;
                            adj.get(from).add(to);
                            adj.get(to).add(from);
                        }
                    }
                }
            }
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < isVisited.length; i++) {
                if(!isVisited[i]) {
                    queue.offer(i);
                    while(!queue.isEmpty()) {
                        int cur = queue.poll();
                        isVisited[cur] = true;
                        for(int child: adj.get(cur)) {
                            if(!isVisited[child]) {
                                queue.offer(child);
                            }
                        }
                    }
                    answer++;
                }
            }
            return answer;
        }
    }
}
