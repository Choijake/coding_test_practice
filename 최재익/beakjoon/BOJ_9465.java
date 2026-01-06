import java.io.*;
import java.util.*;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] dp = new int[2][N+1];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(N==1){
                sb.append(Math.max(dp[0][1], dp[1][1])).append("\n");
                continue;
            }

            dp[0][2] += dp[1][1];
            dp[1][2] += dp[0][1];

            for(int i=3; i<=N; i++){
                dp[0][i] = dp[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
                dp[1][i] = dp[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
            }

            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }

        System.out.print(sb);
    }
}
