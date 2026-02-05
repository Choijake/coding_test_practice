import java.io.*;
import java.util.*;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int idx = N-1;
        while(idx>=0 && K>0){
            if(K>=coins[idx]){
                answer += K/coins[idx];
                K %= coins[idx];
            }

            idx--;
        }

        System.out.print(answer);
    }
}
