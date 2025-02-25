import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<Integer> solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, String> refMap = new HashMap<>();
        HashMap<String, Integer> moneyMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            refMap.put(enroll[i], referral[i]);
            moneyMap.put(enroll[i], 0);
        }


        for (int i = 0; i < seller.length; i++) {
            String curName = seller[i];

            int money = amount[i] * 100;

            while (money > 0 && !curName.equals("-")) {
                moneyMap.put(curName, moneyMap.get(curName) + money - (money / 10));
                curName = refMap.get(curName);

                money /= 10;
            }

        }

  
        for (String name : enroll){
            answer.add(moneyMap.get(name));
        }
        
        

        return answer;
    }
}