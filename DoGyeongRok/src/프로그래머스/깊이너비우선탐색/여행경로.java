package 프로그래머스.깊이너비우선탐색;

// 2025-06-28
// https://school.programmers.co.kr/learn/courses/30/lessons/43164

import java.util.*;

public class 여행경로 {
    class Solution {
        public static List<String> list;
        public static boolean[] isVisited;
        public String[] solution(String[][] tickets) {
            isVisited = new boolean[tickets.length];
            list = new ArrayList<>();

            dfs("ICN", "ICN", tickets, 0);
            Collections.sort(list);

            return list.get(0).split(" ");
        }
        public static void dfs(String cur, String path, String[][] tickets, int depth) {
            if(depth == tickets.length) {
                list.add(path);
                return;
            }
            for(int i = 0; i < tickets.length; i++) {
                if(!isVisited[i] && cur.equals(tickets[i][0])) {
                    isVisited[i] = true;
                    dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth + 1);
                    isVisited[i] = false;
                }
            }
        }
    }
}
