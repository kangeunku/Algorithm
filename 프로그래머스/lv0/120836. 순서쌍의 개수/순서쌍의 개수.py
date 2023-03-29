def solution(n):
    answer = 0
    for i in range(1, int(n ** 0.5) + 1):
        if n % i ==0 and n**0.5 == i:
            answer += 0.5
            continue
        if n % i ==0:
            answer +=1
        
    return answer*2