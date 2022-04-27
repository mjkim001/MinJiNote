# 1~45까지의 수 중에서 6가지를 랜덤으로 중복없이
# 출력하시오

import random

arr = []
temp = random.randint(1, 45) #1~9까지의 랜덤 숫자
arr.append(temp)


while len(arr)!=6:
    num=0
    temp = random.randint(1, 45)
    for i in range(len(arr)):
        if arr[i] == temp:
            num = 1
    if num != 1:
            arr.append(temp)
    
    
print(arr)
