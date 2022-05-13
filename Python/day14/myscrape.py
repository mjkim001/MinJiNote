import requests
from bs4 import BeautifulSoup

url = "http://127.0.0.1:5000/emp"
html = requests.get(url)

print(html.text)