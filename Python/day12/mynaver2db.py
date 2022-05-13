# 네이버 검색 API예제는 블로그를 비롯 전문자료까지 호출방법이 동일하므로 blog검색만 대표로 예제를 올렸습니다.
# 네이버 검색 Open API 예제 - 블로그 검색
import os
import sys
import urllib.request
import json
from bs4 import BeautifulSoup
from day12.dao_blog import DaoBlog

blog = DaoBlog()
client_id = "jLcwvjyyMCgJxPKtcnnR"
client_secret = "HNyBY4BTTH"
encText = urllib.parse.quote("대전 오류동 맛집")
# url = "https://openapi.naver.com/v1/search/blog?query=" + encText # json 결과
url = "https://openapi.naver.com/v1/search/blog.xml?query=" + encText # xml 결과
request = urllib.request.Request(url)
request.add_header("X-Naver-Client-Id",client_id)
request.add_header("X-Naver-Client-Secret",client_secret)
response = urllib.request.urlopen(request)
rescode = response.getcode()
if(rescode==200):
    response_body = response.read()
    text = response_body.decode('utf-8')
    print(text)
    soup = BeautifulSoup(text, 'xml')
    items = soup.select("item")
    for i in items:
        title = i.select("title")[0].text
        link = i.select("link")[0].text
        description = i.select("description")[0].text
        bloggername = i.select("bloggername")[0].text
        bloggerlink = i.select("bloggerlink")[0].text
        postdate = i.select("postdate")[0].text
        cnt = blog.myinsert(title,link,description,bloggername,bloggerlink,postdate)
        print("cnt",cnt)
    # data = json.loads(text)
    # for head in data["items"]:
    #     print(head["title"].replace("<b>","").replace("</b>",""))
    
    # print(data["items"][0]["title"].replace("<b>","").replace("</b>",""))
else:
    print("Error Code:" + rescode)