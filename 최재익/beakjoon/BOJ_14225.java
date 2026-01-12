import java.io.*;
import java.util.*;

public class BOJ_14225 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        int size = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            size += arr[i];
        }
        visited = new boolean[size+2];

        explore(0, 0);

        for(int i=1; i<visited.length; i++){
            if(!visited[i]){
                System.out.print(i);
                return;
            }
        }
    }

    static void explore(int depth, int sum){
        if(depth==N){
            visited[sum] = true;
            return;
        }

        explore(depth+1, sum+arr[depth]);
        explore(depth+1, sum);
    }
}
