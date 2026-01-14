import java.io.*;
import java.util.*;

public class BOJ_1755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> toStr = new HashMap<>();
        toStr.put(0, "zero");
        toStr.put(1, "one");
        toStr.put(2, "two");
        toStr.put(3, "three");
        toStr.put(4, "four");
        toStr.put(5, "five");
        toStr.put(6, "six");
        toStr.put(7, "seven");
        toStr.put(8, "eight");
        toStr.put(9, "nine");

        Map<String, String> toNum = new HashMap<>();
        toNum.put("zero", "0");
        toNum.put("one", "1");
        toNum.put("two", "2");
        toNum.put("three", "3");
        toNum.put("four", "4");
        toNum.put("five", "5");
        toNum.put("six", "6");
        toNum.put("seven", "7");
        toNum.put("eight", "8");
        toNum.put("nine", "9");


        List<String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int num=N; num<=M; num++){
            if(num>=1 && num<=9){
                list.add(toStr.get(num));
            }
            else{
                String str = toStr.get(num/10) + " " + toStr.get(num%10);
                list.add(str);
            }
        }

        Collections.sort(list);

        int idx=1;
        for(int i=0; i<list.size(); i++){
            String[] arr = list.get(i).split(" ");

            String num = "";
            for(String s : arr){
                num+=toNum.get(s);
            }

            if(idx++%10!=0){
                System.out.print(num+" ");
            }
            else System.out.println(num);
        }
    }
}
