import java.io.*;
import java.util.*;

public class BOJ_19236 {
    static int answer;
    static Fish[][] map;
    static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 0, -1, -1, -1, 0, 1, 1, 1};

    static class Shark extends Fish{
        int row;
        int col;
        int dir;
        int eat;

        Shark(){};

        public Shark(int row, int col, int dir, int eat){
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.eat = eat;
        }
    }
    static class Fish{
        int row;
        int col;
        int number;
        int dir;

        Fish(){}

        public Fish(int row, int col, int number, int dir){
            this.row = row;
            this.col = col;
            this.number = number;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new Fish[4][4];
        Map<Integer, int[]> loc = new HashMap<>();
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<4; j++){
                int number = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                map[i][j] = new Fish(i, j, number, dir);
                loc.put(number, new int[]{i, j});
            }
        }

        answer = 0;
        simulate(loc, map, 0, 0, 0);

        System.out.print(answer);
    }

    static void simulate(Map<Integer, int[]> loc, Fish[][] map, int nr, int nc, int eat){
        int nd = map[nr][nc].dir;
        int ne = eat + map[nr][nc].number;
        loc.remove(map[nr][nc].number);
        map[nr][nc] = null;

        //물고기 이동
        for(int i=1; i<=16; i++){
            if(!loc.containsKey(i))continue;

            int[] l = loc.get(i);
            Fish cur = map[l[0]][l[1]];
            int d = cur.dir;

            for(int k=0; k<8; k++){
                int nextRow = l[0] + dr[d];
                int nextCol = l[1] + dc[d];

                if (nextRow < 0 || nextCol < 0 || nextRow >= 4 || nextCol >= 4 || (nextRow == nr && nextCol == nc)) {
                    d = (d % 8) + 1;
                    continue;
                }

                map[l[0]][l[1]].dir = d;

                if (map[nextRow][nextCol] != null) {
                    Fish tmp = map[nextRow][nextCol];

                    map[nextRow][nextCol] = cur;
                    map[l[0]][l[1]] = tmp;

                    loc.put(cur.number, new int[]{nextRow, nextCol});
                    loc.put(tmp.number, new int[]{l[0], l[1]});
                } else {
                    map[nextRow][nextCol] = cur;
                    map[l[0]][l[1]] = null;

                    loc.put(cur.number, new int[]{nextRow, nextCol});
                }
                break;
            }
        }

        //상어 이동
        answer = Math.max(answer, ne);

        int sharkRow = nr;
        int sharkCol = nc;
        int sharkDir = nd;
        while(true){
            sharkRow += dr[sharkDir];
            sharkCol += dc[sharkDir];

            if (sharkRow < 0 || sharkCol < 0 || sharkRow >= 4 || sharkCol >= 4) break;
            if (map[sharkRow][sharkCol] == null) continue;

            Fish[][] copyMap = new Fish[4][4];
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(map[i][j] != null) {
                        copyMap[i][j] = new Fish(map[i][j].row, map[i][j].col, map[i][j].number, map[i][j].dir);
                    }
                }
            }

            HashMap<Integer, int[]> copyLoc = new HashMap<>();
            for(Integer key : loc.keySet()) {
                int[] originalPos = loc.get(key);
                copyLoc.put(key, new int[]{originalPos[0], originalPos[1]});
            }

            simulate(copyLoc, copyMap, sharkRow, sharkCol, ne);
        }
    }
}
