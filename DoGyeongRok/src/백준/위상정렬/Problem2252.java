package 백준.위상정렬;

// 2025-06-29
// 줄 세우기
// https://www.acmicpc.net/problem/2252

import java.io.*;
import java.util.*;

public class Problem2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            arr[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int node: adj.get(cur)) {
                arr[node]--;
                if(arr[node] == 0) {
                    queue.offer(node);
                }
            }
            sb.append(cur).append(" ");
        }
        System.out.println(sb);
    }
}
