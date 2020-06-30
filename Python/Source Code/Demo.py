"""
汇率转换器
"""

#获取数据--美元
str_usd = input("请输入美元：")
int_usd= float(str_usd)
#逻辑计算--美元*7.1393
result = int_usd * 7.1393
#显示结果--人民币
print("结果是："+str(result))