import pandas as pd
import matplotlib.pyplot as plt

obj = pd.read_csv("/home/hduser/33356/5/fb.csv",sep=";")
print(obj.head())
print(obj.describe())
print(obj[obj.Type=="Link"].head())
ss = 	obj[obj.like>=50].head()
#scatter
fig,ax = plt.subplots()
ax.scatter(obj["Type"],obj["like"])
ax.set_title('Fb Dataset')
ax.set_xlabel('Type')
ax.set_ylabel('like')
plt.show()
#histogram
# create figure and axis
fig, ax = plt.subplots()
# plot histogram
ax.hist(obj['Post Month'])
# set title and labels
ax.set_title('Wine Review Scores')
ax.set_xlabel('Points')
ax.set_ylabel('Frequency')
plt.show()

#bar
# create figure and axis
fig, ax = plt.subplots()
# plot histogram
ax.bar(obj['Post Month'],obj['Page total likes'])
# set title and labels
ax.set_title('Wine Review Scores')
ax.set_xlabel('Points')
ax.set_ylabel('Frequency')
plt.show()

#lines
# get columns to plot
columns = obj.columns.drop(['Type'])
# create x data
x_data = range(0, obj.shape[0])
# create figure and axis
fig, ax = plt.subplots()
# plot each column
for column in columns:
    ax.plot(x_data, obj[column], label=column)
# set title and legend
ax.set_title('Fb')
ax.legend()
plt.show()


#multiploe plots

obj.plot.hist(subplots=True, layout=(2,2), figsize=(10, 10), bins=20)