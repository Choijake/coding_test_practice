package 프로그래머스.구현;

// 2025-06-18
// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// 구현 + 스택

import java.util.*;

public class 크레인인형뽑기게임 {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            Stack<Integer> stack = new Stack<>();
            List<Stack<Integer>> list = new ArrayList<>();
            int answer = 0;
            for(int i = 0; i < board[0].length; i++) {
                list.add(new Stack<>());
            }
            for(int i = 0; i < board[0].length; i++) {
                for(int j = board.length - 1; j >= 0; j--) {
                    if(board[j][i] != 0) {
                        list.get(i).push(board[j][i]);
                    }
                }
            }
            for(int i = 0; i < moves.length; i++) {
                int idx = moves[i] - 1;
                if(!list.get(idx).isEmpty()) {
                    int val = list.get(idx).pop();
                    if(stack.isEmpty()) {
                        stack.push(val);
                    }else if(stack.peek() == val) {
                        stack.pop();
                        answer += 2;
                    }else {
                        stack.push(val);
                    }
                }
            }
            return answer;
        }
    }
}
