import java.util.*;

class PG_무인도여행 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    public List<Integer> solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j)=='X'){
                    map[i][j] = 0;
                }
                else map[i][j] = maps[i].charAt(j)-'0';
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){

                if(map[i][j]>0 && !visited[i][j]){
                    int result = bfs(i, j);
                    if(result!=0)answer.add(result);
                }
            }
        }

        Collections.sort(answer);

        if(answer.isEmpty())answer.add(-1);

        return answer;
    }

    static int bfs(int row, int col){
        int sum = map[row][col];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length)continue;
                if(map[nr][nc]==0)continue;
                if(visited[nr][nc])continue;

                sum+=map[nr][nc];
                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return sum;
    }
}