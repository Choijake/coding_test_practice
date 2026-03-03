import java.util.*;

class PG_파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        int[][] sums = new int[r + 1][c + 1];

        for (int[] s : skill) {
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int d = s[5];

            if (s[0] == 1) {
                sums[r1][c1] -= d;
                sums[r1][c2 + 1] += d;
                sums[r2 + 1][c1] += d;
                sums[r2 + 1][c2 + 1] -= d;
            } else {
                sums[r1][c1] += d;
                sums[r1][c2 + 1] -= d;
                sums[r2 + 1][c1] -= d;
                sums[r2 + 1][c2 + 1] += d;
            }
        }

        for (int i = 0; i < r + 1; i++) {
            for (int j = 0; j < c; j++) {
                sums[i][j + 1] += sums[i][j];
            }
        }

        for (int i = 0; i < c + 1; i++) {
            for (int j = 0; j < r; j++) {
                sums[j + 1][i] += sums[j][i];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] += sums[i][j];

                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}