import java.io.*;
import java.util.*;

public class BOJ_11501{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N];
            long answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }
            int max = num[N-1];

            for(int j=N-1; j>=0; j--){
                if(max>=num[j]){
                    answer += (max-num[j]);
                }
                else max = num[j];
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}