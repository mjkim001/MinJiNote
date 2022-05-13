
import requests
from bs4 import BeautifulSoup

url = "http://127.0.0.1:5000/list" 
html = requests.get(url)
print(html.text)

soup = BeautifulSoup(html, 'html.parser')


print(soup)