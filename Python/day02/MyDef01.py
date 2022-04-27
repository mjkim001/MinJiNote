
# interprinter 방식이기 때문에 사용할 함수가 미리 선언되어 있어야한다. 

def add(a,b):
    return a+b

def minus(a,b):
    return a-b

def multiply(a,b):
    return a*b

def divide(a,b):
    return a/b


sum = add(5,1)
min = minus(5, 1)
mul = multiply(5, 1)
div = divide(5, 2)

print("sum",sum)
print("min",min)
print("mul",mul)
print("div",div)
