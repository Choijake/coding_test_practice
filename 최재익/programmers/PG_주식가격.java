import java.util.*;

class PG_주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        int time = prices.length;
        for(int i=0; i<time; i++){
            while(!stack.isEmpty() && prices[stack.peek()]>prices[i]){
                answer[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty() && prices[stack.peek()]<=prices[prices.length-1]){
            answer[stack.peek()] = prices.length-1-stack.peek();
            stack.pop();
        }

        return answer;
    }
}

//조건에 prices[stack.peek()] < prices[마지막값]
//즉, 마지막 시점의 가격보다 작은 경우에만 answer를 채우도록 되어 있었음.