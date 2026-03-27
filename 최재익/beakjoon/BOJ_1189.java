import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1189 {

    static class Node{
        int row;
        int col;
        int length;
        Node prev;

        public Node(int row, int col, int length, Node prev){
            this.row = row;
            this.col = col;
            this.length = length;
            this.prev = prev;
        }
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;

    static int R,C,K;

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[R][C];
        visited[R-1][0] = true;
        answer = 0;

        dfs(new Node(R-1, 0, 1, null), visited);

        System.out.println(answer);
    }

    static void dfs(Node cur, boolean[][] visited){
        if(cur.row==0 && cur.col==C-1){

            if(cur.length==K){

//                System.out.println("["+cur.row+", "+cur.col+" = "+cur.length+"]");
//                Node prev = cur;
//                while(true){
//                    prev = prev.prev;
//                    if(prev==null)break;
//                    System.out.println(prev.row+", "+prev.col+" = "+prev.length);
//                }

                answer++;
            }
            return;
        }

        for(int d=0; d<4; d++){
            int nr = cur.row + dr[d];
            int nc = cur.col + dc[d];

            if(nr<0 || nc<0 || nr>=R || nc>=C)continue;
            if(visited[nr][nc])continue;
            if(map[nr][nc]=='T')continue;

            visited[nr][nc] = true;
            dfs(new Node(nr, nc, cur.length+1, cur), visited);
            visited[nr][nc] = false;
        }
    }
}
