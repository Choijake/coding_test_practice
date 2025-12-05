import java.io.*;
import java.util.*;

public class BOJ_14503 {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1 ,0, 1};

    static class Robot{
        int row;
        int col;
        int dir;

        public Robot(int row, int col, int dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Robot robot = new Robot(arr[0], arr[1], (4 - arr[2]) % 4);

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean stop = false;

        while(!stop){
            int row = robot.row;
            int col = robot.col;

            if(map[row][col]==0){
                map[row][col] = -1;
                answer++;
            }

            boolean zero = false;
            for(int i=0; i<4; i++){
                robot.dir = (robot.dir+1)%4;

                int nr = row+dr[robot.dir];
                int nc = col+dc[robot.dir];

                if(nr<0 || nc<0 || nr>=N || nc>=M)continue;

                if(map[nr][nc] == 0){
                    zero = true;
                    robot.row = nr;
                    robot.col = nc;
                    break;
                }
            }

            if(!zero){
                int back = (robot.dir+2)%4;

                int nr = row+dr[back];
                int nc = col+dc[back];

                if(nr>=0 && nc>=0 && nr<N && nc<M){
                    if(map[nr][nc]==1){
                        stop = true;
                    }else{
                        robot.row = nr;
                        robot.col = nc;
                    }
                }
            }
        }

        System.out.print(answer);
    }
}
