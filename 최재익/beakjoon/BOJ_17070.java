import java.io.*;
import java.util.*;

public class BOJ_17070 {
    static int N;
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;

        dfs(1, 1, 2);

        System.out.print(answer);
    }

    static void dfs(int dir, int row, int col){
        if(row==N && col==N){
            answer++;
            return;
        }

        //오른쪽
        if(dir==1){
            //오른쪽
            if(col+1<=N && map[row][col+1]==0){
                dfs(1, row, col+1);
            }
            //오른쪽 아래
            if(row+1<=N && col+1<=N && canDiag(row, col)){
                dfs(3, row+1, col+1);
            }
        }
        //아래쪽
        else if(dir==2){
            //아래쪽
            if(row+1<=N && map[row+1][col]==0){
                dfs(2, row+1, col);
            }
            //오른쪽 아래
            if(row+1<=N && col+1<=N && canDiag(row, col)){
                dfs(3, row+1, col+1);
            }
        }
        //오른쪽 아래
        else if(dir==3){
            //오른쪽
            if(col+1<=N && map[row][col+1]==0){
                dfs(1, row, col+1);
            }
            //아래쪽
            if(row+1<=N && map[row+1][col]==0){
                dfs(2, row+1, col);
            }
            //오른쪽 아래
            if(row+1<=N && col+1<=N && canDiag(row, col)){
                dfs(3, row+1, col+1);
            }
        }
    }

    static boolean canDiag(int row, int col){
        return map[row][col+1] == 0
                && map[row+1][col] == 0
                && map[row+1][col+1] == 0;
    }
}
