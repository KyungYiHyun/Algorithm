import java.util.ArrayList;

class Solution {
    private static String[] wwords;
    private static int answer;
    private static String ttarget;

    public int solution(String begin, String target, String[] words) {
        answer = 51;
        wwords = words;
        ttarget = target;
        solve(begin,1);
        if (answer == 51){
            answer = 0;
        }
        return answer;
    }

    // 한글자만 다른 문자들 반환
    private static ArrayList<String> findWords(String word) {
        ArrayList<String> targetWords = new ArrayList<>();
        for (int i = 0; i < wwords.length; i++) {
            int cnt = 0;
            for (int j = 0; j < word.length(); j++) {
                if (wwords[i].charAt(j) != word.charAt(j)) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                targetWords.add(wwords[i]);
            }
        }

        return targetWords;
    }

    private static void solve(String target, int n) {
        ArrayList<String> candidates = findWords(target);
        // System.out.println("candidates = " + candidates);
        if (candidates.isEmpty()){
            return;
        }
        for (String current : candidates) {
            // System.out.println("current = " + current);
            if (current.equals(ttarget)) {
                answer = Math.min(n, answer);
                return;
            }
            if (n == target.length() + 1) {
                continue;
            }
            solve(current, n + 1);
        }


    }
}