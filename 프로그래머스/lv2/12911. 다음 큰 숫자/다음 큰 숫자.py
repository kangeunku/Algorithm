def solution(n):
    n_2 = bin(n)[2:] # n을 2진수로 변환 [0:2]는 'ob'라서 제거
    n_2_1 = n_2.count('1') # 2진수의 1 갯수 세기
    
    count = 0    # n의 다음 큰 자연수의 1 갯수
    while n_2_1 != count:
        n +=1
        big_num_2 = bin(n)[2:]
        count = big_num_2.count('1')
        
        
    return n