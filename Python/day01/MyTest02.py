# 가위 바위 보를 선택하세요 가위 enter
# 나 : 가위
# 컴 : 바위
# 결과 :짐
import random

ans = "";
com = "";
res = "";

print("가위/바위/보 연습문제")
ans = input("가위 바위 보를 선택하세요")

if random.uniform(1, 3) % 1:
    com = "가위"
elif random.uniform(1, 3) % 2:
    com = "바위"
else:
    com = "보"

print("ans",ans)
print("com",com)

if ans == com:
    print("결과 : 비겼습니다.")
elif (ans == "가위" and com == "바위") or (ans == "바위" and com == "보"):
    print("결과 : 당신이 졌습니다.")
else:
    print("결과 : 당신이 이겼습니다.")

# 방법 2)
# arr = ["가위","바위","보"] 배열로 선택지를 만들어서
# 입력받은 값을 0,1,2로 변경해서
# com에서 발생시킨 난수를 비교해서 결과를 출력한다.
