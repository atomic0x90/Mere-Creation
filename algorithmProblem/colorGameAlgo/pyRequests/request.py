import requests
URL = 'https://www.color-hex.com/color/00f9ff'
response = requests.get(URL)
#print(response.status_code)
#print(response.text)

html = response.text

from bs4 import BeautifulSoup
soup = BeautifulSoup(html, 'html.parser')
for tag in soup.select('div[class=colordvconline]'):
    print(tag.text.strip())
