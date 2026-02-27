import java.util.*;

class PG_경주로만들기 {
    static int answer;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static class Node {
        int r, c, dir, straight, corner;

        Node(int r, int c, int dir, int straight, int corner) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.straight = straight;
            this.corner = corner;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        answer = Integer.MAX_VALUE;

        int[][][] cost = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        bfs(board, cost);

        return answer;
    }

    static void bfs(int[][] board, int[][][] cost) {
        int n = board.length;
        int m = board[0].length;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(cur.r==board.length-1 && cur.c==board[0].length-1){
                int total = cur.straight*100 + cur.corner*500;
                answer = Math.min(answer, total);
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (board[nr][nc] == 1) continue;

                int nextStraight = cur.straight+1;
                int nextCorner = cur.corner;

                if(cur.dir!=-1 && cur.dir!=i){
                    nextCorner++;
                }

                int nextCost = nextStraight*100 + nextCorner*500;

                if(nextCost<=cost[nr][nc][i]){
                    cost[nr][nc][i] = nextCost;
                    queue.add(new Node(nr, nc, i, nextStraight, nextCorner));
                }
            }
        }
    }
}