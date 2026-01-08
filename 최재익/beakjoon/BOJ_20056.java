import java.io.*;
import java.util.*;

public class BOJ_20056 {
    static int N, M, K;
    static List<FireBall>[][] map;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static class FireBall{
        int r;
        int c;
        int m;
        int s;
        int d;

        FireBall(){}

        FireBall(int r, int c, int m ,int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new FireBall(r, c, m, s, d));
        }

        int move = 0;
        while(move++ < K){
            List<FireBall>[][] next = new ArrayList[N+1][N+1];
            for (int i=1;i<=N;i++) for (int j=1;j<=N;j++) next[i][j] = new ArrayList<>();

            //move
            for(int i=1; i<=N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!map[i][j].isEmpty()) {
                        for (int idx = 0; idx < map[i][j].size(); idx++) {
                            FireBall f = map[i][j].get(idx);
                            int s = f.s % N;

                            int nr = f.r + dr[f.d] * s;
                            int nc = f.c + dc[f.d] * s;

                            nr = ((nr - 1) % N + N) % N + 1;
                            nc = ((nc - 1) % N + N) % N + 1;

                            next[nr][nc].add(new FireBall(nr, nc, f.m, f.s, f.d));
                        }
                    }
                }
            }

            //check and separate
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(next[i][j].size()>=2){
                        int count = next[i][j].size();
                        int totalM = 0;
                        int totalS = 0;
                        boolean isOdd = true;
                        boolean isEven = true;

                        for(int idx=0; idx<next[i][j].size(); idx++){
                            FireBall f = next[i][j].get(idx);

                            totalM += f.m;
                            totalS += f.s;

                            if(f.d % 2 != 0)isEven = false;
                            if(f.d % 2 != 1)isOdd = false;
                        }

                        next[i][j] = new ArrayList<>();
                        int newM = totalM/5;
                        int newS = totalS/count;

                        if(newM==0){
                            continue;
                        }

                        if(isEven || isOdd){
                            for(int d=0; d<=6; d+=2){
                                next[i][j].add(new FireBall(i, j, newM, newS, d));
                            }
                        }
                        else{
                            for(int d=1; d<=7; d+=2){
                                next[i][j].add(new FireBall(i, j, newM, newS, d));
                            }
                        }
                    }
                }
            }

            map = next;
        }

        int answer = 0;
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= N; j++) {
                if(!map[i][j].isEmpty()){
                    for(int idx=0; idx<map[i][j].size(); idx++){
                        FireBall f = map[i][j].get(idx);
                        answer += f.m;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}