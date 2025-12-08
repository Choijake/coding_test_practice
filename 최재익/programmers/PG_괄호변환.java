import java.util.*;

class PG_괄호변환 {
    public String solution(String p) {

        return solve(p);
    }

    public String solve(String p){
        if(p.equals(""))return "";
        else if(isAlright(p))return p;

        String result = "";

        //w -> u,v 분리
        Stack<Character> stack = new Stack<>();
        int mid = 0;
        for(int i=0; i<p.length(); i++){
            if(i==0){
                stack.push(p.charAt(i));
            }
            else if(stack.isEmpty()&&i>0){
                mid = i;
                break;
            }
            else if(!stack.isEmpty()){
                if(stack.peek()!=p.charAt(i))stack.pop();
                else if(stack.peek()==p.charAt(i))stack.push(p.charAt(i));
            }
        }
        if(mid==0)mid = p.length();
        String u = p.substring(0, mid);
        String v = p.substring(mid, p.length());

        //u가 올바른 문자열 여부 체크 -> 분기
        if(isAlright(u)){
            result += (u+solve(v));
        }
        else{
            String newU = "";
            for(int i=1; i<u.length()-1; i++){
                if(p.charAt(i)=='('){
                    newU+=')';
                }
                else newU+='(';
            }
            result += ('('+solve(v)+')'+newU);
        }

        return result;
    }

    public boolean isAlright(String p){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='('){
                stack.push('(');
            }
            else if(!stack.isEmpty()&&p.charAt(i)==')'){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}