import java.util.*;

class PG_수식최대화_2 {
    static long answer;
    static Set<Long> ops = new HashSet<>();
    public long solution(String expression) {
        List<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<expression.length(); i++){
            if(Character.isDigit(expression.charAt(i))){
                sb.append(expression.charAt(i));
            }
            else{
                list.add(Long.parseLong(sb.toString()));
                list.add((long)expression.charAt(i));
                ops.add((long)expression.charAt(i));
                sb = new StringBuilder();
            }
        }
        list.add(Long.parseLong(sb.toString()));

        answer = 0;

        dfs(list, new HashSet<>());

        return answer;
    }

    static void dfs(List<Long> list, Set<Long> visited){
        if(list.size()==1){
            answer = Math.max(answer, Math.abs(list.get(0)));
            return;
        }

        for(Long op : ops){
            if(visited.contains(op))continue;

            int idx = 1;
            List<Long> next = new ArrayList<>(list);

            while(idx<next.size()-1){
                if(op==next.get(idx)){
                    long result = calc(next.get(idx-1), next.get(idx+1), op);
                    next.set(idx-1, result);
                    next.remove(idx);
                    next.remove(idx);
                }
                else idx+=2;
            }

            visited.add(op);
            dfs(next, visited);
            visited.remove(op);
        }
    }

    static long calc(long x, long y, long op){
        return switch ((int) op) {
            case '*' -> x * y;
            case '+' -> x + y;
            case '-' -> x - y;
            default -> 0;
        };
    }
}