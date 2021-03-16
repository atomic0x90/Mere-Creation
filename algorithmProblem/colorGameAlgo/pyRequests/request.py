import requests
from bs4 import BeautifulSoup

print("Size")
matrix = int(input())
print("Number")
number = int(input())
print("Color")
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


if(matrix == 5):
    for i in range(0,5):
        if(i == 0):
            j = 18
        elif(i == 1):
            j = 15
        elif(i == 2):
            j = 0
        elif(i == 3):
            j = 5
        elif(i == 4):
            j = 8
        result[i][0] = data[j].replace('#','#ff')
        result[i][1] = data[j].replace('#','#d4')
        result[i][2] = data[j].replace('#','#a8')
        result[i][3] = data[j].replace('#','#7d')
        result[i][4] = data[j].replace('#','#52')
        # 17% down 18 15 0 5 8
elif(matrix == 4):
    for i in range(0,4):
        if(i == 0):
            j = 15
        elif(i == 1):
            j = 0
        elif(i == 2):
            j = 5
        elif(i == 3):
            j = 7
        result[i][0] = data[j].replace('#','#ff')
        result[i][1] = data[j].replace('#','#d4')
        result[i][2] = data[j].replace('#','#a8')
        result[i][3] = data[j].replace('#','#7d')
        # 17% down

if(matrix == 5):
    for i in range(0,5):
        for j in range(0,5):
            print("<color name=\"c5_5_"+str(number)+"_"+str(i+1)+"_"+str(j+1)+"\">"+result[i][j]+"</color>")
elif(matrix == 4):
    for i in range(0,4):
        for j in range(0,4):
            print("<color name=\"c4_4_"+str(number)+"_"+str(i+1)+"_"+str(j+1)+"\">"+result[i][j]+"</color>")



