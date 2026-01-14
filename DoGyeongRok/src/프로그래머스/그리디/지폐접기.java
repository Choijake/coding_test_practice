package 프로그래머스.그리디;

// 2025-06-23
// https://school.programmers.co.kr/learn/courses/30/lessons/340199

public class 지폐접기 {
    class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;

            while((Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1])) || (Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1]))) {
                if(bill[0] > bill[1]) {
                    bill[0] /= 2;
                }else {
                    bill[1] /= 2;
                }
                answer++;
            }

            return answer;
        }
    }
}
