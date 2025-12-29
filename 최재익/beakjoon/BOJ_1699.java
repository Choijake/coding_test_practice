import java.io.*;
import java.util.*;

public class BOJ_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = i;

            for(int j=1; j*j<=i; j++){
                if(dp[i] > dp[i-j*j]+1){
                    dp[i] = dp[i-j*j]+1;
                }
            }
        }

        System.out.print(dp[N]);
    }
}
