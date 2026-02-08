import java.io.*;
import java.util.*;

public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        int answer = 0;
        for(int i=0; i<N; i++){
            answer += A[i]*B[i];
        }

        System.out.print(answer);
    }
}
