import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1205 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N==0){
            System.out.print(1);
            return;
        }

        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int answer = -1;
        int bigger = 0;
        int same = 0;
        for(int i=0; i<scores.length; i++){
            if(score < scores[i])bigger++;
            else if(score == scores[i])same++;
        }

        if(bigger+same+1 <= P)answer=bigger+1;

        System.out.println(answer);
    }
}
