
import pymysql
from numba.core.types import none


conn = None
cur = None

sql = None

conn = pymysql.connect(host='127.0.0.1',port = 3305, user='root', password='python', db='python', charset='utf8')
cur = conn.cursor()

sql = "select * from emp"
cur.execute("select * from emp")

print("아이디  이름   성별   주소")
print("--------------------")

while True:
    row = cur.fetchone()
    if row==None:
        break
    data1 = row[0]
    data2 = row[1]
    data3 = row[2]
    data4 = row[3]
    print(data1,data2,data3,data4)
    
conn.close()
    
        