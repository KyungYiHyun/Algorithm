import java.util.*;
import java.util.stream.Stream;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList answer = new ArrayList();
        HashMap<String, Integer> playMap = new HashMap<>();
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++){
            if (!genreMap.containsKey(genres[i])){
                genreMap.put(genres[i],new ArrayList<>());
                playMap.put(genres[i],0);
            }
            genreMap.get(genres[i]).add(new int[]{i, plays[i]});
            playMap.put(genres[i],playMap.get(genres[i]) + plays[i]);

        }


        Stream<Map.Entry<String, Integer>> entries = playMap.entrySet()
                .stream().sorted((o1,o2)->
                        Integer.compare(o2.getValue(), o1.getValue()));

        entries.forEach(entry->{
            Stream<int[]> limit = genreMap.get(entry.getKey()).stream().sorted((o1, o2) ->
                    Integer.compare(o2[1], o1[1])).limit(2);
            limit.forEach(el-> answer.add(el[0]));
        });

        System.out.println(answer);
        return answer;
    }
}