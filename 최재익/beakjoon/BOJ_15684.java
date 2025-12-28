import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684 {
    static int N, M, H;
    static int answer;
    static boolean[][] line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        line = new boolean[H+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            line[a][b] = true;
        }

        answer = 4;
        dfs(0, 0, H*(N-1));
        answer = (answer==4)?-1:answer;

        System.out.print(answer);
    }

    static void dfs(int depth, int start, int total){
        if(depth>=answer)return;

        if(check()){
            answer = depth;
            return;
        }

        if(depth==3)return;

        for(int i=start; i<total; i++){
            int row = i/(N-1)+1;
            int col = i%(N-1)+1;

            if(!canReplace(row, col))continue;

            line[row][col] = true;
            dfs(depth+1, start+1, total);
            line[row][col] = false;
        }
    }

    static boolean canReplace(int row, int col){
        if(line[row][col])return false;
        else if(1<col && line[row][col-1])return false;
        else if(N-1>col && line[row][col+1])return false;
        else return true;
    }

    static boolean check(){
        for(int col=1; col<=N; col++){
            int pos = col;
            for(int row=1; row<=H; row++){
                if(line[row][pos])pos++;
                else if(pos>1 && line[row][pos-1])pos--;
            }

            if(pos!=col)return false;
        }

        return true;
    }
}
