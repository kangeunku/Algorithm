def solution(n,a,b):
    answer = 0
    tmp = []
    for i in range(1,n+1):
        tmp.append(i)

    while n >= 2:
        answer += 1
        result = []
        for i in range(1,n+1,2):
            if tmp[i-1] == a and tmp[i] == b:
                return answer
            if tmp[i-1] == b and tmp[i] == a:
                return answer
            if tmp[i-1] == a or tmp[i] == a:
                result.append(a)
            elif tmp[i-1] == b or tmp[i] == b:
                result.append(b)
            else:
                result.append(-1)
        n = len(result)
        tmp = result
