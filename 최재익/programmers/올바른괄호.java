import java.util.*;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }
            else stack.push(c);
        }

        return stack.isEmpty();
    }
}
