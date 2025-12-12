function solution(str1, str2) {
    var answer = '';
    for (let i = 0; i < str1.length; i++){
        answer += str1.charAt(i) + str2.charAt(i);
        
    }
    return answer;
}