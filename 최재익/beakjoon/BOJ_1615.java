import java.io.*;
import java.util.*;

public class BOJ_1615 {
    static int[] dr = {1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1};
    static boolean[][][] visited;
    static int[][] map;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[19][19];
        StringTokenizer st;

        for(int i=0; i<19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[3];
        visited = new boolean[19][19][4];
        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                for(int d=0; d<4; d++){
                    if(!visited[i][j][d] && map[i][j]!=0){
                        dfs(i, j, i, j, d, 1);
                        if(answer[0]!=0){
                            System.out.println(answer[0]);
                            System.out.print(answer[1] + " " + answer[2]);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    static void dfs(int startRow, int startCol, int row, int col, int dir, int seq){
        int nr = row + dr[dir];
        int nc = col + dc[dir];

        if(seq==5){
            visited[row][col][dir] = true;
            if((nr>=0 && nc>=0 && nr<19 && nc<19) && map[nr][nc]==map[row][col]){
                while((nr>=0 && nc>=0 && nr<19 && nc<19) && map[nr][nc]==map[row][col]){
                    visited[nr][nc][dir] = true;
                    nr += dr[dir];
                    nc += dc[dir];
                }
                return;
            }

            answer[0] = map[row][col];

            if(dir==0){
                answer[1] = row+1;
                answer[2] = col+1;
            }
            else{
                answer[1] = startRow+1;
                answer[2] = startCol+1;
            }
            return;
        }

        visited[row][col][dir] = true;

        if(nr<0 || nc<0 || nr>=19 || nc>=19)return;
        if(visited[nr][nc][dir])return;
        if(map[nr][nc]!=map[row][col])return;

        dfs(startRow, startCol, nr, nc, dir, seq+1);
    }
}
