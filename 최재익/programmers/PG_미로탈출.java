import java.util.*;

class PG_미로탈출 {
    static char[][] newMap;
    static int N;
    static int M;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        newMap = new char[N][M];
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];

        for(int i=0; i<N; i++){
            newMap[i] = maps[i].toCharArray();

            for(int j=0; j<M; j++){
                if(newMap[i][j]=='S'){
                    start[0] = i;
                    start[1] = j;
                }
                else if(newMap[i][j]=='E'){
                    end[0] = i;
                    end[1] = j;
                }
                else if(newMap[i][j]=='L'){
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        int findLever = bfs(start[0], start[1], 'L');
        //System.out.println("findLever : "+findLever);
        if(findLever==-1)return -1;
        int findEnd = bfs(lever[0], lever[1], 'E');
        //System.out.println("findEnd : "+findEnd);
        if(findEnd==-1)return -1;

        return findLever+findEnd;
    }

    static int bfs(int row, int col, char target){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{row, col, 0});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curTime = cur[2];

            if(newMap[curRow][curCol] == target){
                return curTime;
            }

            for(int i=0; i<4; i++){
                int nr = curRow + dr[i];
                int nc = curCol + dc[i];

                if(nr<0 || nc<0 || nr>=N || nc>=M)continue;
                if(visited[nr][nc])continue;
                if(newMap[nr][nc]=='X')continue;

                queue.add(new int[]{nr, nc, curTime+1});
                visited[nr][nc] = true;
            }
        }

        return -1;
    }
}