import java.util.*;

class PG_방금그곡 {

    static class Music {
        int seq;
        int playTime;
        String name;

        public Music(int seq, int playTime, String name){
            this.seq = seq;
            this.playTime = playTime;
            this.name = name;
        }
    }

    public String solution(String m, String[] musicinfos) {
        m = changeMelody(m);

        PriorityQueue<Music> pq = new PriorityQueue<>(
                (m1, m2) -> {
                    if(m1.playTime != m2.playTime) return m2.playTime - m1.playTime;
                    else return m1.seq - m2.seq;
                }
        );

        for(int i = 0; i < musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");

            int playTime = getPlayTime(info[0], info[1]);
            String sheetInfo = changeMelody(info[3]);
            String playedMusic = getMusicSheet(sheetInfo, playTime);

            if(playedMusic.contains(m)){
                pq.add(new Music(i, playTime, info[2]));
            }
        }

        if(pq.isEmpty()) return "(None)";

        return pq.poll().name;
    }

    static String changeMelody(String oldMelody) {
        return oldMelody
                .replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");
    }

    static String getMusicSheet(String sheet, int playTime){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < playTime; i++){
            sb.append(sheet.charAt(i % sheet.length()));
        }
        return sb.toString();
    }

    static int getPlayTime(String startTime, String endTime){
        return toMin(endTime) - toMin(startTime);
    }

    static int toMin(String time){
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        return h * 60 + m;
    }
}