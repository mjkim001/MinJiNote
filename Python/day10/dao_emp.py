import pymysql
from _testcapi import MyList
class DaoEmp:
    def __init__(self):
        self.conn = pymysql.connect(host='127.0.0.1',port = 3305, user='root', password='python', db='python', charset='utf8')
        self.curs = self.conn.cursor(pymysql.cursors.DictCursor)
        
    def myselects(self):
        sql = "select e_id,e_name,sex,addr from emp"
        self.curs.execute(sql)
        rows = self.curs.fetchall()
        return rows
    
    def myselect(self,e_id):
        sql = f"""select e_id,e_name,sex,addr 
                   from emp
                  where e_id = '{e_id}'"""
        self.curs.execute(sql)
        rows = self.curs.fetchall()
        return rows[0]
    def myinsert(self, e_id, e_name, sex, addr):
        sql = f"""insert into emp(e_id, e_name, sex, addr) 
                   values ('{e_id}','{e_name}','{sex}','{addr}')"""
        cnt = self.curs.execute(sql)
        self.conn.commit() 
        return cnt
    def myupdate(self, e_id, e_name, sex, addr):
        sql = f"""UPDATE emp 
                    SET e_name = '{e_name}',
                        sex = '{sex}',
                        addr = '{addr}'
                  WHERE e_id = '{e_id}'"""
        cnt = self.curs.execute(sql)
        self.conn.commit() 
        return cnt
    def mydelete(self, e_id):
        sql = f"""DELETE FROM emp
          WHERE e_id = '{e_id}'"""  
        cnt = self.curs.execute(sql)
        self.conn.commit() 
        return cnt
    def __del__(self):
        self.curs.close()
        self.conn.close()
        
if __name__ == '__main__':
    de = DaoEmp()
    mylist = de.myselects()
    mylist2 = de.myselect(1)
    # myinsert = de.myinsert('4', '4', '4', '4')
    # myupdate = de.myupdate('5', '1', '1', '1')
    # mydelete = de.mydelete('5')
    # print("mydelete",mydelete)