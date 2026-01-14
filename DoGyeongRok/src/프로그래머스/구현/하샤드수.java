package 프로그래머스.구현;

// 2025-06-18
// https://school.programmers.co.kr/learn/courses/30/lessons/12947

public class 하샤드수 {
    class Solution {
        public boolean solution(int x) {
            String str = "" + x;
            int sum = 0;
            for(int i = 0; i < str.length(); i++) {
                sum += Integer.parseInt(str.substring(i, i + 1));
            }
            return x % sum == 0;
        }
    }
}
