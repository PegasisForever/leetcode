from subprocess import Popen, PIPE

outPut = ""
varName = "solution"
calls = eval(input())
args = eval(input())

outPut += ("val " + varName + " = " + calls[0] + "(" + ", ".join(map(str, args[0])) + ")\n")
for i in range(1, len(calls)):
    outPut += (varName + "." + calls[i] + "(" + ", ".join(map(str, args[i])) + ")\n")

p = Popen(['xsel', '-bi'], stdin=PIPE)
p.communicate(input=outPut.encode())
print("Copied to clipboard.")
