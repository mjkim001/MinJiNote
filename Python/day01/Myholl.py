# a = input("좋아하는 수를 입력하세요")
# print(a)


import random

rnd = random.random()
ans = input("홀수일지 짝수일지 입력해주세요 (홀/짝)")
res = ""

print(rnd);
if rnd%2 >= 0.5:
    res = "짝"
else:
    res = "홀"

if ans == res:
    print("맞췄습니다!!")
else:
    print("틀렸습니다!!")

