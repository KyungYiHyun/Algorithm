class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // 초로 치환
        int videoLen = toSecond(video_len);
        int posLen = toSecond(pos);
        int opStartLen = toSecond(op_start);
        int opEndLen = toSecond(op_end);

        
        // next
        for (String command : commands){
    
            if (command.equals("next")){
                
                // 오프닝
                if (posLen >= opStartLen && posLen <= opEndLen){
                    posLen = opEndLen;
                }
                posLen += 10;
                
                // 영상 마지막 초과
                if (posLen > videoLen){
                    posLen = videoLen;
                }    
                
                if (posLen >= opStartLen && posLen <= opEndLen){
                    posLen = opEndLen;
                }
                
            
                
                
                
            } else if (command.equals("prev")){
                
                // 오프닝
                if (posLen >= opStartLen && posLen <= opEndLen){
                    posLen = opEndLen;
                }
                
                posLen -= 10;
                
                // 영상 시작 미만
                if (posLen < 0){
                    posLen = 0;
                }    
                
                if (posLen >= opStartLen && posLen <= opEndLen){
                    posLen = opEndLen;
                }
                
           
                
            }
        }
    
        
        String ansMin = (posLen / 60) + "";
        String ansSec = (posLen % 60) + "";
        

        if (ansMin.length() == 1){
            ansMin = "0" + ansMin;
        }  
        if (ansSec.length() == 1){
            ansSec = "0" + ansSec;
        }
  
      
        return ansMin + ":" + ansSec;
    }
    
    private static int toSecond(String args){
        String[] split = args.split(":");
        Integer minute = Integer.parseInt(split[0]) * 60;
        Integer second = Integer.parseInt(split[1]);
        Integer total = minute + second;
        return total;
        
    }
}