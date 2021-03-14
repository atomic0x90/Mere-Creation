import requests
from bs4 import BeautifulSoup

color = str(raw_input())

suURL = "https://www.color-hex.com/color/"

URL = suURL+color
response = requests.get(URL)
#print(response.status_code)
#print(response.text)

html = response.text

data = []
soup = BeautifulSoup(html, 'html.parser')
for tag in soup.select('div[class=colordvconline]'):
    print(tag.text.strip())
    data.append(tag.text.strip())


result = [[0 for col in range(5)] for row in range(5)]


for i in range(0,5):
    if(i == 0):
        j = 0
    elif(i == 1):
        j = 2
    elif(i == 2):
        j = 4
    elif(i == 3):
        j = 6
    elif(i == 4):
        j = 8
    result[i][0] = data[j].replace('#','#ff')
    result[i][1] = data[j].replace('#','#d9')
    result[i][2] = data[j].replace('#','#b3')
    result[i][3] = data[j].replace('#','#8c')
    result[i][4] = data[j].replace('#','#66')

for i in range(0,5):
    for j in range(0,5):
        print(result[i][j])
