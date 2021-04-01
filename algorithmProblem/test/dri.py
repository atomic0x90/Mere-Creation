import selenium
from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.support.select import Select

from bs4 import BeautifulSoup

URL = "https://kr.investing.com/equities/amazon-com-inc-historical-data"

#options = webdriver.ChromeOptions()
#options.add_argument('headless')
#driver = webdriver.Chrome(executable_path='/home/yujun/MyProject/Personal_Develop/algorithmProblem/test/chromedriver',chrome_options=options)
driver = webdriver.Chrome(executable_path='/home/yujun/MyProject/Personal_Develop/algorithmProblem/test/chromedriver')

driver.get(url = URL)


select = Select(driver.find_element(By.ID,"data_interval"))

STR = 'Weekly'
select.select_by_value(STR)

data = []

#for result in driver.find_elements_by_id("results_box"):
#    print(result.text)
#    data = result.text

#for result in driver.find_elements_by_tag_name("body > div > section > div > table > tbody > tr > td"):
for result in driver.find_elements_by_id("curr_table"):
    print(result.text)
    data = result.text

print(data[0])
print(data[10])
