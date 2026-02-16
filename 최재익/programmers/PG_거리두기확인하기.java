import java.util.*;

class PG_거리두기확인하기 {

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;
    static int[] answer;

    public int[] solution(String[][] places) {
        answer = new int[places.length];
        for(int i=0; i<places.length; i++){
            answer[i] = 1;
        }

        for(int i=0; i<places.length; i++){
            map = new char[5][5];

            //map 초기화
            for(int r=0; r<5; r++){
                String in = places[i][r];
                for(int c=0; c<5; c++){
                    map[r][c] = in.charAt(c);
                }
            }

            total :
            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(map[r][c]=='P'){
                        if(bfs(r, c)){
                            answer[i] = 0;
                            break total;
                        }
                    }
                }
            }
        }

        return answer;
    }

    static boolean bfs(int r, int c){
        //O는 갈수있음
        //X는 갈수없음
        //탐색 거리가 3이면 끝내야함
        //만약 하나라도 거리두기가 지켜지지 않으면 answer[seq] 기록 후 리턴

        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {r, c, 0});
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[2]==2)continue;

            for(int i=0; i<4; i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];

                if(nr<0 || nc<0 || nr>=5 || nc>=5)continue;
                if(visited[nr][nc])continue;
                if(map[nr][nc]=='X')continue;

                if(map[nr][nc]=='P'){
                    return true;
                }

                if(map[nr][nc]=='O'){
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, cur[2]+1});
                }
            }
        }

        return false;
    }
}