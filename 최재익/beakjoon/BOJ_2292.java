import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int t = 1;
        int m = 0;
        int answer = 0;
        while(true){
            t += 6*m;
            if(N<=t){
                answer = m+1;
                break;
            }

            m++;
        }

        System.out.print(answer);
    }
}
