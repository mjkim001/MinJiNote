# 앞 수를 넣으세요 1 enter
# 끝 수를 넣으세요 10enter
# 당신의 수의 합은 55입니다.

first = 0;
end = 0;
sum = 0;

print("두수를 입력 받아 첫번째 수 부터 두번째 수까지의 합을 구하는 연습문제")
first = int(input("앞 수를 넣으세요"))
end =  int(input("끝 수를 넣으세요"))

for i in range(first,(end+1)):
    sum+=i
print("당신의 수의 합은",sum,"입니다.")
