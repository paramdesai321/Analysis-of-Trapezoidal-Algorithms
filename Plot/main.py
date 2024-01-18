import matplotlib.pyplot as plt
import csv
 
X = []
Y = []
 
with open('logs.txt', 'r') as datafile:
    plotting = csv.reader(datafile, delimiter=' ')
     
    for ROWS in plotting:
        X.append(int(ROWS[0]))
        Y.append(int(ROWS[1]))
 
plt.plot(X, Y)
plt.title("Lab 2 BenchMark")
plt.xlabel('Input Size')
plt.ylabel('Time')
plt.show()

print("done") 