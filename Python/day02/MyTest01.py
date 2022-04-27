
# def showdan():
#     for i in range(2,9+1): #range(1,9+1)
#         for j in range(1,9+1):
#             print(i, "*", j, "=", (i * j))
#         print()    
# showdan()

def showdan(dan):
    for i in range(1,9+1):
        print("{} * {} = {}".format(dan, i, i*dan))
    print()
    
showdan(3)
showdan(5)
showdan(8)

#고객의 요청에 능동적으로 수정할 수 있도록 되도록 for문을 안쓰는 방향으로
