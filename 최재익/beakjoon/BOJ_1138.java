import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int left = Integer.parseInt(st.nextToken());

            int blankCount = 0;
            for(int j=0; j<N; j++){
                if(answer[j]==-1){
                    if(blankCount==left){
                        answer[j] = i+1;
                        break;
                    }

                    blankCount++;
                }
            }
        }

        for(int i=0; i<N; i++){
            System.out.print(answer[i]+" ");
        }
    }
}
