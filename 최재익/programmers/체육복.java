import java.util.*;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        boolean[] isReserve = new boolean[n+1];
        for (int r : reserve) {
            isReserve[r] = true;
        }

        // 1. 교집합 먼저 제거 (자기 체육복만 입는 경우)
        List<Integer> newLost = new ArrayList<>();
        for (int l : lost) {
            if (isReserve[l]) {
                // 자기 체육복 사용 → lost에서 제외
                isReserve[l] = false;
                answer++; // 복구된 학생으로 카운트
            } else {
                newLost.add(l);
            }
        }

        // 2. 빌려주기 로직
        for (int l : newLost) {
            if (l > 1 && isReserve[l - 1]) {
                answer++;
                isReserve[l - 1] = false;
            } else if (l < n && isReserve[l + 1]) {
                answer++;
                isReserve[l + 1] = false;
            }
        }

        // 3. 최종 결과
        return answer + (n - lost.length);
    }
}
//잃어버렸는데 여벌이 있는 학생은 제외해야함 -> 다른 학생에게 빌려주게될 수 있음