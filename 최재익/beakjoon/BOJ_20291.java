import java.io.*;
import java.util.*;

public class BOJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
             String[] fileName = br.readLine().split("\\.");
             map.put(fileName[1], map.getOrDefault(fileName[1], 0)+1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<keySet.size(); i++){
            String key = keySet.get(i);
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }

        System.out.print(sb);
    }
}
