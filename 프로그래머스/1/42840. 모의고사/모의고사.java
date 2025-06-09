import java.util.*;

class Solution {
    
    static List<Integer> student1;
    static List<Integer> student2;
    static List<Integer> student3;
    public List<Integer> solution(int[] answers) {
        int[] scores = new int[3];
        List<Integer> answer = new ArrayList<>();
        // 1 2 3 4 5
        int[] pattern1 = new int[]{1,2,3,4,5};
        // 2 1 2 3 2 4 2 5
        int[] pattern2 = new int[]{2,1,2,3,2,4,2,5};
        // 3 3 1 1 2 2 4 4 5 5
        int[] pattern3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        student1 = new ArrayList<>();
        student2 = new ArrayList<>();
        student3 = new ArrayList<>();
        
        makePattern(student1, pattern1);
        makePattern(student2, pattern2);
        makePattern(student3, pattern3);
        
        scores[0] = calScore(student1, answers,0);
        scores[1] = calScore(student2, answers,0);
        scores[2] = calScore(student3, answers,0);
        
        
        int maxScore = Math.max(Math.max(scores[0],scores[1]),scores[2]);
        
        for (int i = 0; i < 3; i++){
            if (scores[i] == maxScore){
                answer.add(i + 1);
            }
        }
        Collections.sort(answer);
        
        return answer;
    }
    
    private static int calScore(List<Integer> students,int[] answers, int score){
        for (int i = 0; i < answers.length; i++){
            if (answers[i] == students.get(i)){
                score++;
            }
        }
        
        return score;
    }
    
    
    private static void makePattern(List<Integer> students, int[] arr){
         while(students.size() <= 10000){
            for (int i = 0; i < arr.length; i++){
                students.add(arr[i]);
            }
           
        }
        
        
    }
}