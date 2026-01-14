package 백준.그래프;

// 2025-06-27
// DFS와 BFS
// https://www.acmicpc.net/problem/1260

import java.io.*;
import java.util.*;

public class Problem1260 {
    public static int N, M, V;
    public static List<List<Integer>> adj;
    public static boolean[] isVisited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];
        adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        for(int i = 0; i < adj.size(); i++) {
            Collections.sort(adj.get(i));
        }
        dfs(V);
        Arrays.fill(isVisited, false);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int node) {
        isVisited[node] = true;
        sb.append(node).append(" ");
        for(int child: adj.get(node)) {
            if(!isVisited[child]) {
                dfs(child);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[node] = true;
        queue.offer(node);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for(int child: adj.get(cur)) {
                if(!isVisited[child]) {
                    isVisited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }
}
