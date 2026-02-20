import java.util.*;

class PG_비밀코드해독 {
    static int answer;

    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        combination(0, 1, n, new int[5], q, ans);

        return answer;
    }

    static void combination(int depth, int idx, int n, int[] result, int[][] q, int[] ans) {
        if (depth == 5) {
            if (check(result, q, ans)) answer++;
            return;
        }

        for (int i = idx; i <= n; i++) {
            result[depth] = i;
            combination(depth + 1, i + 1, n, result, q, ans);
        }
    }

    static boolean check(int[] result, int[][] q, int[] ans) {

        for (int idx = 0; idx < q.length; idx++) {
            int[] t = q[idx];
            int count = 0;

            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    if (result[j] == t[i]) {
                        count++;
                        break;
                    }
                }
            }

            if (ans[idx] != count) return false;
        }

        return true;
    }
}