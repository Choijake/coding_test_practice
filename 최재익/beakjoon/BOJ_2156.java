import java.io.*;
import java.util.*;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];

        if(N==1){
            System.out.print(arr[1]);
            return;
        }

        dp[1] = arr[1];
        dp[2] = arr[1]+arr[2];

        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-1], Math.max(arr[i]+dp[i-2], arr[i]+arr[i-1]+dp[i-3]));
        }

        System.out.print(dp[N]);
    }
}
