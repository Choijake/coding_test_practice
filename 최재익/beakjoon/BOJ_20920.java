import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920 {
    static class Word{
        String name;
        int count;

        public Word(String name, int count){
            this.name = name;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.length() >= M) {
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>(
                (w1, w2)-> {
                    if (w1.count != w2.count) {
                        return Integer.compare(w2.count, w1.count);
                    }
                    else if (w1.name.length() != w2.name.length()) {
                        return Integer.compare(w2.name.length(), w1.name.length());
                    }
                    else return w1.name.compareTo(w2.name);
                }
        );

        for(String key : map.keySet()){
            pq.offer(new Word(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Word word = pq.poll();
            sb.append(word.name).append("\n");
        }

        System.out.print(sb.toString());
    }
}
