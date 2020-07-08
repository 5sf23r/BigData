str_price = input("请输入商品的单价：")
float_price = float(str_price)

str_num = input("请输入购买的数量")
int_num = int(str_num)

money = float (input ("请输入支付的金额"))

yu = money - float_price*int_num
print("应该找回钱数" + str (yu))
