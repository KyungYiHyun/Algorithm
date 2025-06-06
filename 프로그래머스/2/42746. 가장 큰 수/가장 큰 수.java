import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> strArr = new ArrayList<>();
        for (int num : numbers){
            String s = num + "";
            strArr.add(s);
        }
        Collections.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o1 + o2).compareTo(o2 + o1);
            }
        
        });
          
        for (int i = strArr.size() - 1; i >= 0; i--){
            answer += strArr.get(i);
        }
        
        if (answer.charAt(0) == '0'){
            answer = "0";
        }
        return answer;
    }
    

}