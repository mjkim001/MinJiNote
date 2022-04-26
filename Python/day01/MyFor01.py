arr=["홍길동","전우치","이순신"]


print(arr[2])
print(arr[-1])
print(arr[-2])
print(arr[-3])

arr.append("임꺽정")
print(arr)

#arr.insert(0,"자갈치")
arr.insert(len(arr),"자갈치") # == arr.append("자갈치")
print(arr)