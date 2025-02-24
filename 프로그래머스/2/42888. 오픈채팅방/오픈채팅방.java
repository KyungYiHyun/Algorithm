import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public ArrayList<String> solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        for (String s : record){
            String[] s1 = s.split(" ");
        
            if (s1[0].equals("Leave")){
                continue;
            }
            nameMap.put(s1[1],s1[2]);
        }
 

        for (String s : record){
            String[] s1 = s.split(" ");
            if (s1[0].equals("Enter")){
                String name = nameMap.get(s1[1]);
                answer.add(name + "님이 들어왔습니다.");
            } else if (s1[0].equals("Leave")) {
                String name = nameMap.get(s1[1]);
                answer.add(name + "님이 나갔습니다.");
            }
        }


        return answer;
    }
}