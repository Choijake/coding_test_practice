import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if(o1[0]!=o2[0])return o1[0]-o2[0];
                    return o1[1]-o2[1];
                }
        );

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{s, e});
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(room.peek() <= cur[0]){
                room.poll();
            }
            room.offer(cur[1]);
        }

        System.out.println(room.size());
    }
}
