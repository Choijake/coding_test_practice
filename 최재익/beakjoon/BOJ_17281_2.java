import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_2 {
    static int base;
    static boolean[] visited;
    static int answer;
    static int N;
    static int[][] arr;
    static int[][] result;
    static int[] sequence;
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
        base = 0b00000001;

        while(true){
            if(inn>N)break;

            int cur = arr[inn][sequence[(seq++)%9+1]];

            if(cur==0){
                outCount++;

                if(outCount==3){
                    base = 0b00000001;
                    inn++;
                    outCount = 0;
                }
            }
            else {
                update(cur);
            }
        }

        return score;
    }

    static void update(int n){
        base = (base << n) + 1;
        score += Integer.bitCount(base & 0b11110000);
        base = base & 0b00001111;
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
