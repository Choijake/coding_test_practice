import java.io.*;
import java.util.*;

public class BOJ_1202 {
    static int N, K;
    static List<int[]> gems;
    static List<Integer> bags;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gems = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            gems.add(new int[] {M, V});
        }

        bags = new ArrayList<>();
        for(int i=0; i<K; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bags);
        gems.sort(Comparator.comparingInt(g->g[0]));

        long total = 0L;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<K; i++){
            int bag = bags.get(i);

            while(idx<N && gems.get(idx)[0]<=bag){
                pq.add(gems.get(idx)[1]);
                idx++;
            }

            if(!pq.isEmpty()){
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}
//1. if(!pq.isEmpty()) 체크
//2. total 타입 long이어야함. 30만개 가방에 허나 당 100만이 들어가면 숫자가 int 넘음
//3. while문 조건 때문에 가방과 보석 무게 기준으로 오름차순 정렬해야함
