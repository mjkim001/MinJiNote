
# interprinter 방식이기 때문에 사용할 함수가 미리 선언되어 있어야한다. 

def addminmuldiv(a,b):
    return a+b,a-b,a*b,a/b

sum,min,mul,div = addminmuldiv(5,1)

print("sum",sum)
print("min",min)
print("mul",mul)
print("div",div)


ammd = addminmuldiv(5,1)

print("ammd",ammd[0])