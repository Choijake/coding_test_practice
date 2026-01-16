import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i<N; i++){
            String str = br.readLine();

            int prev=0;
            boolean flag = true;
            boolean[] visited = new boolean[200];
            for(int j=0; j<str.length(); j++){
                int cur = str.charAt(j);

                if(!visited[cur]){
                    visited[cur] = true;
                    prev = cur;
                }
                else{
                    if(prev!=cur) {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag)answer++;
        }

        System.out.println(answer);
    }
}
