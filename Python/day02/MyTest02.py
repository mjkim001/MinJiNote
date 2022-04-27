# 1~9까지의 수 중에서 3가지를 랜덤으로 중복없이
# 출력하시오
import random

arr = []
temp = random.randint(1, 9) #1~9까지의 랜덤 숫자
arr.append(temp)


while len(arr)!=3:
    num=0
    temp = random.randint(1, 9)
    for i in range(len(arr)):
        if arr[i] == temp:
            num = 1
    if num != 1:
            arr.append(temp)
    
    
print(arr)

