import java.util.*;
import java.io.*;

public class BOJ_2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Map<Integer, boolean[]> map = new HashMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            int d = 0;
            boolean[] light = new boolean[1001];
            while(d <= 1000){
                d += R;
                for(int idx = d; idx < d + G && idx < light.length; idx++){
                    light[idx] = true;
                }
                d += G;
            }

            map.put(D, light);
        }

        int time = 0, distance = 0;
        while(true){
            distance++;
            time++;
            
            if(distance==L)break;

            if(map.containsKey(distance)){
                boolean[] light = map.get(distance);

                if(distance < light.length && !light[distance]){
                    int d = distance;
                    while(d < light.length && !light[d] && d < L){
                        d++;
                        time++;
                    }
                }
            }
        }

        System.out.print(time);
    }
}
