import java.io.*;
import java.util.*;

public class BOJ_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=N-1; i>=1; i--){
            if(score[i]<=score[i-1]){
                answer += score[i-1]-(score[i]-1);
                score[i-1] = score[i]-1;
            }
        }

        System.out.print(answer);
    }
}
