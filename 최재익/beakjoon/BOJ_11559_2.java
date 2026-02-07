import java.io.*;
import java.util.*;

public class BOJ_11559_2 {
    static char[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for(int i=0; i<12; i++){
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        while(true){
            visited = new boolean[12][6];

            List<int[]> boomList = new ArrayList<>();

            //연쇄 찾기
            for(int r=0; r<12; r++){
                for(int c=0; c<6; c++){
                    if(map[r][c]!='.' && !visited[r][c]){
                        List<int[]> boom = bfs(r, c);

                        if(boom.size()>=4){
                            boomList.addAll(boom);
                        }
                    }
                }
            }

            if(!boomList.isEmpty())answer++;
            else break;

            for(int i=0; i<boomList.size(); i++){
                int[] cur = boomList.get(i);
                map[cur[0]][cur[1]] = '.';
            }

            //내리기
            for(int col=0; col<6; col++){
                int write = 11;

                for(int row=11; row>=0; row--){
                    if(map[row][col] != '.'){
                        map[write][col] = map[row][col];
                        if(write!=row)map[row][col] = '.';
                        write--;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static List<int[]> bfs(int row, int col){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        List<int[]> boomList = new ArrayList<>();
        boomList.add(new int[]{row, col});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr<0 || nc<0 || nr>=12 || nc>=6)continue;
                if(visited[nr][nc])continue;
                if(map[cur[0]][cur[1]]!=map[nr][nc])continue;

                queue.add(new int[] {nr, nc});
                visited[nr][nc] = true;
                boomList.add(new int[]{nr, nc});
            }
        }

        return boomList;
    }
}
