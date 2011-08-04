def kaprekar(num):
    if num == 6174:
        return 0
    strNum = str(num).zfill(4)
    strNum = sorted(strNum)
    strRev = list(strNum)
    strNum.reverse()
    diff = abs(int(''.join(strNum)) - int(''.join(strRev)))
    return 1+ kaprekar(diff)

count = {}
for i in range(8):
    count[i] = 0
tcount = 0

file = open("report.html", 'w')        

file.write(""" <html>
            <h2>Report for Kaprekar Number iterations for all 4 digits</h2>
        """)

file.write("""<table align="left" border>""")
file.write("<tr><td>Number</td><td>Iterations</td></tr>")
for num in range(1000, 10000):
    check = sorted(str(num))
    if len(set(check)) >=2:
        score = kaprekar(num)
        count[score]+=1
        file.write("<tr><td>"+str(num)+"</td><td>"+str( score)+"</td></tr>")
        tcount+=1
file.write("""</table>""")
file.write("""<table align="left" border>""")
file.write("<tr><td>Iteration</td><td>Total Count Of Numbers</td></tr>")
for key in count:
    file.write("<tr><td>"+str(key)+"</td><td>"+str(count[key])+"</td></tr>")
file.write("</table>")
file.close()
