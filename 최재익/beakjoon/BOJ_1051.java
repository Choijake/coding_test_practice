import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1051 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j);
            }
        }

        int answer = 1;
        int min = Math.min(N, M);
        for(int size=2; size<=min; size++){

            ex :
            for(int i=0; i<N-size+1; i++){
                for(int j=0; j<M-size+1; j++){
                    int target = map[i][j];
                    if(target==map[i][j+size-1]
                            && target==map[i+size-1][j]
                            && target==map[i+size-1][j+size-1]
                    ){
                        answer = size*size;
                        continue ex;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
