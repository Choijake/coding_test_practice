package 백준.이분탐색;

// 2025-06-05
// 입국심사
// https://www.acmicpc.net/problem/3079

import java.io.*;
import java.util.*;

public class Problem3079 {
    private static int N;
    private static long M;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long left = 0;
        long right = arr[arr.length - 1] * M;
        long answer = right;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(long time: arr) {
                sum += mid / time;
                if (sum >= M) break;
            }
            if(M <= sum) {
                answer = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        sb.append(answer);
        System.out.println(answer);
    }
}
