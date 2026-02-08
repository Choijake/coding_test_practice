import java.io.*;
import java.util.*;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] times = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int tmp = 0;
        int answer = 0;
        for(int i=0; i<N; i++){
            tmp += times[i];
            answer += tmp;
        }

        System.out.print(answer);
    }
}