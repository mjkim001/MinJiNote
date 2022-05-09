import pymysql 

conn = pymysql.connect( 
    host='127.0.0.1',
    port = 3305,
    user='root',
    password='python',
    db='python',
    charset='utf8'
) 

curs = conn.cursor() 
e_id = "5"
e_name = "6"
sex = "6"
addr = "6"
# 데이터 입력. list 형 데이터 
sql = f"""UPDATE emp 
            SET e_name = '{e_name}',
                sex = '{sex}',
                addr = '{addr}'
          WHERE e_id = '{e_id}'"""        
          
cnt = curs.execute(sql)

print("cnt",cnt)
conn.commit() 
    
# 데이터 조회 
select_sql = "select * from emp" 
curs.execute(select_sql) 
result = curs.fetchall() 

for row in result:
    print(row[0],row[1],row[2],row[3])
    
curs.close()
conn.close()
