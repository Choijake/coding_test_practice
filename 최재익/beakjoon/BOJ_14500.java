import java.io.*;
import java.util.*;

public class BOJ_14500 {
    static int[][] map;
    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st2.nextToken());
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                visited[i][j] = true;
                solve(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    static void solve(int row, int col, int depth, int sum){
        if(depth==4){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr<0 || nc<0 || nr>=R || nc>=C)continue;
            if(visited[nr][nc])continue;

            if(depth == 2){
                visited[nr][nc] = true;
                solve(row, col, depth+1, sum+map[nr][nc]);
                visited[nr][nc] = false;
            }

            visited[nr][nc] = true;
            solve(nr, nc, depth+1, sum+map[nr][nc]);
            visited[nr][nc] = false;
        }
    }
}
