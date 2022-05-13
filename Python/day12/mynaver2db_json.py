# 네이버 검색 API예제는 블로그를 비롯 전문자료까지 호출방법이 동일하므로 blog검색만 대표로 예제를 올렸습니다.
# 네이버 검색 Open API 예제 - 블로그 검색
import os
import sys
import urllib.request
import json

from day12.dao_blog import DaoBlog

blog = DaoBlog()

client_id = "jLcwvjyyMCgJxPKtcnnR"
client_secret = "HNyBY4BTTH"
encText = urllib.parse.quote("대전 오류동 맛집")
url = "https://openapi.naver.com/v1/search/blog?query=" + encText # json 결과
# url = "https://openapi.naver.com/v1/search/blog.xml?query=" + encText # xml 결과
request = urllib.request.Request(url)
request.add_header("X-Naver-Client-Id",client_id)
request.add_header("X-Naver-Client-Secret",client_secret)
response = urllib.request.urlopen(request)
rescode = response.getcode()
if(rescode==200):
    response_body = response.read()
    text = response_body.decode('utf-8')
    print(text)
    data = json.loads(text)
    for head in data["items"]:
        title = head["title"]
        link = head["link"]
        description = head["description"]
        bloggername = head["bloggername"]
        bloggerlink = head["bloggerlink"]
        postdate = head["postdate"]
        cnt = blog.myinsert(title,link,description,bloggername,bloggerlink,postdate)
        print("cnt",cnt)
        
else:
    print("Error Code:" + rescode)