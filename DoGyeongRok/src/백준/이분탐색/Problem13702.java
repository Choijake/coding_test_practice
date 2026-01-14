package 백준.이분탐색;

// 2025-06-10
// 이상한 술집
// https://www.acmicpc.net/problem/13702

import java.io.*;
import java.util.*;

public class Problem13702 {
    public static int N, K;
    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long left = 1;
        long right = arr[arr.length - 1];
        long answer = -1;

        while(left <= right) {
            long mid = (left + right) / 2;
            int count = 0;
            for(long val: arr) {
                count += val / mid;
            }
            if(count < K) {
                right = mid - 1;
            }else {
                answer = mid;
                left = mid + 1;
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }

}
