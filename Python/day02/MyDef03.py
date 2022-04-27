import random

def myRandom():
    temp = random.random()
    if temp > 0.5:
        return 0
    else:
        return 1
        
#0또는 1을 호출한다.    
rnd = myRandom()
print(rnd)

#random.randint(0, 1+1)
