import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class BOJ_1270 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            Map<Long, Integer> map = new HashMap<>();
            for(int j=0; j<t; j++){
                long number = Long.parseLong(st.nextToken());
                if(map.containsKey(number)){
                    map.put(number, map.get(number)+1);
                }
                else map.put(number, 1);
            }

            //System.out.println("["+(i+1)+"번 째]");
            boolean isRuled = false;
            for(Map.Entry<Long, Integer> entry : map.entrySet()){
                //System.out.println(entry.getKey()+": "+entry.getValue());
                if(entry.getValue()>t/2){
                    sb.append(entry.getKey()).append("\n");
                    isRuled = true;
                    break;
                }
            }
            //System.out.println();

            if(!isRuled){
                sb.append("SYJKGW").append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}