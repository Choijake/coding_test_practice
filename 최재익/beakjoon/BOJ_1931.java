import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2)->{
            if(o1[1]!=o2[1])return o1[1]-o2[1];
            else return o1[0]-o2[0];
        });



        int prevEndTime = 0;
        int answer = 0;

        for(int i=0; i<N; i++){
//            System.out.println(time[i][0]+", "+time[i][1]);

            if(time[i][0] >= prevEndTime){
                prevEndTime = time[i][1];
                answer++;
            }
        }

        System.out.print(answer);
    }
}
