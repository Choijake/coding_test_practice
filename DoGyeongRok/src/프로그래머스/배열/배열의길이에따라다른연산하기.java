package 프로그래머스.배열;

// 2025-06-14
// https://school.programmers.co.kr/learn/courses/30/lessons/181854

public class 배열의길이에따라다른연산하기 {
    class Solution {
        public int[] solution(int[] arr, int n) {
            int[] answer = arr;
            int length = arr.length;
            if(length % 2 == 0) {
                for(int i = 0; i < answer.length; i++) {
                    if(i % 2 != 0) {
                        arr[i] += n;
                    }
                }
            }else {
                for(int i = 0; i < answer.length; i++) {
                    if(i % 2 == 0) {
                        arr[i] += n;
                    }
                }
            }
            return answer;
        }
    }
}
