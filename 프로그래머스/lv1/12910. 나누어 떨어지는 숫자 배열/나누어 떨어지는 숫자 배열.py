def solution(arr, divisor):
    answer = [a for a in sorted(arr) if a % divisor == 0]
    if not answer:
        answer = [-1]
    return answer