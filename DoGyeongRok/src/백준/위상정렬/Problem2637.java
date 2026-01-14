package 백준.위상정렬;

// 2025-06-29
// 장난감 조립
// https://www.acmicpc.net/problem/2637

import java.io.*;
import java.util.*;

public class Problem2637 {
    public static class Toy {
        private int to;
        private int cnt;

        public Toy(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] a = new int[N + 1];
        int[] b = new int[N + 1];
        int[] calc = new int[N + 1];
        calc[N] = 1;

        List<List<Toy>> adj = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            adj.get(from).add(new Toy(to, cnt));
            a[from]++;
            b[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(Toy toy: adj.get(cur)) {
                b[toy.to]--;
                calc[toy.to] += calc[cur] * toy.cnt;
                if(b[toy.to] == 0) {
                    queue.offer(toy.to);
                }
            }
        }

        for(int i = 1; i < N; i++) {
            if(a[i] == 0) {
                sb.append(i).append(" ").append(calc[i]).append("\n");
            }
        }
        System.out.println(sb);

    }
}
