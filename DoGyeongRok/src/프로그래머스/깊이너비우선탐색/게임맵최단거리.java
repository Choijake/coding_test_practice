package 프로그래머스.깊이너비우선탐색;

// 2025-06-27
// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

public class 게임맵최단거리 {
    class Solution {
        public static int[][] arr;
        public static boolean[][] isVisited;
        public static int[] dx = {-1, 1, 0, 0};
        public static int[] dy = {0, 0, -1, 1};

        public int solution(int[][] maps) {
            int answer = 0;
            arr = new int[maps.length][maps[0].length];
            isVisited = new boolean[maps.length][maps[0].length];
            for(int i = 0; i < maps.length; i++) {
                for(int j = 0; j < maps[i].length; j++) {
                    if(maps[i][j] == 0) {
                        isVisited[i][j] = true;
                    }
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {0, 0});
            arr[0][0] = 1;
            isVisited[0][0] = true;
            while(!queue.isEmpty()) {
                int[] point = queue.poll();
                int cx = point[0];
                int cy = point[1];
                for(int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                        arr[nx][ny] = arr[cx][cy] + 1;
                    }
                }
            }
            return arr[arr.length - 1][arr[0].length - 1] == 0 ? -1 : arr[arr.length - 1][arr[0].length - 1];
        }
    }
}
