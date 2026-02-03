import java.io.*;
import java.util.*;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++){
            list.add(i);
        }

        int idx = K-1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(list.size()>1){
            int cur = list.remove(idx);
            sb.append(cur+", ");

            idx = (idx-1+K)%list.size();
        }
        sb.append(list.get(0)).append(">");

        System.out.println(sb);
    }
}
