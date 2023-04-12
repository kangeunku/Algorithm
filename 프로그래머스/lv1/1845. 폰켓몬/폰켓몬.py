def solution(nums):
    temp = nums
    select = len(temp) // 2
    temp_set = set(temp)
    if select <= len(temp_set):
        answer = select
    else:
        answer = len(temp_set)
    return answer