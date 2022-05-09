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
# 데이터 입력. list 형 데이터 
insert_data = [[3, 3, 3, 3], 
               [4, 4, 4, 4]]
sql = """INSERT INTO emp(e_id,e_name,sex,addr) VALUES (%s, %s, %s, %s)""" 
cnt = curs.execute(sql, ('5','5','5','5')) 

print("cnt",cnt)
conn.commit() 


# # 데이터 수정 
# update_data = [[10, 'raul'], 
#                [7, 'zidane'], 
#                [9, 'ronaldo']]
# update_sql = "UPDATE people SET age=%s WHERE name=%s" 
# cursor.executemany(update_sql, update_data) 
# db.commit() 

# 데이터 조회 
select_sql = "select * from emp" 
curs.execute(select_sql) 
result = curs.fetchall() 

for row in result:
    print(row[0],row[1],row[2],row[3])
    
curs.close()
conn.close()
