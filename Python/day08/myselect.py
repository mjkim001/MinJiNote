
import pymysql
from numba.core.types import none


conn = None
cur = None

sql = None

conn = pymysql.connect(host='127.0.0.1',port = 3305, user='root', password='python', db='python', charset='utf8')
cur = conn.cursor(pymysql.cursors.DictCursor)

sql = "select * from emp"
cur.execute("select * from emp")
    
rows = cur.fetchall()
print(rows)


cur.close()
conn.close()
    
        