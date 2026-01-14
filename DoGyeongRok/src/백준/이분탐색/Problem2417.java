package 백준.이분탐색;

// 2025-06-10
// 정수 제곱근
// https://www.acmicpc.net/problem/2417

import java.io.*;

public class Problem2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());
        long left = 0;
        long right = n;
        long answer = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;
            if(Math.pow(mid, 2) >= n) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }else {
                left = mid + 1;
            }
        }

        sb.append(answer);
        System.out.println(sb);

    }
}
