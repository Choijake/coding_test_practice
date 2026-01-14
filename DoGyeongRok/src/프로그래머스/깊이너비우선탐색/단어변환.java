package 프로그래머스.깊이너비우선탐색;

// 2025-06-28
// https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;

public class 단어변환 {
    class Solution {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            List<String> list = new ArrayList<>(Arrays.asList(words));
            if(!list.contains(target)) {
                return answer;
            }
            Queue<String> queue = new LinkedList<>();
            Set<String> set = new HashSet<>();
            queue.offer(begin);
            set.add(begin);
            while(!queue.isEmpty()) {
                for(int i = 0; i < queue.size(); i++) {
                    String cur = queue.poll();
                    if(cur.equals(target)) {
                        return answer;
                    }
                    for(String word: list) {
                        int cnt = 0;
                        for(int j = 0; j < word.length(); j++) {
                            if(cur.charAt(j) == word.charAt(j)) {
                                cnt++;
                            }
                        }
                        if(cnt == word.length() - 1 && !set.contains(word)) {
                            queue.offer(word);
                            set.add(word);
                        }
                    }
                }
                answer++;
            }
            return answer;
        }
    }
}
