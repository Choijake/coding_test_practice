import java.io.*;
import java.util.*;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            dp[i] = 1;

            for(int j=1; j<i; j++){
                if(arr[j]<arr[i] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int answer = -1;
        for(int i=1; i<=N; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}
