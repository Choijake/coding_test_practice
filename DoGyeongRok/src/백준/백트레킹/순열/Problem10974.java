package 백준.백트레킹.순열;

// 2025-06-12
// 모든 순열
// https://www.acmicpc.net/problem/10974

import java.io.*;

public class Problem10974 {
    public static int N;
    public static int[] arr, result;
    public static boolean[] isVisited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        result = new int[N + 1];
        isVisited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            arr[i] = i;
        }

        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int depth) {
        if(depth == N) {
            for(int i = 1; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i < arr.length; i++) {
            if(isVisited[i]) continue;
            result[depth + 1] = arr[i];
            isVisited[i] = true;
            permutation(depth + 1);
            isVisited[i] = false;
        }
    }
}
