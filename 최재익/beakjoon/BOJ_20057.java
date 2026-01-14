import java.io.*;
import java.util.*;

public class BOJ_20057 {
    static int answer;
    static int[] percent = {1, 1, 7, 7, 2, 2, 10, 10, 5};

    static int[][] spreadR = {
            {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0},
            {1, 1, 0, 0, 0, 0, -1, -1, -2, -1}
    };
    static int[][] spreadC = {
            {1, 1, 0, 0, 0, 0, -1, -1, -2, -1},
            {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}
    };
    static int N;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st ;
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        int dirChange = 0;
        int dir = 0;
        int moveLength = 1;
        int move = 0;
        int r=map.length/2, c=map.length/2;
        while(true){
            if(r==1 && c==1)break;

            if(move==moveLength){
                dir = (dir+1)%4;
                dirChange++;
                move = 0;
            }

            if(dirChange==2){
                moveLength++;
                dirChange = 0;
            }

            r = r+dr[dir];
            c = c+dc[dir];
            move++;

            spread(r, c, dir);
        }

        System.out.println(answer);
    }

    static void spread(int nr, int nc, int dir){
        int sand = map[nr][nc];
        for(int i=0; i<=8; i++){
            int nnr = nr + spreadR[dir][i];
            int nnc = nc + spreadC[dir][i];
            int plus = sand*percent[i]/100;

            if(nnr<1 || nnc<1 || nnr>N || nnc>N){
                answer += plus;
            }
            else map[nnr][nnc] += plus;

            map[nr][nc] -= plus;
        }

        int ar = nr + spreadR[dir][9];
        int ac = nc + spreadC[dir][9];

        if(ar<1 || ac<1 || ar>N || ac>N){
            answer += map[nr][nc];
        }
        else map[ar][ac] += map[nr][nc];

        map[nr][nc] = 0;
    }
}
