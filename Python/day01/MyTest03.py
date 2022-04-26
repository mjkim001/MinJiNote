# 출력하고 싶은 단수를 입력하세요 6 enter
# 6*1=6....

print("구구단 연습문제")
a = int(input("출력하고 싶은 단수를 입력하세요"))

for i in range(1,10):
    print(a,"*",i,"=",(a*i))