package 백준.재귀;

// 2025-06-27
// 피보나치 수
// https://www.acmicpc.net/problem/2747

import java.io.*;

public class Problem2747 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[50];
        arr[0] = 0;
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int num) {
        if(num == 1 || num == 2) {
            arr[num] = 1;
            return arr[num];
        }
        if(arr[num] != 0) {
            return arr[num];
        }
        arr[num] = fibonacci(num - 2) + fibonacci(num - 1);
        return arr[num];
    }
}
