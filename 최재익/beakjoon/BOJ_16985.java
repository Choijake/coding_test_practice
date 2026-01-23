import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class BOJ_16985 {
    static int[] dir, order;
    static boolean[] visited;
    static int[][][] map;
    static int[][][] copy;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5][5];
        for(int f=0; f<5; f++){
            for(int r=0; r<5; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<5; c++){
                    map[f][r][c] = Integer.parseInt(st.nextToken());
                }
            }
        }

        dir = new int[5];
        order = new int[5];
        visited = new boolean[5];
        answer = Integer.MAX_VALUE;

        permutation(0);

        answer = (answer==Integer.MAX_VALUE)?-1:answer;

        System.out.print(answer);
    }

    static void permutation(int depth){
        if(depth==5){
            copy = new int[5][5][5];
            rotate(0);
            return;
        }

        for(int i=0; i<5; i++){
            if(!visited[i]){
                order[depth] = i;
                visited[i] = true;
                permutation(depth+1);
                visited[i] = false;
            }
        }
    }

    static void rotate(int depth){
        if(depth==5){
            for(int i=0; i<5; i++){
                int o = order[i];
                int d = dir[o];

                for(int r=0; r<5; r++){
                    for(int c=0; c<5; c++){
                        if(d==0){
                            copy[i][r][c] = map[o][r][c];
                        }
                        else if(d==1){
                            copy[i][c][5-1-r] = map[o][r][c];
                        }
                        else if(d==2){
                            copy[i][5-1-r][5-1-c] = map[o][r][c];
                        }
                        else{
                            copy[i][5-1-c][r] = map[o][r][c];
                        }
                    }
                }
            }

            bfs();
            return;
        }

        for(int i=0; i<4; i++){
            dir[depth] = i;
            rotate(depth+1);
        }
    }

    static void bfs(){
        if(copy[0][0][0] == 0 || copy[4][4][4] == 0) return;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[5][5][5];

        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[1];
            int c = cur[2];
            int f = cur[0];
            int dist = cur[3];

            if(r==4 && c==4 && f==4){
                answer = Math.min(answer, dist);
                if(answer==12){
                    System.out.print(12);
                    exit(0);
                }
                return;
            }

            //같은 층 탐색
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr<0 || nc<0 || nr>=5 || nc>=5)continue;
                if(visited[f][nr][nc])continue;
                if(copy[f][nr][nc]==0)continue;

                queue.add(new int[]{f, nr, nc, dist+1});
                visited[f][nr][nc] = true;
            }

            //아래 층 탐색
            if(f-1>=0 && f-1<5){
                if(!visited[f-1][r][c] && copy[f-1][r][c]==1){
                    queue.add(new int[]{f-1, r, c, dist+1});
                    visited[f-1][r][c] = true;
                }
            }

            //윗 층 탐색
            if(f+1>=0 && f+1<5){
                if(!visited[f+1][r][c] && copy[f+1][r][c]==1){
                    queue.add(new int[]{f+1, r, c, dist+1});
                    visited[f+1][r][c] = true;
                }
            }
        }
    }
}
