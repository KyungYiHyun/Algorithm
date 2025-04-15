import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++){
            queue.addLast(new Node(priorities[i],i));
        }
        System.out.println(queue);
        while(true){
            int maxNum = getMax(queue);
            Node current = queue.peekFirst();
            if (current.rank == maxNum){
                if(current.idx == location){
                    return ++answer;
                }
                answer++;
                queue.pollFirst();
            
            } else {
                queue.addLast(queue.pollFirst());
            }
        }
      
    }
    
    public int getMax(ArrayDeque<Node> q){
    int maxNum = 0;
    for (Node n : q){
        if (n.rank> maxNum){
            maxNum = n.rank;
        }
    }
    return maxNum;
}
}


class Node{
    int rank;
    int idx;
    public Node(int rank,int idx){
        this.rank = rank;
        this.idx = idx;
    }
}