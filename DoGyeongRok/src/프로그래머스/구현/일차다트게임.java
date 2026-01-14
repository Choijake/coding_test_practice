package 프로그래머스.구현;

// 2025-06-18
// https://school.programmers.co.kr/learn/courses/30/lessons/17682
// 구현 + 문자열

public class 일차다트게임 {
    class Solution {
        public int solution(String dartResult) {
            int[] score = new int[3];
            int idx = 0;
            String str = "";
            for(int i = 0; i < dartResult.length(); i++) {
                char target = dartResult.charAt(i);
                if(target >= '0' && target <= '9') {
                    str += String.valueOf(target);
                }else if(Character.isLetter(target)) {
                    int num = Integer.parseInt(str);
                    switch(target) {
                        case 'S':
                            score[idx++] = (int) Math.pow(num, 1);
                            break;
                        case 'D':
                            score[idx++] = (int) Math.pow(num, 2);
                            break;
                        case 'T':
                            score[idx++] = (int) Math.pow(num, 3);
                            break;
                    }
                    str = "";
                }else if(target == '*') {
                    int now = idx - 1;
                    score[now] *= 2;
                    if(now - 1 >= 0) {
                        score[now - 1] *= 2;
                    }
                }else if(target == '#') {
                    int now = idx - 1;
                    score[now] *= -1;
                }
            }
            int answer = 0;
            for(int val: score) {
                answer += val;
            }
            return answer;
        }
    }
}
