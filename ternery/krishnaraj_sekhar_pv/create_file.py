import subprocess

#Function for Writing the file to corresponding file
def write_to_file(num):
	filename = num[0] + ".txt"
	fp = open(filename, "a")
	fp.write(num)
	fp.close()

#Creating files. Deleting current data if file already exits.
for i in range(0,10):
	filename = str(i) + ".txt"
	fp = open(filename, "w")

#Creating a subprocess and reading the output one by one
process = subprocess.Popen(['python', 'generate.py'], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
num =""
while True:
	out = process.stdout.read(1)
	if out == '' and process.poll() != None:
		break
	if out != '':
		if out != "\n":
			num = num + out
		else:
			num= num + "\n"
			write_to_file(num)
			num = ""
