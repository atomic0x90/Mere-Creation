import requests
from bs4 import BeautifulSoup

color = str(raw_input())

suURL = "https://www.color-hex.com/color/"

URL = suURL+color
response = requests.get(URL)
#print(response.status_code)
#print(response.text)

html = response.text

soup = BeautifulSoup(html, 'html.parser')
for tag in soup.select('div[class=colordvconline]'):
    print(tag.text.strip())
