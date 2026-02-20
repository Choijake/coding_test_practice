import java.util.*;

class PG_양궁대회 {
    static int maxDiff;
    static int[] answer;
    static int N;
    static int[] apeach;

    public int[] solution(int n, int[] info) {
        N = n;
        apeach = info;
        maxDiff = 0;
        answer = new int[]{-1};

        combination(0, new int[11], 0);

        return answer;
    }

    static void combination(int idx, int[] arr, int count) {
        if (idx == 11) {
            if (count < N) {
                arr[10] += N - count;
            }
            compare(arr);
            if (count < N) {
                arr[10] -= N - count;
            }
            return;
        }

        if (count + 1 + apeach[idx] <= N) {
            arr[idx] = apeach[idx] + 1;
            combination(idx + 1, arr, count + arr[idx]);
            arr[idx] = 0;
        }

        arr[idx] = 0;
        combination(idx + 1, arr, count);
    }

    static void compare(int[] lion) {
        int lionScore = 0;
        int apeachScore = 0;

        for (int i = 0; i <= 10; i++) {
            int score = 10 - i;

            if (lion[i] > apeach[i]) {
                lionScore += score;
            } else if (apeach[i] > 0) {
                apeachScore += score;
            }
        }

        int diff = lionScore - apeachScore;

        if (diff > 0) {
            if (diff > maxDiff) {
                maxDiff = diff;
                answer = lion.clone();
            } else if (diff == maxDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (lion[i] > answer[i]) {
                        answer = lion.clone();
                        break;
                    } else if (lion[i] < answer[i]) {
                        break;
                    }
                }
            }
        }
    }
}