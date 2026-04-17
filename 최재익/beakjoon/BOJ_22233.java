import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_22233 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            String word = br.readLine();
            set.add(word);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String[] words = br.readLine().split(",");

            for(String w : words){
                set.remove(w);
            }

            sb.append(set.size()).append("\n");
        }

        System.out.print(sb);
    }
}
