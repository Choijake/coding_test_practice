import java.io.*;
import java.util.*;

public class BOJ_2193_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N==1){
            System.out.print(1);
            return;
        }

        long[] dp = new long[N+1];
        dp[1] = dp[2] = 1;
        for(int i=3; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.print(dp[N]);
    }
}
