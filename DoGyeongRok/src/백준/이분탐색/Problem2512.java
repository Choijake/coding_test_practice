package 백준.이분탐색;

// 2025-06-28
// 예산
// https://www.acmicpc.net/problem/2512

import java.util.*;
import java.io.*;

public class Problem2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long money = Long.parseLong(br.readLine());
        Arrays.sort(arr);

        long checkSum = 0;
        for(int i = 0; i < arr.length; i++) {
            checkSum += arr[i];
        }
        if(checkSum <= money) {
            System.out.println(arr[arr.length - 1]);
            return;
        }

        long left = 0;
        long right = money;
        long answer = Long.MIN_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(long val: arr) {
                if(mid < val) {
                    sum += mid;
                }else {
                    sum += val;
                }
            }
            if(sum <= money) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }else if(sum >= money) {
                right = mid - 1;
            }
        }

        sb.append(answer);
        System.out.println(sb);

    }
}
