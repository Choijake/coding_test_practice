import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minBundle = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int bundle = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());

            minBundle = Math.min(bundle, minBundle);
            minEach = Math.min(each, minEach);
        }

        int answer;
        if(N <= 6){
            answer = Math.min(minBundle, N*minEach);
        }
        else answer = Math.min(Math.min((N/6+1)*minBundle ,(N/6)*minBundle+(N%6)*minEach), N*minEach);

        System.out.println(answer);
    }
}
