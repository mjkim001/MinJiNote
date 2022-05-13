from selenium import webdriver
from time import sleep
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
url = "http://127.0.0.1:5000/emp"
driver.get(url)

sleep(1)

trs = driver.find_elements(By.CSS_SELECTOR,"#my_tbody > tr")



for tr in trs:
    name = tr.find_elements(By.CSS_SELECTOR,"td")[1].text
    addr = tr.find_elements(By.CSS_SELECTOR,"td")[3].text
    print(name,"\t",addr)


