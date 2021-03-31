import selenium
import requests
from bs4 import BeautifulSoup

URL = "https://kr.investing.com/equities/amazon-com-inc-historical-data"

response = requests.get(URL, headers={"User-Agent": "Mozilla/5.0"})

print(response.status_code)
print(response.text)

html = response.text

data = []
soup = BeautifulSoup(html, 'html.parser')
for tag in soup.select('div[id=results_box]'):
    print(tag.text.strip())


for tag in soup.select('div[class=float_lang_base_1]'):
    print(tag.text.strip())
