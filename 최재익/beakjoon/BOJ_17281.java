import java.io.*;
import java.util.*;

public class BOJ_17281 {
    static boolean[] visited;
    static int answer;
    static int N;
    static int[][] arr;
    static int[][] result;
    static int[] sequence;
    static int[] state;
    static int score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][10];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        visited = new boolean[10];
        result = new int[N+1][10];
        sequence = new int[10];
        sequence[4] = 1;
        visited[1] = true;

        permutation(1);

        System.out.println(answer);
    }

    static int getScore(){
        int inn = 1;
        int seq = 0;
        score = 0;
        int outCount = 0;
        state = new int[4];

        while(true){
            if(inn>N)break;

            int cur = arr[inn][sequence[(seq++)%9+1]];

            if(cur==0){
                outCount++;

                if(outCount==3){
                    state = new int[4];
                    inn++;
                    outCount = 0;
                }
            }
            else if(cur==1 || cur==2 || cur==3){
                update(cur);
            }
            else{
                for(int i=1; i<=3; i++){
                    score += state[i];
                }
                score++;

                state = new int[4];
            }
        }

        return score;
    }

    static void update(int n){
        for(int i=3; i>=1; i--){
            if(state[i]<1)continue;

            int next = i + n;

            if(next>3){
                state[i]=0;
                score++;
            }
            else{
                state[next]=1;
                state[i]=0;
            }
        }

        state[n]=1;
    }

    static void permutation(int depth){
        if(depth == 10){
            answer = Math.max(answer, getScore());
            return;
        }

        if(depth==4){
            permutation(depth+1);
            return;
        }

        for(int i=2; i<=9; i++){
            if(!visited[i]){
                sequence[depth] = i;
                visited[i] = true;
                permutation(depth+1);
                visited[i] = false;
            }
        }
    }
}
