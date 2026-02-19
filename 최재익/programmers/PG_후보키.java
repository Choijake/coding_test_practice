import java.util.*;

class PG_후보키 {
    static List<String> candidates;
    public int solution(String[][] relation) {
        candidates = new ArrayList<>();

        for(int i=1; i<=relation[0].length; i++){
            combination(0, i, new ArrayList<>(), relation);
        }

        return candidates.size();
    }

    static void combination(int idx, int size, List<Integer> combi, String[][] relation){
        if(combi.size()==size){
            check(combi, relation);
            return;
        }

        for(int i=idx; i<relation[0].length; i++){
            combi.add(i);
            combination(i+1, size, combi, relation);
            combi.remove(combi.size()-1);
        }
    }

    static void check(List<Integer> combi, String[][] relation){
        String key = "";
        for(Integer c : combi){
            key += String.valueOf(c);
        }

        //유일성 체크
        Map<String, Integer> map = new HashMap<>();
        for(String[] row : relation){
            String k = "";

            for(int i=0; i<combi.size(); i++){
                k += row[combi.get(i)]+" ";
            }

            if(map.containsKey(k))return;
            else map.put(k, 0);
        }

        //최소성 체크
        for(String c : candidates){
            int count = 0;

            for(int i=0; i<key.length(); i++){
                if(c.contains(String.valueOf(key.charAt(i))))count++;
            }

            if(count==c.length())return;
        }

        candidates.add(key);
        return;
    }
}