def solution(num):
    answer = 0 # 반복횟수

    while num != 1: # 입력값 num이 1이 될 때까지 반복
        answer += 1 # 반복횟수 계산

        if num % 2 == 0: #짝수일 때
            num = num / 2
        else:            #홀수일 때
            num = num * 3 + 1

        if answer == 500: #500번 반복에도 1이 되지 않으면 -1
            return -1
    return answer