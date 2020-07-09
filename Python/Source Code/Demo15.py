distance = float(input("请输入距离："))
time = float(input("请输入时间："))
initial_velocity = float(input("请输入初速度："))
accelerated_speed = (distance - initial_velocity * time) * 2/time ** 2
print("加速度 = " + str(accelerated_speed))
