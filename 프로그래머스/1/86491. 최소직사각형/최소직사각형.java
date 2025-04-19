class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int[] arr : sizes){
            if (arr[0] < arr[1]){
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp; 
            }
        }
        
        for (int[] arr : sizes){
            w = Math.max(w,arr[0]);
            h = Math.max(h,arr[1]);
        }
        
                    
        
        return w * h;
    }
}