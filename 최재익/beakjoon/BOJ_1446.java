import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<D+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(e>D)continue;

            graph.get(s).add(new int[]{e, c});
        }

        int[] dist = new int[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) ->{
                    return o1[1]-o2[1];
                }
        );

        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curPos = cur[0];
            int curCost = cur[1];

            if(curCost > dist[curPos])continue;

            if(curPos+1<=D && curCost+1<dist[curPos+1]){
                dist[curPos+1] = curCost+1;
                pq.add(new int[]{curPos+1, curCost+1});
            }

            for(int[] next : graph.get(curPos)){
                int nextPos = next[0];
                int nextCost = curCost + next[1];

                if(nextCost < dist[nextPos]){
                    dist[nextPos] = nextCost;
                    pq.add(new int[]{nextPos, nextCost});
                }
            }
        }

        System.out.println(dist[D]);
    }
}
