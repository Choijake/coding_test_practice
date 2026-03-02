import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Shark {
    int r, c, size, eat;

    public Shark(int r, int c, int size, int eat) {
        this.r = r;
        this.c = c;
        this.size = size;
        this.eat = eat;
    }
}

public class BOJ_16236_2 {

    static int N;
    static int[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        Shark shark = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    board[i][j] = 0;
                }
            }
        }

        int totalTime = 0;

        while(true){
            int[] result = bfs(shark);

            if(result[0]==-1)break;

            shark.r = result[0];
            shark.c = result[1];
            shark.eat++;
            totalTime += result[2];

            board[result[0]][result[1]] = 0;

            if(shark.size == shark.eat){
                shark.eat = 0;
                shark.size++;
            }
        }

        System.out.println(totalTime);
    }

    static int[] bfs(Shark shark){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new int[]{shark.r, shark.c, 0});
        visited[shark.r][shark.c] = true;

        int minDist = Integer.MAX_VALUE;
        int targetRow = -1;
        int targetCol = -1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int curR = cur[0];
            int curC = cur[1];
            int curDist = cur[2];

            if(minDist<curDist)break;

            for(int i=0; i<4; i++){
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;

                if(board[nr][nc] > shark.size)continue;

                visited[nr][nc] = true;
                if(board[nr][nc]==0 ||  board[nr][nc] == shark.size){
                    queue.add(new int[]{nr, nc, curDist+1});
                }
                else if (board[nr][nc] < shark.size) {
                    if(curDist+1 < minDist){
                        minDist = curDist+1;
                        targetRow = nr;
                        targetCol = nc;
                    }
                    else if(curDist+1==minDist){
                        if (nr < targetRow || (nr == targetRow && nc < targetCol)) {
                            targetRow = nr;
                            targetCol = nc;
                        }
                    }

                    queue.add(new int[]{nr, nc, curDist+1});
                }
            }
        }

        if (targetRow == -1) return new int[]{-1, -1, -1};
        return new int[]{targetRow, targetCol, minDist};
    }
}