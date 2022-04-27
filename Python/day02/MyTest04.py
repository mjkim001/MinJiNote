# 첫 수를 넣으세요 1 enter
# 끝 수를 넣으세요 5 enter
# 배수를 넣으세요 2 enter
# 1에서부터 5까지의 2의배수의 합은 6입니다.

first = int(input("첫 수를 넣으세요"))
end = int(input("끝 수를 넣으세요"))
num = int(input("배수를 넣으세요"))
res = 0


for i in range(first,end+1):
    if i % num == 0:
        res += i

print("{}에서부터 {}까지의 {}의배수의 합은 {}입니다.".format(first, end, num, res))