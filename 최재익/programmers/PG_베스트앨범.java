import java.util.*;

class PG_베스트앨범 {
    public List<Integer> solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        // 해시맵 초기화
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (!map.containsKey(genre)) {
                HashMap<Integer, Integer> playMap = new HashMap<>();
                playMap.put(i, plays[i]);
                map.put(genre, playMap);
            } else {
                map.get(genre).put(i, plays[i]);
            }
        }

        List<Map.Entry<String, HashMap<Integer, Integer>>> list = new ArrayList<>(map.entrySet());

        // 해시맵을 장르별 플레이타임 총합으로 내림차순 정렬
        Collections.sort(list, new Comparator<Map.Entry<String, HashMap<Integer, Integer>>>() {
            @Override
            public int compare(Map.Entry<String, HashMap<Integer, Integer>> e1,
                               Map.Entry<String, HashMap<Integer, Integer>> e2) {
                int sum1 = 0;
                for (Integer val : e1.getValue().values()) {
                    sum1 += val;
                }

                int sum2 = 0;
                for (Integer val : e2.getValue().values()) {
                    sum2 += val;
                }

                return sum2 - sum1;
            }
        });

        // 바깥 맵 (장르별 정렬 결과 저장)
        Map<String, Map<Integer, Integer>> linkedMap = new LinkedHashMap<>();

        // 이너 해시맵을 값(내림차순) + 키(오름차순) 정렬
        for (Map.Entry<String, HashMap<Integer, Integer>> entry : list) {
            List<Map.Entry<Integer, Integer>> innerList = new ArrayList<>(entry.getValue().entrySet());

            Collections.sort(innerList, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    if (!o1.getValue().equals(o2.getValue())) {
                        return o2.getValue() - o1.getValue(); // 값 내림차순
                    } else {
                        return o1.getKey() - o2.getKey(); // 키 오름차순
                    }
                }
            });

            Map<Integer, Integer> innerLinkedMap = new LinkedHashMap<>();
            for (Map.Entry<Integer, Integer> innerEntry : innerList) {
                innerLinkedMap.put(innerEntry.getKey(), innerEntry.getValue());
            }

            linkedMap.put(entry.getKey(), innerLinkedMap);
        }

        // 최종 결과 : 장르별 상위 2곡
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Map<Integer, Integer>> entry : linkedMap.entrySet()) {
            int idx = 0;
            for (Map.Entry<Integer, Integer> innerEntry : entry.getValue().entrySet()) {
                if (idx == 2) break;
                answer.add(innerEntry.getKey());
                idx++;
            }
        }

        return answer;
    }
}
