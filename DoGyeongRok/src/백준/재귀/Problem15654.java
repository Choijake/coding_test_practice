package 백준.재귀;

// 2025-06-27
// N과 M(5)
// https://www.acmicpc.net/problem/15654

import java.io.*;
import java.util.*;

public class Problem15654 {
    private static int N, M;
    private static int[] arr, result;
    private static boolean[] isVisited;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = new int[M];
        rf(0);
        System.out.println(sb);
    }

    public static void rf(int depth) {
        if(depth == M) {
            for(int num: result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = arr[i];
                rf(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
