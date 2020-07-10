#方式一：
num = int(input("请输入一个四位的整数:"))
ge = num % 10
shi = num // 10 % 10
bai = num // 100 %10
qian = num // 1000
result = ge + shi + bai + qian
print("每位相加的和为：" + str(result))
#方式二：
result = num % 10
result += num // 10 % 10
result += num // 100 % 10
result += num // 1000
print("结果是：" + str(result))
