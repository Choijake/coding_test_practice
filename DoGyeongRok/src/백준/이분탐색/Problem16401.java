package 백준.이분탐색;

// 2025-06-04
// 과자 나눠주기
// https://www.acmicpc.net/problem/16401

import java.util.*;
import java.io.*;

public class Problem16401 {
    public static int M, N;
    public static long[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        snacks = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(snacks);

        long left = 1;
        long right = snacks[N - 1];
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (long snack : snacks) {
                count += snack / mid;
            }

            if (count >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
