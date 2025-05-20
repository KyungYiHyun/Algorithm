import java.util.*;


class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : tangerine){
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());

        
        keyList.sort((o1,o2)-> map.get(o2).compareTo(map.get(o1)));

        int temp = 0;
        
        for (Integer i : keyList){
            temp += map.get(i);
            answer++;
            if (temp >= k){
                break;
            }
        }
        return answer;
    }
}