import java.util.*;
import java.io.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static List<Robot> robots;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        //map 초기화
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //robot 초기화
        robots = new ArrayList<>();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;

            robots.add(new Robot(row, col, -1));
        }

        StringBuilder sb = new StringBuilder();

        //테스트 L회
        for(int i=0; i<L; i++){
            //printRobotPos("청소기 이동전");

            //청소기 이동
            move();
            //printMap("move");

            //printRobotPos("청소기 이동 후");

            //청소
            clean();
            //printMap("clean");

            //먼지 축적
            cover();
            //printMap("cover");

            //먼지 확산
            spread();
            //printMap("spread");

            int total = getTotal();
            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }

    static int getTotal(){
        int total = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] > 0)total+=map[i][j];
            }
        }

        return total;
    }

    static void spread(){
        int[][] newMap = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == -1) newMap[i][j] = -1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0){
                    int dust = 0;

                    for(int d=0; d<4; d++){
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                        if(map[nr][nc] < 1) continue;

                        dust += map[nr][nc];
                    }

                    newMap[i][j] += dust / 10;
                } else if(map[i][j] > 0){
                    newMap[i][j] = map[i][j];
                }
            }
        }

        map = newMap;
    }

    static void cover(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]>0)map[i][j]+=5;
            }
        }
    }

    static void clean(){
        for(int i=0; i<K; i++){
            Robot robot = robots.get(i);
            int row = robot.row;
            int col = robot.col;

            int dir = getCleanDir(row, col);

            //System.out.println("robot : "+row+", "+col+", "+dir);

            // 현재 위치 청소
            map[row][col] = Math.max(0, map[row][col] - 20);

            // 왼쪽
            int leftDir = (dir + 3) % 4;
            int leftRow = row + dr[leftDir];
            int leftCol = col + dc[leftDir];

            if(leftRow >= 0 && leftCol >= 0 && leftRow < N && leftCol < N && map[leftRow][leftCol] != -1){
                map[leftRow][leftCol] = Math.max(0, map[leftRow][leftCol] - 20);
            }

            // 오른쪽
            int rightDir = (dir + 1) % 4;
            int rightRow = row + dr[rightDir];
            int rightCol = col + dc[rightDir];

            if(rightRow >= 0 && rightCol >= 0 && rightRow < N && rightCol < N && map[rightRow][rightCol] != -1){
                map[rightRow][rightCol] = Math.max(0, map[rightRow][rightCol] - 20);
            }

            // 앞쪽
            int frontRow = row + dr[dir];
            int frontCol = col + dc[dir];

            if(frontRow >= 0 && frontCol >= 0 && frontRow < N && frontCol < N && map[frontRow][frontCol] != -1){
                map[frontRow][frontCol] = Math.max(0, map[frontRow][frontCol] - 20);
            }
        }
    }

    static int getCleanDir(int row, int col){
        int bestDust = -1;
        int bestDir = 0;

        for(int i=0; i<4; i++){
            int sum = 0;

            // 현재 위치
            if(map[row][col] > 0){
                sum += Math.min(20, map[row][col]);
            }

            // 왼쪽
            int leftRow = row + dr[(i + 3) % 4];
            int leftCol = col + dc[(i + 3) % 4];
            if(leftRow >= 0 && leftCol >= 0 && leftRow < N && leftCol < N && map[leftRow][leftCol] > 0){
                sum += Math.min(20, map[leftRow][leftCol]);
            }

            // 앞쪽
            int frontRow = row + dr[i];
            int frontCol = col + dc[i];
            if(frontRow >= 0 && frontCol >= 0 && frontRow < N && frontCol < N && map[frontRow][frontCol] > 0){
                sum += Math.min(20, map[frontRow][frontCol]);
            }

            // 오른쪽
            int rightRow = row + dr[(i + 1) % 4];
            int rightCol = col + dc[(i + 1) % 4];
            if(rightRow >= 0 && rightCol >= 0 && rightRow < N && rightCol < N && map[rightRow][rightCol] > 0){
                sum += Math.min(20, map[rightRow][rightCol]);
            }

            // 우선순위: 오른쪽, 아래쪽, 왼쪽, 위쪽
            // dr/dc가 이미 우,하,좌,상이므로 동점이면 먼저 나온 방향 유지
            if(sum > bestDust){
                bestDust = sum;
                bestDir = i;
            }
        }

        return bestDir;
    }

    static void move(){
        for(int i=0; i<K; i++){
            Robot robot = robots.get(i);
            int row = robot.row;
            int col = robot.col;
            int dir = robot.dir;

            int[] nextPos = getNextPos(row, col, dir);

            robot.row = nextPos[0];
            robot.col = nextPos[1];
            robot.dir = nextPos[2];
        }
    }

    static int[] getNextPos(int r, int c, int d){
        int[] nextPos = new int[]{r, c, d, Integer.MAX_VALUE};

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{r, c, d, 0});
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curDir = cur[2];
            int curDist = cur[3];

            if(map[curRow][curCol] > 0 && curDist <= nextPos[3]){
                if(curDist == nextPos[3]){
                    if(curRow < nextPos[0] || (curRow == nextPos[0] && curCol < nextPos[1])){
                        nextPos[0] = curRow;
                        nextPos[1] = curCol;
                        nextPos[2] = curDir;
                        nextPos[3] = curDist;
                    }
                } else {
                    nextPos[0] = curRow;
                    nextPos[1] = curCol;
                    nextPos[2] = curDir;
                    nextPos[3] = curDist;
                }
                continue;
            }

            for(int i=0; i<4; i++){
                int nr = curRow + dr[i];
                int nc = curCol + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == -1) continue;

                boolean occupied = false;
                for(int idx=0; idx<robots.size(); idx++){
                    Robot robot = robots.get(idx);
                    if(robot.row == nr && robot.col == nc){
                        occupied = true;
                        break;
                    }
                }

                if(occupied) continue;

                queue.add(new int[]{nr, nc, i, curDist + 1});
                visited[nr][nc] = true;
            }
        }

        return nextPos;
    }

    static void printMap(String step){
        /*
        System.out.println("==== " + step + " ====");
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        */
    }

    static void printRobotPos(String status){
        /*
        System.out.println(status);

        for(int i=0; i<robots.size(); i++){
            System.out.println(robots.get(i).row+", "+robots.get(i).col+", "+map[robots.get(i).row][robots.get(i).col]);
        }
        System.out.println();
        */
    }
}