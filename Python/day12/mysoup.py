
import requests
from bs4 import BeautifulSoup

url = "http://127.0.0.1:5000/list" 
html = requests.get(url)

soup = BeautifulSoup(html.text, 'html.parser')

trs = soup.find("table").find_all("tr")

for idx,tr in enumerate(trs):
    if idx > 0:
        tds = tr.find_all()
        print(tds[1].text, "\t", tds[3].text)