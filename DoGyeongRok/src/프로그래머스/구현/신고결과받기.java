package 프로그래머스.구현;

// 2025-06-26
// https://school.programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;

public class 신고결과받기 {
    class Solution {
        public static class User{
            public int idx;
            public String from;
            public Set<String> to;

            public User(int idx, String from, Set<String> to) {
                this.idx = idx;
                this.from = from;
                this.to = to;
            }
        }

        public int[] solution(String[] id_list, String[] report, int k) {
            List<User> list = new ArrayList<>();
            int[] answer = new int[id_list.length];
            Set<String> set = new HashSet<>();
            Map<String, Integer> map = new HashMap<>();

            int idx = 0;
            for(String str: id_list) {
                list.add(new User(idx++, str, new HashSet<>()));
            }

            for(String str: report) {
                set.add(str);
            }

            for(String str : set) {
                String[] arr = str.split(" ");
                String from = arr[0];
                String to = arr[1];
                map.put(to, map.getOrDefault(to, 0) + 1);
                boolean flag = true;
                for(User user: list) {
                    if(user.from.equals(from)) {
                        user.to.add(to);
                    }
                }
            }

            for(String name: map.keySet()) {
                if(map.get(name) >= k) {
                    for(User user: list) {
                        if(user.to.contains(name)) {
                            answer[user.idx]++;
                        }
                    }
                }
            }

            return answer;

        }
    }
}
