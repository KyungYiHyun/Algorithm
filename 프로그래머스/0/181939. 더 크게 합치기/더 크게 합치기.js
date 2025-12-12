function solution(a, b) {
    var answer = 0;
    var answer1 = String(a) + b;
    var answer2 = String(b) + a;
    answer = parseInt(answer1) > parseInt(answer2) ? parseInt(answer1) : parseInt(answer2)
    return answer;
}