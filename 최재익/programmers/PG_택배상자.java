import java.util.*;

class PG_택배상자 {
    public int solution(int[] order) {
        int answer = 0;

        int[] seq = new int[order.length];
        for(int i=0; i<order.length; i++){
            seq[order[i]-1] = i;
        }

        Stack<Integer> stack = new Stack<>();
        int t = 0;
        for(int i=0; i<seq.length; i++){
            if(seq[i]==t){
                answer++;
                t++;
            }else{
                stack.push(seq[i]);
            }

            while(!stack.isEmpty() && stack.peek()==t){
                stack.pop();
                answer++;
                t++;
            }
        }

        return answer;
    }
}