import pymysql
from _testcapi import MyList
class DaoBlog:
    def __init__(self):
        self.conn = pymysql.connect(host='127.0.0.1',port = 3305, user='root', password='python', db='python', charset='utf8')
        self.curs = self.conn.cursor(pymysql.cursors.DictCursor)
        
    def myinsert(self, title, link, description, bloggername, bloggerlink, postdate):
        sql = f"""insert into blog(title, link, description, bloggername, bloggerlink,postdate) 
                   values ('{title}','{link}','{description}','{bloggername}','{bloggerlink}','{postdate}')"""
        cnt = self.curs.execute(sql)
        self.conn.commit() 
        return cnt
    
    def __del__(self):
        self.curs.close()
        self.conn.close()
        
if __name__ == '__main__':
    db = DaoBlog()
    cnt = db.myinsert('1', '1', '1','1', '1', '1')
    # myinsert = de.myinsert('4', '4', '4', '4')
    # myupdate = de.myupdate('5', '1', '1', '1')
    # mydelete = de.mydelete('5')
    # print("mydelete",mydelete)