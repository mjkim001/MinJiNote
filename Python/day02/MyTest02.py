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


# 방법 2
arr9 = [1,2,3,4,5,6,7,8,9]

for i in range(100):
    rnd = int(random.random()*9)
    a = arr9[rnd]
    b = arr9[0]
    arr9[0] = a
    arr9[rnd] = b

print(arr9[0:2+1])
#print(arr9[0],arr9[1],arr9[2])
