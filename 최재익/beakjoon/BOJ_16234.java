import java.io.*;
import java.util.*;

public class BOJ_16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true){
            visited = new boolean[N][N];

            boolean flag = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        if(bfs(i, j)){
                            flag = true;
                        }
                    }
                }
            }

            if(!flag)break;

            answer++;
        }

        System.out.println(answer);
    }

    static boolean bfs(int row, int col){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        List<int[]> list = new ArrayList<>();
        list.add(new int[] {row, col});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr<0 || nc<0 || nr>=N || nc>=N)continue;
                if(visited[nr][nc])continue;

                if(Math.abs(map[nr][nc]-map[r][c])>=L && Math.abs(map[nr][nc]-map[r][c])<=R){
                    list.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                }
            }
        }

        if(list.size()>1){
            int total = 0;
            for(int i=0; i<list.size(); i++){
                int r = list.get(i)[0];
                int c = list.get(i)[1];
                total += map[r][c];
            }

            int avg = total/list.size();

            for(int i=0; i<list.size(); i++){
                int r = list.get(i)[0];
                int c = list.get(i)[1];
                map[r][c] = avg;
            }

            return true;
        }

        return false;
    }
}
