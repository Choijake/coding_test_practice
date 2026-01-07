import java.io.*;
import java.util.*;

public class BOJ_17140 {
    static int[][]map;
    static int r, c, k;
    static int height;
    static int weight;

    static class Info{
        int number;
        int count;

        Info(int number, int count){
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[100][100];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        if(map[r-1][c-1]==k){
            System.out.print(answer);
            return;
        }

        height = 3;
        weight = 3;

        while(map[r-1][c-1]!=k && answer<=100){
            if(height>=weight){
                R();
            }
            else{
                C();
            }

//            System.out.println(height+", "+weight);
//            for(int i=0; i<100; i++){
//                for(int j=0; j<100; j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            answer++;
        }

        answer = (answer>100)?-1:answer;

        System.out.print(answer);
    }

    static void R(){

        for(int r=0; r<height; r++){
            List<Info> list = new ArrayList<>();
            Map<Integer, Integer> countMap = new HashMap<>();
            for(int c=0; c<weight; c++){
                if(map[r][c]==0)continue;
                countMap.put(map[r][c], countMap.getOrDefault(map[r][c], 0)+1);
            }

            for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
                list.add(new Info(entry.getKey(), entry.getValue()));
            }

            list.sort(
                    Comparator.comparingInt((Info i) -> i.count)
                            .thenComparing(i -> i.number)
            );

            int idx = 0;
            for(int i=0; i<list.size(); i++){
                if(idx>=100)break;
                map[r][idx++] = list.get(i).number;
                map[r][idx++] = list.get(i).count;
            }

            int size = Math.min(idx, 100);

            for(int i=idx; i<100; i++){
                map[r][i] = 0;
            }

            weight  = Math.max(weight, size);
        }
    }

    static void C(){

        for(int c=0; c<weight; c++){
            List<Info> list = new ArrayList<>();
            Map<Integer, Integer> countMap = new HashMap<>();
            for(int r=0; r<height; r++){
                if(map[r][c]==0)continue;
                countMap.put(map[r][c], countMap.getOrDefault(map[r][c], 0)+1);
            }

            for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
                list.add(new Info(entry.getKey(), entry.getValue()));
            }

            list.sort(
                    Comparator.comparingInt((Info i) -> i.count)
                            .thenComparing(i -> i.number)
            );

            int idx = 0;
            for(int i=0; i<list.size(); i++){
                if(idx>=100)break;
                map[idx++][c] = list.get(i).number;
                map[idx++][c] = list.get(i).count;
            }

            int size = Math.min(idx, 100);

            for(int i=idx; i<100; i++){
                map[i][c] = 0;
            }

            height  = Math.max(height, size);
        }
    }
}