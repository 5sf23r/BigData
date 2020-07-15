year = int(input("年份："))
result = year % 4 == 0 and year % 100 != 0 or year % 400 == 0
print("是否为闰年：" + str(result))
