import java.io.*;
import java.util.*;

public class BOJ_10825 {
    static class Info{
        String name;
        int korean;
        int english;
        int math;

        public Info(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Info> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Info(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort((o1, o2) -> {
            if(o1.korean != o2.korean){
                return o2.korean-o1.korean;
            }

            if(o1.english != o2.english){
                return o1.english-o2.english;
            }

            if (o1.math != o2.math)
                return o2.math - o1.math;

            return o1.name.compareTo(o2.name);
        });

        StringBuilder sb = new StringBuilder();
        for(Info i : list){
            sb.append(i.name).append("\n");
        }

        System.out.print(sb);
    }
}
