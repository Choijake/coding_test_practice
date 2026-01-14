package 프로그래머스.구현;

// 2025-06-17
// https://school.programmers.co.kr/learn/courses/30/lessons/12943

public class 콜라츠추측 {
    class Solution {
        public int solution(int num) {
            long target = num;
            int count = 0;
            while(target != 1) {
                if(target % 2 == 0) {
                    target /= 2;
                } else {
                    target = target * 3 + 1;
                }
                count++;
                if(count >= 500) {
                    return -1;
                }
            }
            return count;
        }
    }
}
