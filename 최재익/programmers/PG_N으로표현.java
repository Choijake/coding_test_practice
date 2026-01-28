import java.util.*;

class PG_N으로표현 {
    public int solution(int N, int number) {
        int answer = -1;

        List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        for(int i=0; i<=8; i++){
            list.add(new HashSet<Integer>());
        }
        list.get(1).add(N); 
        if(N==number)return 1;

        for(int i=2; i<=8; i++){
            HashSet<Integer> set = new HashSet<>();

            for(int j=1; j<i; j++){
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i-j);

                for(int x : a){
                    for(int y: b){
                        set.add(x+y);
                        set.add(x-y);
                        set.add(x*y);
                        if(x!=0&&y!=0)set.add(x/y);
                    }
                }

                set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }

            list.set(i, set);

            if(set.contains(number)){
                answer = i;
                break;
            }
        }

        return answer;
    }
}