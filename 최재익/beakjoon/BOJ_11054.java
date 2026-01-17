import java.io.*;
import java.util.*;

public class BOJ_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] r_dp = new int[N+1];
        for(int i=1; i<=N; i++){
            r_dp[i] = 1;

            for(int j=1; j<i; j++){
                if(arr[j]<arr[i] && r_dp[i]<r_dp[j]+1){
                    r_dp[i] = r_dp[j] + 1;
                }
            }
        }

        int[] l_dp = new int[N+1];
        for(int i=N; i>=1; i--){
            l_dp[i] = 1;

            for(int j=N; j>i; j--){
                if(arr[j]<arr[i] && l_dp[i]<l_dp[j]+1){
                    l_dp[i] = l_dp[j] + 1;
                }
            }
        }

        int max = -1;
        for(int i=1; i<=N; i++){
            max = Math.max(max, r_dp[i]+l_dp[i]-1);
        }

        System.out.print(max);
    }
}
